import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RestaurantCustomers {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(new java.io.File("1.in"));
//    Scanner sc = new Scanner(System.in);
    
    int N = sc.nextInt();
    Customer[] customers = new Customer[N];
    
    for (int i = 0; i < N; i++) {
      customers[i] = new Customer(sc.nextInt(), sc.nextInt());
    }
    
    Arrays.sort(customers, (c1, c2) -> {return c1.arrive - c2.arrive;});
    
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.add(Integer.MAX_VALUE);
    int result = 0;
    for (Customer c : customers) {
      while (pq.peek() <= c.arrive) {
        pq.poll();
      }
      pq.add(c.leave);
      result = Math.max(pq.size(), result);
    }
    
    System.out.println(result-1);
    
    sc.close();
  }

  
  private static class Customer {
    int arrive;
    int leave;
    public Customer(int a, int l) {
      arrive = a;
      leave = l;
    }
    
    @Override
    public String toString() {
      return String.format("%d %d", arrive, leave);
    }
  }
}
