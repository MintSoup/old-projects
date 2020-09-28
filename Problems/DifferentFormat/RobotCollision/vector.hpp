#ifndef VECTOR_HPP
#define VECTOR_HPP
#include <iostream>

class Vector {
  public:
	double x, y;

	/*
		Create a blank vector (0,0)
	*/

	Vector();

	/*
		Create a vector with components x, y.
	*/

	Vector(double x, double y);

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
	double slope();

	/*
		Returns the magnitude of the vector.
	*/
	double magnitude();

	Vector operator+(const Vector &vec);
	Vector operator*(double k);
	Vector operator-(const Vector &vec);
	Vector operator-();
	double operator/(const Vector &vec);
};
std::ostream &operator<<(std::ostream &out, const Vector &vec);
Vector operator*(double k, const Vector &vec);

#endif