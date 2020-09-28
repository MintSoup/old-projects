#include <stdbool.h>
#include <stdint.h>
#include <stdio.h>
int main() {
	while (1) {
		uint32_t i;
		scanf("%u", &i);
		if (i) {
			printf("The parity of ");
			int parity = 0;
			bool leadingZero = true;
			uint32_t checkAgainst = 1u << 31;
			while (checkAgainst) {
				if (i & checkAgainst) {
					printf("1");
					parity++;
					leadingZero = false;
				} else {
					if(!leadingZero) printf("0");
				}
				checkAgainst >>= 1;
			}
			printf(" is %d (mod 2).\n", parity);
		} else
			break;
	}
	return 0;
}
