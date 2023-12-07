package com.citi.drawing.operator;

import com.citi.drawing.domain.Canvas;

public class QuitOperator implements Operator {
    @Override
    public void execute(Canvas canvas) {
        // TODO the scanner should be closed explicitly
        System.exit(0);
    }
}
