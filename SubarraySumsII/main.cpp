#include <iostream>
#include <vector>
#include <map>

using namespace std;

int main() {
	// freopen("main.in", "r", stdin);
  // freopen("main.out", "w", stdout);

	int N, X;
	cin >> N >> X;
	vector<int> arr(N);
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}

	long long prefix_sum = 0;
	long long ans = 0;
	map<long long, int> sums;
	sums[0] = 1;
	for (int x : arr) {
		prefix_sum += x;
		ans += sums[prefix_sum - X];
		sums[prefix_sum]++;
	}
	cout << ans << endl;
}