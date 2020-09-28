struct Vector {
	double x;
	double y;
};


struct Vector cartisionalized(struct Vector vec);
struct Vector normalized(struct Vector vec);
struct Vector normal(struct Vector vec);
double magnitude(struct Vector vec);
struct Vector createVector(double x, double y);
double slope(struct Vector vec);
double divide(struct Vector vec1, struct Vector vec2);
struct Vector difference(struct Vector vec1, struct Vector vec2);

