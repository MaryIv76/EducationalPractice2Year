package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {

    Point start;
    Point end;

    public Segment(Point start, Point end) {

        if (start.getX() == end.getX() && start.getY() == end.getY()) {
            throw new IllegalArgumentException();
        }
        this.start = start;
        this.end = end;
    }

    double length() {
        return Math.sqrt(Math.pow(start.getX() - end.getX(), 2) + Math.pow(start.getY() - end.getY(), 2));
    }

    Point middle() {
        double middleX;
        double middleY;

        double halfX = Math.abs(end.getX() - start.getX()) / 2;
        if (start.getX() < end.getX()) {
            middleX = start.getX() + halfX;
        } else {
            middleX = end.getX() + halfX;
        }

        double halfY = Math.abs(end.getY() - start.getY()) / 2;
        if (start.getY() < end.getY()) {
            middleY = start.getY() + halfY;
        } else {
            middleY = end.getY() + halfY;
        }

        return new Point(middleX, middleY);
    }

    Point intersection(Segment another) {

        double denominator = (another.end.getY() - another.start.getY()) * (this.end.getX() - this.start.getX()) - (another.end.getX() - another.start.getX()) * (this.end.getY() - this.start.getY());
        if (denominator == 0) {
            return null;
        }

        double u1 = ((another.end.getX() - another.start.getX()) * (this.start.getY() - another.start.getY()) - (another.end.getY() - another.start.getY()) * (this.start.getX() - another.start.getX())) / denominator;
        double u2 = ((this.end.getX() - this.start.getX()) * (this.start.getY() - another.start.getY()) - (this.end.getY() - this.start.getY()) * (this.start.getX() - another.start.getX())) / denominator;
        if (!(u1 >= 0 && u1 <= 1) || !(u2 >= 0 && u2 <= 1)) {
            return null;
        }

        double x = this.start.getX() + u1 * (this.end.getX() - this.start.getX());
        double y = this.start.getY() + u1 * (this.end.getY() - this.start.getY());
        return new Point(x, y);
    }

}
