import java.util.LinkedList;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

public class ConcertTickets {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    // Scanner sc = new Scanner(new java.io.File("1.in"));
    
    int N = sc.nextInt();
    int M = sc.nextInt();
    
    NavigableMap<Integer, Integer> tickets = new TreeMap<>();
    
    for (int i = 0; i < N; i++) {
      int curTicket = sc.nextInt();
      if (tickets.containsKey(curTicket)) {
        tickets.put(curTicket, tickets.get(curTicket)+1);
      } else {
        tickets.put(curTicket, 1);
      }
    }
    
    for (int i = 0; i < M; i++) {
      int cur = sc.nextInt();
      var curTicket = tickets.lowerEntry(cur+1);
      if (curTicket != null) {
        System.out.println(curTicket.getKey());
        if (curTicket.getValue() == 1) {
          tickets.remove(curTicket.getKey());
        } else {
          tickets.put(curTicket.getKey(), curTicket.getValue()-1);
        }
      } else {
        System.out.println(-1);
      }
    }
    
    sc.close();
  }
}
