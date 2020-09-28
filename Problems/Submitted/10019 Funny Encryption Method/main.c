#include <stdio.h>
int main() {
	char num[15] = {0};

	int cases;
	scanf("%d", &cases);
	for (; cases > 0; cases--) {
		scanf("%s", num);

		int nd;
		sscanf(num, "%d", &nd);
		int b1 = 0;
		while (nd > 0) {
			if (nd % 2 == 1) {
				b1++;
			}
			nd >>= 1;
		}

		sscanf(num, "%x", &nd);
		int b2 = 0;
		while (nd > 0) {
			if (nd % 2 == 1) {
				b2++;
			}
			nd >>= 1;
		}

		printf("%d %d\n", b1, b2);
	}
	return 0;
}