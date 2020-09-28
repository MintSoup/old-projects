#include "vector.hpp"
#include <iostream>
#include <math.h>
using namespace std;
int main() {
	Vector p0("Path point 0");
	Vector path = Vector("Path point 1") - p0;

	float pathC = p0.y - path.slope() * p0.x;
	Vector normalUnitVector = path.normal().normalized();

	while (1) {
		cout << endl;
		float crossTrackError;
		Vector currentPosition("Current Position");

		if (path.slope() == 0) {
			crossTrackError = p0.y - currentPosition.y;
			if (path.x < 0)
				crossTrackError *= -1;

		} else if (path.slope() == INFINITY || path.slope() == -INFINITY) {
			crossTrackError = currentPosition.x - p0.x;
			if (path.slope() < 0)
				crossTrackError *= -1;
		}

		else {
			float normalC = currentPosition.y -
							normalUnitVector.slope() * currentPosition.x;

			float intersectionX =
				(pathC - normalC) / (normalUnitVector.slope() - path.slope());
			float intersectionY = path.slope() * intersectionX + pathC;

			Vector intersectionPoint(intersectionX, intersectionY);
			cout << intersectionPoint << endl;
			crossTrackError =
				(currentPosition - intersectionPoint) / normalUnitVector;
		}
		cout << "CTE=" << crossTrackError << "		//feed this into PID loop"
			 << endl;
	}

	return 0;
}