import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CountingRoomsClass {

  public static void main(String[] args) throws Exception {
//    Scanner sc = new Scanner(new java.io.File("1.in"));
    Scanner sc = new Scanner(System.in);
    
    int N = sc.nextInt();
    int M = sc.nextInt();
    
    Cell[][] grid = new Cell[N+2][M+2];
    
    for (int i = 1; i < N+1; i++) {
      char[] curLine = sc.next().toCharArray();
      
      for (int j = 1; j < M+1; j++) {
        grid[i][j] = new Cell(curLine[j-1] == '.');
      }
    }
    
    
    for (int i = 1; i < N+1; i++) {
      for (int j = 1; j < M+1; j++) {
        grid[i][j].left = grid[i][j-1];
        grid[i][j].right = grid[i][j+1];
        grid[i][j].down = grid[i+1][j];
        grid[i][j].up = grid[i-1][j];
      }
    }
    
    long rooms = 0;
    
    for (int i = 1; i < N+1; i++) {
      for (int j = 1; j < M+1; j++) {
        if (!grid[i][j].floor || grid[i][j].visited) continue;
        rooms++;
        Queue<Cell> q = new LinkedList<>();
        
        q.add(grid[i][j]);
        grid[i][j].visited = true;
        
        while (!q.isEmpty()) {
          Cell curCell = q.poll();
          
          if (curCell.left != null && !curCell.left.visited && curCell.left.floor) {
            q.add(curCell.left);
            curCell.left.visited = true;
          }
          if (curCell.right != null && !curCell.right.visited && curCell.right.floor) {
            q.add(curCell.right);
            curCell.right.visited = true;
          }
          if (curCell.up != null && !curCell.up.visited && curCell.up.floor) {
            q.add(curCell.up);
            curCell.up.visited = true;
          }
          if (curCell.down != null && !curCell.down.visited && curCell.down.floor) {
            q.add(curCell.down);
            curCell.down.visited = true;
          }
        }
      }
    }
    
    System.out.println(rooms);
    
    sc.close();

  }
  
  private static class Cell {
    Cell left;
    Cell right;
    Cell up;
    Cell down;
    boolean floor;
    boolean visited = false;
    
    public Cell(boolean f) {
      floor = f;
    }
    
    @Override
    public String toString() {
      return floor ? "." : "#";
    }
  }

}
