import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SumOfTwoValues {

  public static void main(String[] args) throws Exception {
//    Scanner sc = new Scanner(new java.io.File("1.in"));
    Scanner sc = new Scanner(System.in);
    
    int N = sc.nextInt();
    int X = sc.nextInt();
    
    HashMap<Integer, Integer> numToIdx = new HashMap<>();
    int[] numsSorted = new int[N];
    for (int i = 0; i < N; i++) {
      int num = sc.nextInt();
      numToIdx.put(num, i);
      numsSorted[i] = num;
    }
    
    Arrays.sort(numsSorted);
    boolean found = false;
    for (int i = 0; i < N; i++) {
      int curNum = numsSorted[i];
      // binary search
      int searchResult = Arrays.binarySearch(numsSorted, X-curNum);
      if (searchResult > -1 && searchResult != i) {
        System.out.println(numToIdx.get(curNum)+1 + " " + (numToIdx.get(X-curNum)+1));
        found = true;
        break;
      }
    }
    
    if (!found) {
      System.out.println("IMPOSSIBLE");
    }
    
    sc.close();
  }

}
