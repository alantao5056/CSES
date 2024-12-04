#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef pair<int, int> pii;
#define pb push_back

int N, M;

class Node {
  public:
    int id;
    vector<int> nbs;
    int prev = 0;
    Node(){};
    Node(int x) {
      id = x;
    }
};

int main() {
  // freopen("route.in", "r", stdin);
  // freopen("route.out", "w", stdout);

  cin >> N >> M;
  vector<Node> nodes(N+1);
  for (int i = 1; i <= N; i++) {
    Node n(i);
    nodes[i] = n;
  }

  for (int i = 0; i < M; i++) {
    int a, b;
    cin >> a >> b;

    nodes[a].nbs.pb(b);
    nodes[b].nbs.pb(a);
  }

  queue<int> q;
  q.push(1);
  nodes[1].prev = -1;
  while (!q.empty()) {
    int cur = q.front(); q.pop();
    if (cur == N) break;
    Node* node = &nodes[cur];
    for (int nb : node->nbs) {
      if (nodes[nb].prev == 0) {
        nodes[nb].prev = cur;
        q.push(nb);
      }
    }
  }

  if (nodes[N].prev == 0) {
    cout << "IMPOSSIBLE" << endl;
  } else {
    vector<int> result;
    int cur = N;
    while (cur != -1) {
      result.pb(cur);
      cur = nodes[cur].prev;
    }

    cout << result.size() << endl;

    for (int i = result.size()-1; i > 0; i--) {
      cout << result[i] << ' ';
    }

    cout << result[0] << endl;
  }

  return 0;
}