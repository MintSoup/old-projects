#include "robot.hpp"
#include <iostream>
#include <math.h>
using namespace std;
int main() {

	double field_length = 10;

	Robot a(0, Vector(0, 5), 1);
	Robot b(180, Vector(field_length, 5), 1);

	double t = 0;
	cout << a.velocity << b.velocity << endl;
	while (1) {
		a.step();
		b.step();
		t += Robot::dt;
		//cout << a.position << b.position << endl;
		if (a.position.x > field_length || a.position.x < 0) {
			cout << "a left the arena at" << a.position << ", t= " << t << endl;
			exit(0);
		}
		if (b.position.x > field_length || b.position.x < 0) {
			cout << "b left the arena at" << b.position << ", t=" << t << endl;
			exit(0);
		}
		if ((a.position - b.position).magnitude() < 0.0000001) {
			Vector c((a.position.x + b.position.x) / 2,
					 (a.position.y, b.position.y) / 2);
			cout << "Collision at " << c << "at time t=" << t << endl;
			exit(0);
		}
	}
	return 0;
}
