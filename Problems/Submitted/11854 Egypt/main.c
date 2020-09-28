#include <math.h>
#include <stdio.h>
int main() {
	while (1) {
		int x, y, z;
		scanf("%d %d %d", &x, &y, &z);
		if (!x || !y || !z)
			break;

		int a = fmin(x, fmin(y, z));
		int c = fmax(x, fmax(y, z));
		int b;
		if (a == x) {
			if (c == y)
				b = z;
			else if (c == z)
				b = y;
		}
		else if (a == y) {
			if (c == x)
				b = z;
			else if (c == z)
				b = x;
		}
		else if (a == z) {
			if (c == x)
				b = y;
			else if (c == y)
				b = x;
		}

		if (a * a + b * b == c * c)
			puts("right");
		else
			puts("wrong");
	}
	return 0;
}