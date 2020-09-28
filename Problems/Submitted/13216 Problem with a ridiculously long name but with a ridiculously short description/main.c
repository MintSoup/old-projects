#include <math.h>
#include <stdio.h>
#include <string.h>
int main() {
	int cases;
	scanf("%d", &cases);
	for (; cases > 0; cases--) {
		char lol[1200];
		scanf("%s", lol);
		if (!strcmp(lol, "0")) {
			puts("1");
		} else if (!strcmp(lol, "1")) {
			puts("66");
		} else {
			int num = lol[strlen(lol) - 1] - '0';
			if ((num) % 5 == 0) {
				puts("76");
			} else if ((num) % 5 == 1) {
				puts("16");
			} else if ((num) % 5 == 2) {
				puts("56");
			} else if ((num) % 5 == 3) {
				puts("96");
			} else if ((num) % 5 == 4) {
				puts("36");
			}
		}
	}
	return 0;
}