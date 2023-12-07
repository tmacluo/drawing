package com.citi.drawing.operator;

import com.citi.drawing.common.exception.InvalidCommandParameterException;

import java.util.Arrays;

public abstract class AbstractFillerOperator {

    protected final int x1, y1, x2, y2;

    public AbstractFillerOperator(String[] parameters) throws InvalidCommandParameterException {
        boolean isNegative;
        try {
            isNegative = Arrays.stream(parameters)
                    .map(Integer::parseInt)
                    .anyMatch(integer -> integer <= 0);

        } catch (IllegalArgumentException exception) {
            throw new InvalidCommandParameterException("please specify positive number");
        }

        if (isNegative || parameters.length < 4) {
            throw new InvalidCommandParameterException("at least 4 positive Number are required: x1 y1 x2 y2");
        }

        this.x1 = Integer.parseInt(parameters[0]);
        this.y1 = Integer.parseInt(parameters[1]);
        this.x2 = Integer.parseInt(parameters[2]);
        this.y2 = Integer.parseInt(parameters[3]);
    }

}
