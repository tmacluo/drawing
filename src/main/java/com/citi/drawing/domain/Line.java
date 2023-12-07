package com.citi.drawing.domain;

import com.citi.drawing.common.exception.InvalidCanvasParameterException;

public class Line extends PointsPair {
    public Line(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
        if (isDiagonal()) {
            throw new InvalidCanvasParameterException("currently only horizontal or vertical lines are supported");
        }
    }

    public boolean isDiagonal() {
        return x1 != x2 && y1 != y2;
    }
}


