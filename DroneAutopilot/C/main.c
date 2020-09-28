#include "vector.h"
#include <math.h>
#include <stdio.h>

int main() {

	extern struct Vector startingPoint;
	startingPoint = createVector(44.530018, 40.223680);

	struct Vector forward = normalized(createVector(1e-15, -1));
	struct Vector right = normal(forward);

	struct Vector ourPos = createVector(0, 0);
	struct Vector target = cartisionalized(createVector(44.530017, 40.223679));

	// calculate slopes of the forward and right vectors of the drone
	double forwardSlope = slope(forward);
	double rightSlope = slope(right);

	// calculates the C of the line that passes through our target point and is
	// parallel to the forward direction of the drone
	double targetForwardParallelC = target.y - target.x * forwardSlope;

	// calculate the C of the line that passes through the drone and is normal
	// to the line that we just calculated the C of. This line
	// will be parallel to the "right" direction of the drone
	double normalC = ourPos.y - ourPos.x * rightSlope;

	// calculate the point where the normal and parallel lines meet
	double intersectionX =
		(targetForwardParallelC - normalC) / (rightSlope - forwardSlope);
	double intersectionY =
		intersectionX * forwardSlope + targetForwardParallelC;

	struct Vector intersection = createVector(intersectionX, intersectionY);

	// calculate how much right and forward we should go to reach our target
	double CTE = divide(difference(intersection, ourPos), right);
	double intersectionToTarget =
		divide(difference(intersection, target), forward);

	printf("intersection at(%f, %f)\n", intersection.x, intersection.y);

	printf("move (%f, %f)", CTE, -intersectionToTarget);
	return 0;
}