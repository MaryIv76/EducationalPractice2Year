package com.epam.rd.autotasks.figures;

class Triangle extends Figure {

    private Point a;
    private Point b;
    private Point c;
    private double lengthAB;
    private double lengthAC;
    private double lengthBC;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.lengthAB = Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
        this.lengthAC = Math.sqrt(Math.pow(a.getX() - c.getX(), 2) + Math.pow(a.getY() - c.getY(), 2));
        this.lengthBC = Math.sqrt(Math.pow(c.getX() - b.getX(), 2) + Math.pow(c.getY() - b.getY(), 2));
    }

    private double perimeter() {
        return this.lengthAB + this.lengthAC + this.lengthBC;
    }

    @Override
    public double area() {
        double halfPerimeter = perimeter() / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - lengthAB) * (halfPerimeter - lengthAC) * (halfPerimeter - lengthBC));
    }

    @Override
    public String pointsToString() {
        return a.toString() + b.toString() + c.toString();
    }

    @Override
    public Point leftmostPoint() {
        Point leftPoint = a;
        if (b.getX() < leftPoint.getX()) {
            leftPoint = b;
        }
        if (c.getX() < leftPoint.getX()) {
            leftPoint = c;
        }
        return leftPoint;
    }

    public String toString() {
        return "Triangle[" + pointsToString() + "]";
    }
}
