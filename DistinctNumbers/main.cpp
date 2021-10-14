#include <iostream>
#include <set>
using namespace std;

int N;
set<long> numberSet;

int main() {
  // freopen("main.in", "r", stdin);
  // freopen("main.out", "w", stdout);

  cin >> N;

  int count = 0;
  for (int i = 0; i < N; i++) {
    int curNum;
    cin >> curNum;
    if (numberSet.find(curNum) == numberSet.end()) {
      numberSet.insert(curNum);
      count++;
    }
  }

  cout << count << endl;

  return 0;
}