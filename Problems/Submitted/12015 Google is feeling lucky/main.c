#include <stdio.h>

int main() {
	int tc;
	scanf("%d", &tc);
	for (int a = 1; a <= tc; a++) {
		int max = 0;
		int candidates = 0;
		char sites[10][101];
		int ratings[10];

		for (int p = 0; p < 10; p++) {
			scanf("%s %d", &sites[p], &ratings[p]);
			if (ratings[p] > max)
				max = ratings[p];
		}
		printf("Case #%d:\n", a);
		for (int p = 0; p < 10; p++) {
			if (ratings[p] == max) {
				puts(sites[p]);
			}
		}
	}

	return 0;
}