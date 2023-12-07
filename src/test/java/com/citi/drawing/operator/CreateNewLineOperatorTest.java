package com.citi.drawing.operator;

import com.citi.drawing.common.exception.InvalidCanvasParameterException;
import com.citi.drawing.common.exception.InvalidCommandParameterException;
import com.citi.drawing.domain.Canvas;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class CreateNewLineOperatorTest {

    @Test
    public void testCreateNewLineOperator() {
        CreateNewLineOperator randomLine = new CreateNewLineOperator(new String[]{"5", "4", "2", "5"});
        CreateNewLineOperator verticalLine = new CreateNewLineOperator(new String[] {"5", "4", "5", "5"});
        CreateNewLineOperator horizontalLine = new CreateNewLineOperator(new String[] {"5", "4", "6", "4"});
        Assert.assertArrayEquals(new int[] {5, 4, 2, 5}, new int[] {randomLine.x1, randomLine.y1, randomLine.x2, randomLine.y2});
        Assert.assertArrayEquals(new int[] {5, 4, 5, 5}, new int[] {verticalLine.x1, verticalLine.y1, verticalLine.x2, verticalLine.y2});
        Assert.assertArrayEquals(new int[] {5, 4, 6, 4}, new int[] {horizontalLine.x1, horizontalLine.y1, horizontalLine.x2, horizontalLine.y2});
    }

    @Test(expected = InvalidCommandParameterException.class)
    public void testCreateNewLineOperatorWithInsufficientParameter() {
        new CreateNewLineOperator(new String[] {"5"});
    }

    @Test
    public void testCreateNewLineOperatorWithExtraParameter() {
        CreateNewLineOperator operator = new CreateNewLineOperator(new String[]{"5", "4", "3", "3", "3"});
        Assert.assertArrayEquals(new int[] {5, 4, 3, 3}, new int[] {operator.x1, operator.y1, operator.x2, operator.y2});
    }

    @Test(expected = InvalidCommandParameterException.class)
    public void testCreateNewLineOperatorWithNoDigitParameter() {
        new CreateNewLineOperator(new String[] {"a"});
    }

    @Test
    public void testCreateNewLineWithoutCanvas() {
        CreateNewLineOperator lineOperator = new CreateNewLineOperator(new String[] {"5", "4", "6", "4"});
        assertThrows(InvalidCanvasParameterException.class, () -> lineOperator.execute(null));
    }

    @Test
    public void testCreateNewLineOperatorOutOfRange() {
        CreateNewLineOperator operator = new CreateNewLineOperator(new String[]{"5", "4", "5", "5"});
        Canvas canvas = new Canvas(4, 4);
        assertThrows(InvalidCanvasParameterException.class, () -> operator.execute(canvas));
    }
}
