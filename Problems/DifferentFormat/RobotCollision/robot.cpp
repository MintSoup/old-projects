#include "robot.hpp"
#include <math.h>
Robot::Robot(double angle, Vector position, double speed) : position(position) {
	this->velocity =
		Vector(cos(M_PI / 180 * angle), sin(M_PI / 180 * angle)) * speed;
}

void Robot::step() {
	position = position + (dt * velocity);
	if (position.y <= 0 || position.y >= ceiling) {
		velocity.y *= -1;
	}
}