package com.citi.drawing.operator;

import com.citi.drawing.common.exception.InvalidCommandParameterException;
import com.citi.drawing.domain.Canvas;
import org.junit.Assert;
import org.junit.Test;


public class CreateCanvasOperatorTest {

    @Test
    public void testCreateCanvas() {
        new CreateCanvasOperator(new String[] {"5", "5"});
    }

    @Test(expected = InvalidCommandParameterException.class)
    public void testCreateCanvasWithInsufficientParameter() {
        new CreateCanvasOperator(new String[] {"5"});
    }

    @Test
    public void testCreateCanvasWithExtraParameter() {
        CreateCanvasOperator operator = new CreateCanvasOperator(new String[]{"5", "4", "3"});
        Assert.assertEquals(5, operator.getWidth());
        Assert.assertEquals(4, operator.getHeight());
    }

    @Test(expected = InvalidCommandParameterException.class)
    public void testCreateCanvasWithNoDigitParameter() {
        new CreateCanvasOperator(new String[] {"a"});
    }

    @Test
    public void testCreateCanvasToConsole() {
        CreateCanvasOperator operator = new CreateCanvasOperator(new String[]{"20", "4"});
        Canvas canvas = new Canvas(operator.getWidth(), operator.getHeight());
        operator.execute(canvas);
        Assert.assertEquals(20, operator.getWidth());
        Assert.assertEquals(4, operator.getHeight());
        Assert.assertEquals(canvas.build(),
                "----------------------\n" +
                        "|                    |\n" +
                        "|                    |\n" +
                        "|                    |\n" +
                        "|                    |\n" +
                        "----------------------");
    }

}
