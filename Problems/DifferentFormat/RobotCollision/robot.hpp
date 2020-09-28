#ifndef ROBOT_HPP
#define ROBOT_HPP

#include "vector.hpp"

class Robot {
  public:
	Vector position;
	Vector velocity;

	/*
		Simulation time step;
	*/
	static const constexpr double dt = 0.0000001;

	/*
	   Ceiling y coordinate, will bounce off after hitting it;
   */
	static const constexpr int ceiling = 25;
	Robot(double angle, Vector position, double speed);

	void step();
};

#endif