package com.citi.drawing.operator;

import com.citi.drawing.common.exception.InvalidCanvasParameterException;
import com.citi.drawing.common.exception.InvalidCommandParameterException;
import com.citi.drawing.domain.Canvas;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class CreateNewRectangleOperatorTest {

    @Test
    public void testCreateNewLineOperator() {
        CreateNewRectangleOperator r1 = new CreateNewRectangleOperator(new String[]{"5", "4", "2", "5"});
        CreateNewRectangleOperator r2 = new CreateNewRectangleOperator(new String[] {"5", "4", "5", "5"});
        CreateNewRectangleOperator r3 = new CreateNewRectangleOperator(new String[] {"5", "4", "6", "4"});
        Assert.assertArrayEquals(new int[] {5, 4, 2, 5}, new int[] {r1.x1, r1.y1, r1.x2, r1.y2});
        Assert.assertArrayEquals(new int[] {5, 4, 5, 5}, new int[] {r2.x1, r2.y1, r2.x2, r2.y2});
        Assert.assertArrayEquals(new int[] {5, 4, 6, 4}, new int[] {r3.x1, r3.y1, r3.x2, r3.y2});
    }

    @Test(expected = InvalidCommandParameterException.class)
    public void testCreateNewLineOperatorWithInsufficientParameter() {
        new CreateNewRectangleOperator(new String[] {"5"});
    }

    @Test
    public void testCreateNewLineOperatorWithExtraParameter() {
        CreateNewRectangleOperator operator = new CreateNewRectangleOperator(new String[]{"5", "4", "3", "3", "3"});
        Assert.assertArrayEquals(new int[] {5, 4, 3, 3}, new int[] {operator.x1, operator.y1, operator.x2, operator.y2});
    }

    @Test(expected = InvalidCommandParameterException.class)
    public void testCreateNewLineOperatorWithNoDigitParameter() {
        new CreateNewLineOperator(new String[] {"a"});
    }

    @Test
    public void testCreateNewLineWithoutCanvas() {
        CreateNewRectangleOperator operator = new CreateNewRectangleOperator(new String[] {"5", "4", "6", "4"});
        assertThrows(InvalidCanvasParameterException.class, () -> operator.execute(null));

    }

    @Test
    public void testCreateNewLineOperatorOutOfRange() {
        CreateNewRectangleOperator operator = new CreateNewRectangleOperator(new String[]{"5", "4", "5", "5"});
        Canvas canvas = new Canvas(4, 4);
        assertThrows(InvalidCanvasParameterException.class, () -> operator.execute(canvas));
    }
}
