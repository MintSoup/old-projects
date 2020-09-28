#include "vector.hpp"
#include <math.h>

Vector::Vector(float x, float y) : x(x), y(y) {}
Vector::Vector(const char *text) {
	float x, y;
	std::cout << text << " x=";
	std::cin >> x;
	std::cout << text << " y=";
	std::cin >> y;
	this->x = x;
	this->y = y;
}

Vector Vector::normal() {

	if (slope() == INFINITY || slope() == -INFINITY) {
		return Vector(y, 0);
	} else if (slope() == 0) {
		return Vector(0, x);
	} else {
		Vector ret = Vector(1, -1 / slope()).normalized() * magnitude();
		if (y < 0)
			ret = -ret;
		return ret;
	}
}

Vector Vector::normalized() {
	float scaleFactor = 1 / magnitude();
	return Vector(x * scaleFactor, y * scaleFactor);
}

float Vector::slope() {
	if (x != 0)
		return y / x;
	else
		return INFINITY;
}

float Vector::magnitude() { return sqrt(x * x + y * y); }

// operator overloads

Vector Vector::operator+(const Vector &vec) {
	return Vector(x + vec.x, y + vec.y);
}

Vector Vector::operator*(float k) { return Vector(x * k, y * k); }

Vector operator*(float k, const Vector &vec) {
	return Vector(vec.x * k, vec.y * k);
}

Vector Vector::operator-(const Vector &vec) {
	return Vector(x - vec.x, y - vec.y);
}

Vector Vector::operator-() { return -1 * Vector(x, y); }

float Vector::operator/(const Vector &vec) {
	if (slope() == INFINITY)
		return y / vec.y;
	else
		return x / vec.x;
}

std::ostream &operator<<(std::ostream &out, const Vector &vec) {

	out << "(" << vec.x << ", " << vec.y << ")";
	return out;
}
