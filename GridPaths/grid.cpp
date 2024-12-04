#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef pair<int, int> pii;
#define pb push_back

int N;
int MOD = 1000000007;

int main() {
  // freopen("grid.in", "r", stdin);
  // freopen("grid.out", "w", stdout);

  cin >> N;

  vector<vector<ll>> dp(N+1, vector<ll>(N+1));
  dp[0][1] = 1;
  for (int i = 0; i < N; i++) {
    string line;
    cin >> line;

    for (int j = 0; j < N; j++) {
      if (line[j] == '.') {
        dp[i+1][j+1] = dp[i][j+1] + dp[i+1][j];
        dp[i+1][j+1] %= MOD;
      }
    }
  }

  cout << dp[N][N] << endl;

  return 0;
}