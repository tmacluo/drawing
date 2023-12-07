package com.citi.drawing.operator;

import com.citi.drawing.common.exception.InvalidCanvasParameterException;
import com.citi.drawing.domain.Canvas;
import com.citi.drawing.domain.Line;
import com.citi.drawing.domain.PointsPair;

import java.util.Objects;

public class CreateNewLineOperator extends AbstractFillerOperator implements Operator{

    public CreateNewLineOperator(String[] parameters) {
        super(parameters);
    }

    @Override
    public void execute(Canvas canvas) {
        if (Objects.isNull(canvas)) {
            throw new InvalidCanvasParameterException("please create a canvas first");
        }
        PointsPair line = new Line(x1, y1, x2, y2);
        canvas.drawPoints(line);
        canvas.display();
    }
}
