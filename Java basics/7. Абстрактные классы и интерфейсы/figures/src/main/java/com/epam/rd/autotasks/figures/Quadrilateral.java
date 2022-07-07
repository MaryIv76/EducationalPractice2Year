package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {

    private Point a;
    private Point b;
    private Point c;
    private Point d;
    private double lengthAB;
    private double lengthAC;
    private double lengthBC;
    private double lengthCD;
    private double lengthAD;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.lengthAB = Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
        this.lengthAC = Math.sqrt(Math.pow(a.getX() - c.getX(), 2) + Math.pow(a.getY() - c.getY(), 2));
        this.lengthBC = Math.sqrt(Math.pow(c.getX() - b.getX(), 2) + Math.pow(c.getY() - b.getY(), 2));
        this.lengthCD = Math.sqrt(Math.pow(c.getX() - d.getX(), 2) + Math.pow(c.getY() - d.getY(), 2));
        this.lengthAD = Math.sqrt(Math.pow(a.getX() - d.getX(), 2) + Math.pow(a.getY() - d.getY(), 2));
    }

    @Override
    public double area() {
        double halfPerimeterFirstTriangle = (lengthAB + lengthAC + lengthBC) / 2;
        double areaFirstTriangle = Math.sqrt(halfPerimeterFirstTriangle * (halfPerimeterFirstTriangle - lengthAB) * (halfPerimeterFirstTriangle - lengthAC) * (halfPerimeterFirstTriangle - lengthBC));
        double halfPerimeterSecondTriangle = (lengthCD + lengthAC + lengthAD) / 2;
        double areaSecondTriangle = Math.sqrt(halfPerimeterSecondTriangle * (halfPerimeterSecondTriangle - lengthCD) * (halfPerimeterSecondTriangle - lengthAC) * (halfPerimeterSecondTriangle - lengthAD));
        return areaFirstTriangle + areaSecondTriangle;
    }

    @Override
    public String pointsToString() {
        return a.toString() + b.toString() + c.toString() + d.toString();
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
        if (d.getX() < leftPoint.getX()) {
            leftPoint = d;
        }
        return leftPoint;
    }

    public String toString() {
        return "Quadrilateral[" + pointsToString() + "]";
    }
}
