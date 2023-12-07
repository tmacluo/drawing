package com.citi.drawing;

import com.citi.drawing.operator.OperatorFactory;
import org.junit.Test;

public class AppTest extends App {

    @Test
    public void testCreateCanvas() {
        operatorFactory = new OperatorFactory();
        execute("C 20 4");
    }

    @Test
    public void testInvalidCommandParameter() {
        operatorFactory = new OperatorFactory();
        execute("A 20 4");
    }

    @Test
    public void testInvalidCanvas() {
        operatorFactory = new OperatorFactory();
        execute("C 20 4");
        execute("L 20 4 19 3");
    }

    @Test
    public void testDrawLineIntoCanvas() {
        operatorFactory = new OperatorFactory();
        execute("C 20 4");
        execute("L 2 4 3 4");
    }

    @Test
    public void testDrawRectangleIntoCanvas() {
        operatorFactory = new OperatorFactory();
        execute("C 20 4");
        execute("R 16 1 20 3");
    }
}
