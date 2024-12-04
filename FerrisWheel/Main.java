import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException{
    Scanner in = new Scanner(System.in);

    int N = in.nextInt();
    int x = in.nextInt();
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = in.nextInt();
    }

    Arrays.sort(arr);

    int r = N - 1;
    int l = 0;
    int count = 0;

    while (l <= r) {
      if (l == r) {
        count++;
        break;
      }
      if (arr[r] + arr[l] > x) {
        r--;
        count++;
      } else {
        r--;
        l++;
        count++;
      }
    }
    System.out.println(count);
    in.close();
  }
}