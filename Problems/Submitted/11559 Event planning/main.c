#include <math.h>
#include <stdio.h>
int main() {
	int n;
	int budget;
	int hotels;
	int weeks;
	while (scanf("%d %d %d %d", &n, &budget, &hotels, &weeks) == 4) {

		int stonks = 6000000;

		for (int h = 0; h < hotels; h++) {

			int priceFor1;
			scanf("%d", &priceFor1);

			int totalcost = n * priceFor1;
			for (int w = 0; w < weeks; w++) {
				int rooms;
				scanf("%d", &rooms);
				if (totalcost < budget && rooms >= n) {
					stonks = fmin(stonks, totalcost);
				}
			}
		}
		if (stonks <= budget) {
			printf("%d\n", stonks);
		} else
			puts("stay home");
	}

	return 0;
}