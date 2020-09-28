#include <math.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
double factoriallog2(unsigned int a) {
	double log = 0;
	for (a = a; a > 1; a--) {
		log += log2(a);
	}
	return log;
}

int main() {
	int f = 1960;
	while (1) {
        int bits;
		bits = f;

		scanf("%d", &bits);
		if (bits == 0) {
			exit(0);
		} else if (bits % 2160 < 10) {
			printf("254016\n");
		} else if (bits % 2150 < 10) {
			printf("134480\n");
		} else if (bits % 2140 < 10) {
			printf("71421\n");
		} else if (bits % 2130 < 10) {
			printf("38064\n");
		} else if (bits % 2120 < 10) {
			printf("20366\n");
        } else if (bits % 2110 < 10) {
			printf("10944\n");
		} else {

			bits -= 1960;
			bits /= 10;
			bits += 2;
			bits = pow(2, bits);

			for (int n = 6;;n += 20) {
				bool f = 0;
				if (factoriallog2(n) > bits) {
					for (int i = n - 5;; i-=5) {
						if (factoriallog2(i + 4) < bits) {
							printf("%d\n", i + 4);
							f = 1;
							break;
						}
						else if (factoriallog2(i + 3) < bits) {
							printf("%d\n", i + 3);
							f = 1;
							break;
						}
						else if (factoriallog2(i + 2) < bits) {
							printf("%d\n", i + 2);
							f = 1;
							break;
						}
						else if (factoriallog2(i + 1) < bits) {
							printf("%d\n", i + 1);
							f = 1;
							break;
						}
						else if (factoriallog2(i) < bits) {
							printf("%d\n", i);
							f = 1;
							break;
						}

						if (f){
                            break;
						}
					}
				}
				if (f)
					break;
			}
		}
		f++;
		if (f > 2160) {
			//exit(0);
		}
	}
	return 0;
}
