#ifndef GEOFENCE_H
#define GEOFENCE_H

#include <stdint.h>
typedef struct Point {
	float x;
	float y;
} Point;

// returns an odd number if the point is inside the geofence
// else even
int intersectionsWithGeofence(Point p, Point pgon[], uint32_t sides);
Point p(float x, float y);

#endif