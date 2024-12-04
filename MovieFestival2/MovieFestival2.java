import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

public class MovieFestival2 {
  static StreamTokenizer st;
  static int N;
  static int K;

  public static void main(String[] args) throws Exception {
    // read input
    // BufferedReader br = new BufferedReader(new FileReader("moviefestival2.in"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StreamTokenizer(br);
    // PrintWriter pw = new PrintWriter(new File("moviefestival2.out"));
    N = nextInt();
    K = nextInt();
    
    // solve
    int[][] movies = new int[N][2];
    for (int i = 0; i < N; i++) {
      movies[i][0] = nextInt();
      movies[i][1] = nextInt();
    }

    Arrays.sort(movies, (int[] a, int[] b) -> a[1] - b[1]);

    boolean[] visited = new boolean[N];

    int total = 0;
    for (int i = 0; i < K; i++) {
      int maxEnd = 0;

      for (int j = 0; j < N; j++) {
        if (visited[j]) continue;
        
        if (movies[j][0] >= maxEnd) {
          maxEnd = movies[j][1];
          total++;
          visited[j] = true;
        }
      }
    }

    System.out.println(total);

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