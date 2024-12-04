#include <bits/stdc++.h>

using namespace std;
using ll = long long;
using pii = pair<int, int>;

const int MOD = 1e9 + 7;

int N, M;

int i_[] = {1, 0, -1, 0};
int j_[] = {0, 1, 0, -1};

int main() {
  // freopen("labyrinth.in", "r", stdin);
  // freopen("labyrinth.out", "w", stdout);

  cin >> N >> M;

  vector<vector<bool>> lab(N+2, vector<bool>(M+2, true));
  int si, sj, ei, ej;
  for (int i = 1; i <= N; i++) {
    string s; cin >> s;
    for (int j = 1; j <= M; j++) {
      if (s[j-1] == '.') {
        lab[i][j] = false;
      } else if (s[j-1] == 'A') {
        si = i; sj = j;
        lab[i][j] = false;
      } else if (s[j-1] == 'B') {
        ei = i; ej = j;
        lab[i][j] = false;
      }
    }
  }

  vector<vector<pii>> prev(N+2, vector<pii>(M+2, {-1, -1}));
  queue<pii> q;
  q.push({si, sj});

  while (!q.empty()) {
    pii cur = q.front(); q.pop();

    if (cur.first == ei && cur.second == ej) break;

    for (int i = 0; i < 4; i++) {
      int ni = cur.first + i_[i];
      int nj = cur.second + j_[i];

      if (!lab[ni][nj] && prev[ni][nj] == make_pair(-1, -1)) {
        prev[ni][nj] = cur;
        q.push({ni, nj});
      }
    }
  }

  if (prev[ei][ej] == make_pair(-1, -1)) {
    cout << "NO" << endl;
    return 0;
  }

  pii cur = {ei, ej};

  vector<char> dir;

  while (cur != make_pair(si, sj)) {
    pii p = prev[cur.first][cur.second];
    if (cur.first == p.first) {
      if (cur.second == p.second + 1) {
        dir.push_back('R');
      } else {
        dir.push_back('L');
      }
    } else {
      if (cur.first == p.first + 1) {
        dir.push_back('D');
      } else {
        dir.push_back('U');
      }
    }
    cur = prev[cur.first][cur.second];
  }

  cout << "YES" << endl << dir.size() << endl;
  for (int i = dir.size()-1; i >= 0; i--) {
    cout << dir[i];
  }

  cout << endl;

  return 0;
}