#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N, M, K;

int solve(vector<int> applicants, vector<int> apartments) {
  int ia = 0;
  int ib = 0;
  int count = 0;

  while (ia < N && ib < M) {
    if (applicants[ia] - K <= apartments[ib] && applicants[ia] + K >= apartments[ib]) {
      // avaliable apartment
      ia++;
      ib++;
      count++;
    } else if (applicants[ia] < apartments[ib]) {
      ia++;
    } else {
      ib++;
    }
  }

  return count;
}

int main() {
  // freopen("main.in", "r", stdin);
  // freopen("main.out", "w", stdout);

  cin >> N >> M >> K;

  vector<int> applicants(N);
  vector<int> apartments(M);

  for (int i = 0; i < N; i++) {
    cin >> applicants[i];
  }

  for (int i = 0; i < M; i++) {
    cin >> apartments[i];
  }

  sort(applicants.begin(), applicants.end());
  sort(apartments.begin(), apartments.end());

  cout << solve(applicants, apartments) << endl;

  return 0;
}