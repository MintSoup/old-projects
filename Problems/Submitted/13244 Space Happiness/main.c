#include <stdio.h>
#include <string.h>

typedef unsigned long long int ll;
int main() {
	ll cases;
	scanf("%lld", &cases);
	while (cases--) {
		ll i;
		scanf("%lld", &i);
		ll n = (i + 1) / 2;
		ll cost = n * (1 + i) / 2;
		cost += (n - 1) * (i - 1) / 2;
		printf("%lld\n", cost);
	}

	return 0;
}