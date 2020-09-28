#include <math.h>
#include <stdio.h>

long long s(long long d) {
	if (d < 10)
		return d;
	else
		return s(d / 10) + d % 10;
}

int main() {
	while (1) {
		long long m, n;
		scanf("%lld %lld", &m, &n);
		if (m + n == 0)
			break;
		long long sum = 0;
		for (; n >= m; n--) {
			sum += s(n);
		}
		printf("%d\n", sum);
	}
	return 0;
}