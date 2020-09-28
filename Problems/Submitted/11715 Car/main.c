#include <math.h>
#include <stdio.h>
int main() {

	int type;
	double n1, n2, n3;
	int n = 1;
	while (1) {
		scanf("%d", &type);
		if (type == 0) {
			break;
		}
		scanf("%lf %lf %lf", &n1, &n2, &n3);

		if (type == 1) {
			double v0 = n1;
			double v = n2;
			double t = n3;

			double a = (v - v0) / t;
			double S = v0 * t + (a * t * t) / 2;

			printf("Case %d: %.3lf %.3lf\n", n++, S, a);
		} else if (type == 2) {
			double v0 = n1;
			double v = n2;
			double a = n3;

			double t = (v - v0) / a;
			double S = v0 * t + (a * t * t) / 2;
			
			printf("Case %d: %.3lf %.3lf\n", n++, S, t);
		} else if (type == 3) {
			double v0 = n1;
			double a = n2;
			double S = n3;

			double t1 = (-v0 + sqrt(v0 * v0 + 2 * a * S)) / a;
			double t2 = (-v0 - sqrt(v0 * v0 + 2 * a * S)) / a;

			double t = fmax(t1, t2);

			double v = v0 + a * t;

			printf("Case %d: %.3lf %.3lf\n", n++, v, t);
		} else if (type == 4) {
			double v = n1;
			double a = n2;
			double S = n3;

			double v0 = sqrt(v * v - 2 * a * S);
			double t = (v - v0) / a;

			printf("Case %d: %.3lf %.3lf\n", n++, v0, t);
		}
	}

	return 0;
}