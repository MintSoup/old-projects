import math


class Vector:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    @classmethod
    def ask(self, name):
        x = float(input(name + " x="))
        y = float(input(name + " y="))
        return Vector(x, y)

    def __add__(self, other):
        return Vector(self.x + other.x, self.y + other.y)

    def __mul__(self, k):
        return Vector(self.x * k, self.y*k)

    def __sub__(self, other):
        return self+(-1*other)

    def __truediv__(self, other):
        return self.x / other.x

    def __rmul__(self, k):
        return Vector(self.x * k, self.y*k)

    def __abs__(self):
        return math.sqrt(self.x**2+self.y**2)

    def __neg__(self):
        return -1*self

    def normalized(self):
        scaleFactor = 1 / abs(self)
        return Vector(self.x*scaleFactor, self.y*scaleFactor)

    def slope(self):
        return self.y / self.x

    def normal(self):
        inverseSlope = -1/self.slope()
        return Vector(1, inverseSlope).normalized()*abs(self)

    def __str__(self):
        return "({},{})".format(self.x, self.y)
