#include <math.h>
#include <stdio.h>
#include <stdlib.h>
int main() {

	int *a = (int *)malloc(1000001 * sizeof(int));
	a[0] = 1;

	for (int i = 1; i < 1000001; i++) {
		a[i] = a[(int)floor(i - sqrt(i))] + a[(int)floor(log(i))] +
			   a[(int)floor(i * sin(i) * sin(i))];
		a[i] %= 1000000;
	}

	while (1) {
		int x;
		scanf("%d", &x);
		if (x == -1)
			break;
		printf("%d\n", a[x]);
	}
	return 0;
}