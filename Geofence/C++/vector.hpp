#ifndef VECTOR_H
#define VECTOR_H
#include <iostream>

class Vector {
  public:
	float x, y;

	/*
		Create a vector with components x, y.
	*/
	Vector(float x, float y);

	/*
		Prompts the user via stdout and stdin to enter a vector.
		Users the name parameter to tell the user what they're inputting.
	*/
	Vector(const char *text);

	/*
		Returns a rescaled version of the vector with magnitude 1.
	*/
	Vector normalized();

	/*
		Returns a vector normal to this one with the same magnitude.
	*/
	Vector normal();

	/*
		Returns the slope of the vector.
	*/
	float slope();

	/*
		Returns the magnitude of the vector.
	*/
	float magnitude();

	Vector operator+(const Vector &vec);
	Vector operator*(float k);
	Vector operator-(const Vector &vec);
	Vector operator-();
	float operator/(const Vector &vec);
};
std::ostream &operator<<(std::ostream &out, const Vector &vec);
Vector operator*(float k, const Vector &vec);

#endif