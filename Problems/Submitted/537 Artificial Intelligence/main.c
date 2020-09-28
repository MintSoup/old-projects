#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int findeq(char *str) {
	for (int i = 0; i < strlen(str); i++) {
		if (str[i] == '=')
			return i;
	}
	return -1;
}

int main() {

	bool current = 0, voltage = 0, power = 0;
	double vcurrent, vvoltage, vpower;
	int problem = 1;
	int problemstodo;
	scanf("%d", &problemstodo);
	while (1) {

		char buf[20] = {0};
		scanf("%s", buf);
		size_t len = strlen(buf);

		if (len >= 4) {
			int eq = findeq(buf);
			if (eq != -1) {
				double k = 1;
				memcpy(buf, buf + eq - 1, len - eq + 1);
				buf[len - eq + 1] = 0;
				len = strlen(buf);

				if (buf[len - 1] == '.' || buf[len - 1] == ',') {
					buf[len - 1] = 0;
					len--;
				}

				if (buf[len - 2] == 'm') {
					k = 0.001;
				} else if (buf[len - 2] == 'M') {
					k = 1000000;
				} else if (buf[len - 2] == 'k') {
					k = 1000;
				}

				if (buf[0] == 'I' && buf[len - 1] == 'A') {
					current = 1;
					char valueStr[15] = {0};
					memcpy(valueStr, &buf[2], k == 1 ? len - 3 : len - 4);
					sscanf(valueStr, "%lf", &vcurrent);
					vcurrent *= k;

				} else if (buf[0] == 'U' && buf[len - 1] == 'V') {
					voltage = 1;

					char valueStr[15] = {0};
					memcpy(valueStr, &buf[2], k == 1 ? len - 3 : len - 4);
					sscanf(valueStr, "%lf", &vvoltage);
					vvoltage *= k;
				} else if (buf[0] == 'P' && buf[len - 1] == 'W') {
					power = 1;

					char valueStr[15] = {0};
					memcpy(valueStr, &buf[2], k == 1 ? len - 3 : len - 4);
					sscanf(valueStr, "%lf", &vpower);
					vpower *= k;
				}
				if (voltage && current) {
					printf("Problem #%d\nP=%.2fW\n\n", problem,
						   vvoltage * vcurrent);
					current = voltage = power = 0;
					problem++;

				} else if (voltage && power) {
					printf("Problem #%d\nI=%.2fA\n\n", problem,
						   vpower / vvoltage);
					current = voltage = power = 0;
					problem++;

				} else if (power && current) {
					printf("Problem #%d\nU=%.2fV\n\n", problem,
						   vpower / vcurrent);
					current = voltage = power = 0;
					problem++;
				}
				if (problem > problemstodo)
					return 0;
			}
		}
	}

	return 0;
}