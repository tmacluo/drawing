package com.citi.drawing;

import com.citi.drawing.common.exception.InvalidCanvasParameterException;
import com.citi.drawing.common.exception.InvalidCommandParameterException;
import com.citi.drawing.domain.Canvas;
import com.citi.drawing.operator.CreateCanvasOperator;
import com.citi.drawing.operator.Operator;
import com.citi.drawing.operator.OperatorFactory;
import com.citi.drawing.presentation.Command;

import java.util.Scanner;

public class App {
    private static Canvas canvas;
    protected static OperatorFactory operatorFactory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        operatorFactory = new OperatorFactory();
        System.out.println("Please enter the command:");
        while (true) {
            execute(scanner.nextLine());
            System.out.println("Please enter the command:");
        }
    }

    public static void execute(String input) {
        try {
            Command command = new Command(input);
            Operator operator = operatorFactory.determineOperator(command);
            if (operator instanceof CreateCanvasOperator) {
                initializeCanvas((CreateCanvasOperator) operator);
            }
            operator.execute(canvas);
        } catch (InvalidCommandParameterException e) {
            System.out.println("The command parameter is not correct: " + e.getMessage());
        } catch (InvalidCanvasParameterException e) {
            System.out.println("Not able to draw the canvas, " + e.getMessage());
        }
    }

    private static void initializeCanvas(CreateCanvasOperator operator) {
        canvas = new Canvas(operator.getWidth(), operator.getHeight());
    }
}
