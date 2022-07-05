package com.epam.rd.autotasks.intersection;

public class Line {

    int k;
    int b;

    public Line(int k, int b) {
        this.k = k;
        this.b = b;
    }

    public Point intersection(Line other) {

        if (this.k == other.k) {
            return null;
        }

        int x = (other.b - this.b) / (this.k - other.k);
        int y = this.k * x + this.b;
        Point point = new Point(x, y);

        return point;
    }

}
