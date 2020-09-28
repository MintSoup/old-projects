from vector import Vector


startingPoint = Vector.ask("p0")
path = (Vector.ask("p1")-startingPoint)
pathC = startingPoint.y - path.slope()*startingPoint.x
directionVector = path.normalized().normal()



while True:
    print()
    ourPosition = Vector.ask("our position")

    normalC = ourPosition.y - path.normal().slope()*ourPosition.x

    normalUnitVector = path.normal().normalized()

    intersectionX = (pathC - normalC) / (path.normal().slope() - path.slope())
    intersectionY = path.slope() * intersectionX + pathC

    interSectionPoint = Vector(intersectionX, intersectionY)

    ourLocationOnNewCSystem = (ourPosition-interSectionPoint) / normalUnitVector

    print(interSectionPoint)

    print(ourLocationOnNewCSystem)
