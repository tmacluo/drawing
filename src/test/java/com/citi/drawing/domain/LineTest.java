package com.citi.drawing.domain;

import com.citi.drawing.common.exception.InvalidCanvasParameterException;
import org.junit.Assert;
import org.junit.Test;

public class LineTest {

    @Test
    public void testCreateLine() {
        Line line = new Line(1, 2, 2, 2);
        Assert.assertArrayEquals(new int[]{1, 2, 2, 2}, new int[]{
                line.getX1(), line.getY1(), line.getX2(), line.getY2()
        });
    }

    @Test(expected = InvalidCanvasParameterException.class)
    public void testCreateDiagonalLine() {
        new Line(1, 2, 3, 4);
    }

    @Test
    public void testCreateLineByAdjustingOrder() {
        Line line1 = new Line(3, 2, 1, 2);
        Assert.assertEquals(1, line1.getX1());

        Line line2 = new Line(3, 4, 3, 2);
        Assert.assertEquals(2, line2.getY1());
    }

}
