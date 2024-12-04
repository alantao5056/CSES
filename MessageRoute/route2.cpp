#include <bits/stdc++.h>

using namespace std;
using ll = long long;
using pii = pair<int, int>;

const int MOD = 1e9 + 7;

int N, M;

int main() {
  // freopen("route.in", "r", stdin);
  // freopen("route.out", "w", stdout);

  cin >> N >> M;

  vector<vector<int>> adj(N);

  for (int i = 0; i < M; i++) {
    int a, b; cin >> a >> b; a--; b--;
    adj[a].push_back(b);
    adj[b].push_back(a);
  }

  vector<int> prev(N, -1);

  queue<int> q;
  q.push(0);
  prev[0] = -2;

  while (!q.empty()) {
    int cur = q.front(); q.pop();
    if (cur == N-1) {
      break;
    }

    for (int nb : adj[cur]) {
      if (prev[nb] == -1) {
        prev[nb] = cur;
        q.push(nb);
      }
    }
  }

  if (prev[N-1] == -1) {
    cout << "IMPOSSIBLE" << endl;
    return 0;
  }

  vector<int> path;
  int cur = N-1;
  while (cur != -2) {
    path.push_back(cur);
    cur = prev[cur];
  }

  cout << path.size() << endl;
  for (int i = path.size()-1; i >= 0; i--) {
    cout << path[i]+1 << " ";
  }

  return 0;
}