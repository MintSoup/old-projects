#include "vector.hpp"
#include <array>
#include <cmath>
#include <cstdint>
#include <iostream>
using std::cout;
using std::endl;

int main() {
	cout << "Geofence and current point are hardcoded inside the main.cpp file."
		 << endl
		 << endl;

	// points of our geofence polygon
	// hard coded
	

	// number of sides of our pgon
	uint32_t sides = sizeof(pgon) / sizeof(*pgon);

	cout << "Using geofence:" << endl;
	for (uint32_t i = 0; i < sides; i++) {
		cout << pgon[i] << endl;
	}
	while (1) {

		// our current location, ie the point to check if it is inside the
		// polygon
		Vector cp("Enter current location: ");
		// number of raycast intersections
		uint8_t intersections = 0;

		// raycast: draw a ray from cp
		// y=cp.y
		// count how many times it intersects with the edges of our polygon
		// if odd: we're inside the polygon
		// else outside
		for (uint8_t i = 0; i < sides; i++) {
			// utility pointers to the vertices of the edge we're checking
			// against
			Vector *p1 = &(pgon[i]);
			Vector *p2;
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

		// print '1' if we're inside the geofence
		//'2' if inside not
		cout << "Point" << cp << " is";
		if (!(intersections % 2))
			cout << " not";
		cout << " inside the geofence" << endl << endl;
	}
	return 0;
}