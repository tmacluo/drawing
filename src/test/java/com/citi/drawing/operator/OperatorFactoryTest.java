package com.citi.drawing.operator;

import com.citi.drawing.common.exception.InvalidCommandParameterException;
import com.citi.drawing.presentation.Command;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OperatorFactoryTest {

    OperatorFactory operatorFactory;

    @Before
    public void setup(){
        operatorFactory = new OperatorFactory();
    }

    @Test
    public void testCreateQuitOperator() {
        Command command = new Command("Q");
        Operator operator = operatorFactory.determineOperator(command);
        Assert.assertTrue(operator instanceof QuitOperator);
    }

    @Test
    public void testCreateCanvasOperator() {
        Command command = new Command("C 3 2");
        Operator operator = operatorFactory.determineOperator(command);
        Assert.assertTrue(operator instanceof CreateCanvasOperator);
    }

    @Test
    public void testCreateNewLineOperator() {
        Command command = new Command("L 3 2 3 1");
        Operator operator = operatorFactory.determineOperator(command);
        Assert.assertTrue(operator instanceof CreateNewLineOperator);
    }

    @Test
    public void testCreateNewRectangleOperator() {
        Command command = new Command("R 3 2 3 1");
        Operator operator = operatorFactory.determineOperator(command);
        Assert.assertTrue(operator instanceof CreateNewRectangleOperator);
    }

    @Test
    public void testUnknownOperator() {
        Command command = new Command("X 3 2 3 1");
        Assert.assertThrows(InvalidCommandParameterException.class, () -> operatorFactory.determineOperator(command));
    }
}
