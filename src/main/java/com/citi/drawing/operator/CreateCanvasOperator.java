package com.citi.drawing.operator;

import com.citi.drawing.common.exception.InvalidCommandParameterException;
import com.citi.drawing.domain.Canvas;

import java.util.Arrays;

public class CreateCanvasOperator implements Operator {
    private final int width;
    private final int height;

    public CreateCanvasOperator(String[] parameters) {
        boolean isNegative;
        try {
            isNegative = Arrays.stream(parameters)
                    .map(Integer::parseInt)
                    .anyMatch(integer -> integer <= 0);

        } catch (IllegalArgumentException exception) {
            throw new InvalidCommandParameterException("please specify positive number");
        }

        if (isNegative || parameters.length < 2) {
            throw new InvalidCommandParameterException("at least two positive Number are required");
        }

        this.width = Integer.parseInt(parameters[0]);
        this.height = Integer.parseInt(parameters[1]);
    }

    @Override
    public void execute(Canvas canvas) {
        canvas.display();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
