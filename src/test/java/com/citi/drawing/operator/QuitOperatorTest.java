package com.citi.drawing.operator;

import com.citi.drawing.domain.Canvas;
import org.junit.Test;

public class QuitOperatorTest {


    @Test
    public void testCreateQuitOperator() {
        new QuitOperator();
    }

    @Test
    public void testExitQuitOperator() {
        // Caution: the test would interrupt the application
        //new QuitOperator().execute(new Canvas(1, 1));
    }

}
