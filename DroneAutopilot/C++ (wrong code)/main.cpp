#include "vector.h"
#include <iostream>
#include <math.h>
#include <windows.h>

void set_roll(float roll);
void set_pitch(float pitch);
Vector gps();

using std::cout;
using std::endl;


Vector zeroCoordinates = Vector(44.528868, 40.223698);

int main() {

	// Vector init = gps("initial\n");
	Vector init(0, 0);
	set_pitch(scale * 0.4);
	Sleep(100);
	set_pitch(0);
	// Vector newPos = gps("new\n");
	Vector newPos(44.528633, 40.224018);
	newPos = newPos - zeroCoordinates;
	newPos = newPos * 111319.44444;

	Vector forward = (newPos - init).normalized();
	Vector right = forward.normal();

	Vector target(44.528271, 40.223935);
	target = target - zeroCoordinates;
	target = target * 111319.44444;

	while (1) {
		// normali karucum
		Vector pathNormal = (target - init).normal().normalized();
		// uxxi havasarman hashvarkner (y=mx+c)
		double pathC = init.y - (target - init).slope() * init.x;
		double normalC = newPos.y - newPos.x * pathNormal.slope();
		// hatman keti coodrinatner
		double intersectX =
			(pathC - normalC) / (pathNormal.slope() - (target - init).slope());
			
		Vector intersection(intersectX,
							intersectX * pathNormal.slope() + normalC);
		// hatman ketic heravorutyun
		double crossTrackError = (intersection - newPos) / pathNormal;
		double intersectionToTarget =
			(target - intersection) / (target - init).normalized();

		Vector wayToGo = Vector(crossTrackError, intersectionToTarget);
		cout << wayToGo.normalized() << endl;
		break;
	}

	return 0;
}

Vector gps(const char *text) {
	Vector f = Vector(text);
	f = f - zeroCoordinates;
	f = f * 111319.44444;
	return f;
}
