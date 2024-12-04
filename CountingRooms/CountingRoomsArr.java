import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CountingRoomsArr {
  public static void main(String[] args) throws Exception{
//    Scanner sc = new Scanner(new java.io.File("1.in"));
    Scanner sc = new Scanner(System.in);
    
    int N = sc.nextInt();
    int M = sc.nextInt();
    
    char[][] grid = new char[N+2][M+2];
    boolean[][] visited = new boolean[N+2][M+2];
    
    for (int i = 1; i < N+1; i++) {
      char[] curLine = sc.next().toCharArray();
      
      for (int j = 1; j < M+1; j++) {
        grid[i][j] = curLine[j-1];
      }
    }
    
    long rooms = 0;
    
    for (int i = 1; i < N+1; i++) {
      for (int j = 1; j < M+1; j++) {
        if (grid[i][j] == '#' || grid[i][j] == '\u0000' || visited[i][j]) continue;
        
        rooms++;
        Queue<Integer> x = new LinkedList<>(); 
        Queue<Integer> y = new LinkedList<>();
        
        x.add(i);
        y.add(j);
        visited[i][j] = true;
        
        while (!x.isEmpty()) {
          int curI = x.poll();
          int curJ = y.poll();
          
          if (grid[curI-1][curJ] == '.' && !visited[curI-1][curJ]) {x.add(curI-1); y.add(curJ); visited[curI-1][curJ] = true;}
          if (grid[curI][curJ-1] == '.' && !visited[curI][curJ-1]) {x.add(curI); y.add(curJ-1); visited[curI][curJ-1] = true;}
          if (grid[curI+1][curJ] == '.' && !visited[curI+1][curJ]) {x.add(curI+1); y.add(curJ); visited[curI+1][curJ] = true;}
          if (grid[curI][curJ+1] == '.' && !visited[curI][curJ+1]) {x.add(curI); y.add(curJ+1); visited[curI][curJ+1] = true;}
        }
      }
    }
    System.out.println(rooms);
    
    sc.close();
  }
}
