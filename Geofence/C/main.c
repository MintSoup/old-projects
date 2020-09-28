#include "geofence.h"
#include <math.h>
#include <stdio.h>
int main() {

	Point pgon[] = {
		p(1, 1), p(3, -3), p(7, -1), p(10, -2), p(12, 1), p(6, 4),
	};

	printf("%d", intersectionsWithGeofence(p(3, -1.5), pgon, sizeof(pgon) / sizeof(*pgon)));

	return 0;
}