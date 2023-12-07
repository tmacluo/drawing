package com.citi.drawing.operator;

import com.citi.drawing.common.exception.InvalidCommandParameterException;
import com.citi.drawing.presentation.Command;

public class OperatorFactory {

    public Operator determineOperator(Command command) {
        String op = command.getOperator().toUpperCase();

        switch (op) {
            case "Q":
                return new QuitOperator();
            case "C":
                return new CreateCanvasOperator(command.getArgs());
            case "L":
                return new CreateNewLineOperator(command.getArgs());
            case "R":
                return new CreateNewRectangleOperator(command.getArgs());
            default:
                throw new InvalidCommandParameterException("Command operator should be one of [Q, C, L, R]");
        }
    }

}
