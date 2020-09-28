#include <stdio.h>

int main() {

	int tc;
	scanf("%d", &tc);
	for (; tc > 0; tc--) {
		int m, n;
		scanf("%d %d", &m, &n);
		if (m > n)
			puts(">");
		else if (m < n)
			puts("<");
		else
			puts("=");
	}

	return 0;
}