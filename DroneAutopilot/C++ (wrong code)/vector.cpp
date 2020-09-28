#include "vector.h"
#include <math.h>


Vector::Vector(double x, double y) : x(x), y(y) {}
Vector::Vector(const char *text) {
	double x, y;
	std::cout << text << " x=";
	std::cin >> x;
	std::cout << text << " y=";
	std::cin >> y;
	this->x = x;
	this->y = y;
}

Vector Vector::normal() {

	if (slope() == INFINITY) {
		return Vector(magnitude(), 0);
	} else if (slope() == 0) {
		return Vector(0, magnitude());
	} else {
		return (Vector(1, -1 / slope()).normalized()) * magnitude();
	}
}

Vector Vector::normalized() {
	double scaleFactor = 1 / magnitude();
	return Vector(x * scaleFactor, y * scaleFactor);
}

double Vector::slope() {
	if (x != 0)
		return y / x;
	else
		return INFINITY;
}

double Vector::magnitude() { return sqrt(x * x + y * y); }

// operator overloads

Vector Vector::operator+(const Vector &vec) {
	return Vector(x + vec.x, y + vec.y);
}

Vector Vector::operator*(double k) { return Vector(x * k, y * k); }

Vector operator*(double k, const Vector &vec) {
	return Vector(vec.x * k, vec.y * k);
}

Vector Vector::operator-(const Vector &vec) {
	return Vector(x - vec.x, y - vec.y);
}

Vector Vector::operator-() { return -1 * Vector(x, y); }

double Vector::operator/(const Vector &vec) {
	if (slope() == INFINITY)
		return y / vec.y;
	else
		return x / vec.x;
}

std::ostream &operator<<(std::ostream &out, const Vector &vec) {

	out << "(" << vec.x << ", " << vec.y << ")";
	return out;
}
