#include "geofence.h"
#include <math.h>
#include <stdint.h>

int intersectionsWithGeofence(Point cp, Point pgon[], uint32_t sides) {

	// number of raycast intersections
	uint8_t intersections = 0;

	// raycast: draw a ray from cp
	// y=cp.y
	// count how many times it intersects with the edges of our polygon
	// if odd: we're inside the polygon
	// else outside
	for (uint32_t i = 0; i < sides; i++) {
		// utility pointers to the vertices of the edge we're checking
		// against
		Point *p1 = &(pgon[i]);
		Point *p2;
		if (i < sides - 1)
			p2 = &(pgon[i + 1]);
		else
			p2 = &pgon[0];

		// check if ray intersects with our edge
		if ((cp.y >= fmin(p1->y, p2->y)) && (cp.y < fmax(p1->y, p2->y))) {
			float slope = (p1->y - p2->y) / (p1->x - p2->x);
			float c = p1->y - slope * p1->x;
			float xAtY = (cp.y - c) / slope;
			if (cp.x <= xAtY)
				intersections++;
		}
	}
	return intersections;
}

Point p(float x, float y) {
	Point a;
	a.x = x;
	a.y = y;
	return a;
}