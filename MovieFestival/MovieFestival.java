import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

public class MovieFestival {
  static StreamTokenizer st;
  static int N;

  public static void main(String[] args) throws Exception {
    // read input
    // BufferedReader br = new BufferedReader(new FileReader("moviefestival.in"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StreamTokenizer(br);
    // PrintWriter pw = new PrintWriter(new File("moviefestival.out"));
    N = nextInt();
    
    // solve
    int[][] movies = new int[N][2];
    for (int i = 0; i < N; i++) {
      movies[i][1] = nextInt();
      movies[i][0] = nextInt();
    }
    Arrays.sort(movies, (int[] a, int[] b) -> a[0]-b[0]);

    int maxEnd = 0;
    int count = 0;
    for (int i = 0; i < N; i++) {
      if (movies[i][1] >= maxEnd) {
        count++;
        maxEnd = movies[i][0];
      }
    }

    System.out.println(count);

    br.close();
    // pw.close();
  }

  private static int nextInt() throws Exception {
    st.nextToken();
    return (int) st.nval;
  }

  private static String nextString() throws Exception {
    st.nextToken();
    return st.sval;
  }
}