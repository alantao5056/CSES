#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
  int N, X;

  cin >> N >> X;
  
  vector<int> arr(N);
  for (int i = 0; i < N; i++) {
    cin >> arr[i];
  }

  sort(arr.begin(), arr.end());

  int r = N - 1;
  int l = 0;
  int count = 0;

  while (l <= r) {
    if (arr[r] + arr[l] > X) {
      r--;
      count++;
    } else {
      r--;
      l++;
      count++;
    }
  }

  cout << count << endl;

  return 0;
}