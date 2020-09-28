#include <math.h>
#include <stdio.h>

double pi;
const double R = 6371009;
// 43.466667 -80.516667 30.058056 31.228889
double haversine(double lat1, double lon1, double lat2, double lon2) {

	double dLat = (lat2 - lat1) * pi / 180.0;
	double dLon = (lon2 - lon1) * pi / 180.0;

	lat1 = (lat1)*pi / 180.0;
	lat2 = (lat2)*pi / 180.0;

	double a =
		pow(sin(dLat / 2), 2) + pow(sin(dLon / 2), 2) * cos(lat1) * cos(lat2);

	double c = 2 * asin(sqrt(a));
	return R * c;
}

int main() {
	pi = acos(-1);
	int cases;
	scanf("%d", &cases);

	while (cases--) {
		double lat1, lon1, lat2, lon2;

		scanf("%lf %lf %lf %lf", &lat1, &lon1, &lat2, &lon2);
		double dGreat = haversine(lat1, lon1, lat2, lon2);

		lat1 *= pi / 180;
		lon1 *= pi / 180;
		lat2 *= pi / 180;
		lon2 *= pi / 180;

		double x1 = R * cos(lat1) * cos(lon1);
		double y1 = R * cos(lat1) * sin(lon1);
		double z1 = R * sin(lat1);

		double x2 = R * cos(lat2) * cos(lon2);
		double y2 = R * cos(lat2) * sin(lon2);
		double z2 = R * sin(lat2);

		double dstraight = pow(x1 - x2, 2) + pow(y1 - y2, 2) + pow(z1 - z2, 2);
		dstraight = sqrt(dstraight);

		printf("%d\n", (int)round(dGreat - dstraight));
	}

	return 0;
}