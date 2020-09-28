#include <stdio.h>
#include <string.h>

int validHouse(int n) {

	int nums[10] = {0};

	while (n > 0) {
		if (++nums[n % 10] > 1) {
			return 0;
		} else
			n /= 10;
	}

	return 1;
}

int main() {
	int m, n;
	int validHouses[5001] = {0};
	for (int i = 0; i < 5001; ++i) {
		validHouses[i] = validHouses[i - 1] + validHouse(i);
	}

	while (scanf("%d %d", &m, &n) == 2) {
		printf("%d\n", validHouses[n] - validHouses[m - 1]);
	}
	return 0;
}