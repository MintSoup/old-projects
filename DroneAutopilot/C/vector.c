#include "vector.h"
#include <math.h>
#define degree 111319.44444

struct Vector startingPoint;

// turns lat,long vector into an x,y vector
struct Vector cartisionalized(struct Vector vec) {
	vec.x -= startingPoint.x;
	vec.x *= degree;
	vec.y -= startingPoint.y;
	vec.y *= degree;
	return vec;
}
struct Vector normalized(struct Vector vec) {
	double scaleFactor = 1 / magnitude(vec);
	vec.x *= scaleFactor;
	vec.y *= scaleFactor;
	return vec;
}
struct Vector normal(struct Vector vec) {

	if (slope(vec) == INFINITY || slope(vec) == -INFINITY) {
		return createVector(vec.y, 0);
	} else if (slope(vec) == 0) {
		return createVector(0, vec.x);
	} else {
		struct Vector ret = normalized(createVector(1, -1 / slope(vec)));
		ret.x *= magnitude(vec);
		ret.y *= magnitude(vec);

		if (vec.y < 0) {
			ret.x *= -1;
			ret.y *= -1;
		}
		return ret;
	}
}

double magnitude(struct Vector vec) {
	return sqrt(vec.x * vec.x + vec.y * vec.y);
}

struct Vector createVector(double x, double y) {
	struct Vector r;
	r.x = x;
	r.y = y;
	return r;
}

double slope(struct Vector vec) {
	if (vec.x != 0)
		return vec.y / vec.x;
	else if (vec.y >= 0)
		return INFINITY;
	else
		return -INFINITY;
}

double divide(struct Vector vec1, struct Vector vec2) {
	if (slope(vec1) == INFINITY)
		return vec1.y / vec2.y;
	else
		return vec1.x / vec2.x;
}
struct Vector difference(struct Vector vec1, struct Vector vec2) {
	return createVector(vec1.x - vec2.x, vec1.y - vec2.y);
}