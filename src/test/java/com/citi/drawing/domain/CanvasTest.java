package com.citi.drawing.domain;

import com.citi.drawing.common.exception.InvalidCanvasParameterException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CanvasTest {

    Canvas canvas;

    @Before
    public void setup() {
        canvas = new Canvas(10, 5);
    }

    @Test
    public void testCreateCanvas() {
        Assert.assertEquals(
                "------------\n" +
                        "|          |\n" +
                        "|          |\n" +
                        "|          |\n" +
                        "|          |\n" +
                        "|          |\n" +
                        "------------",
                canvas.build());
    }

    @Test
    public void testDrawNewLineOutOfRangeWithTrim() {
        PointsPair line = new Line(11, 1, 5, 1);
        canvas.drawPoints(line);
        assertEquals(
                "------------\n" +
                        "|    xxxxxx|\n" +
                        "|          |\n" +
                        "|          |\n" +
                        "|          |\n" +
                        "|          |\n" +
                        "------------",
                canvas.build()
        );
    }

    @Test
    public void testDrawNewLineOutOfRange() {
        PointsPair line = new Line(11, 1, 11, 2);
        assertThrows(InvalidCanvasParameterException.class, () -> canvas.drawPoints(line));
    }

    @Test
    public void testCreateCanvasWithNewLine() {
        PointsPair line = new Line(3, 1, 4, 1);
        canvas.drawPoints(line);
        Assert.assertEquals(
                "------------\n" +
                        "|  xx      |\n" +
                        "|          |\n" +
                        "|          |\n" +
                        "|          |\n" +
                        "|          |\n" +
                        "------------",
                canvas.build());
    }

    @Test
    public void testCreateCanvasWithNewRectangle() {
        PointsPair rectangle = new Rectangle(3, 1, 4, 2);
        canvas.drawPoints(rectangle);
        Assert.assertEquals(
                "------------\n" +
                        "|  xx      |\n" +
                        "|  xx      |\n" +
                        "|          |\n" +
                        "|          |\n" +
                        "|          |\n" +
                        "------------",
                canvas.build());
    }
}
