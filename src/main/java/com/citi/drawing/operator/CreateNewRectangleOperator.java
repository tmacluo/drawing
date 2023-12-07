package com.citi.drawing.operator;

import com.citi.drawing.common.exception.InvalidCanvasParameterException;
import com.citi.drawing.domain.Canvas;
import com.citi.drawing.domain.PointsPair;
import com.citi.drawing.domain.Rectangle;

import java.util.Objects;

public class CreateNewRectangleOperator extends AbstractFillerOperator implements Operator {
    public CreateNewRectangleOperator(String[] parameters) {
        super(parameters);
    }

    @Override
    public void execute(Canvas canvas) {
        if (Objects.isNull(canvas)) {
            throw new InvalidCanvasParameterException("please create a canvas first");
        }
        PointsPair rectangle = new Rectangle(x1, y1, x2, y2);
        canvas.drawPoints(rectangle);
        canvas.display();
    }
}
