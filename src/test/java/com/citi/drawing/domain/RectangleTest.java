package com.citi.drawing.domain;

import org.junit.Assert;
import org.junit.Test;

public class RectangleTest {

    @Test
    public void testCreateRectangle() {
        Rectangle r = new Rectangle(1, 2, 2, 2);
        Assert.assertArrayEquals(new int[]{1, 2, 2, 2}, new int[]{
                r.getX1(), r.getY1(), r.getX2(), r.getY2()
        });
    }

    @Test
    public void testCreateLineByAdjustingOrder() {
        Rectangle rectangle1 = new Rectangle(3, 2, 1, 2);
        Assert.assertEquals(1, rectangle1.getX1());

        Rectangle rectangle2 = new Rectangle(3, 4, 3, 2);
        Assert.assertEquals(2, rectangle2.getY1());
    }

}
