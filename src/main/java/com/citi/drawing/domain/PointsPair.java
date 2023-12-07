package com.citi.drawing.domain;

/**
 * holding two points
 */
public class PointsPair {
    protected int x1, y1, x2, y2;

    public PointsPair(int x1, int y1, int x2, int y2) {
        // ensure the coordinates are ordered from left to right
        if ((x1 == x2 && y1 > y2) || (y1 == y2 && x1 > x2)) {
            this.x1 = x2;
            this.y1 = y2;
            this.x2 = x1;
            this.y2 = y1;
        } else {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    public int getX1() {
        return x1;
    }
    public int getY1() {
        return y1;
    }
    public int getX2() {
        return x2;
    }
    public int getY2() {
        return y2;
    }
}
