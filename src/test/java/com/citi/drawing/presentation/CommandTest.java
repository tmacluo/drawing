package com.citi.drawing.presentation;

import com.citi.drawing.common.exception.InvalidCommandParameterException;
import org.junit.Assert;
import org.junit.Test;

public class CommandTest {

    @Test(expected = InvalidCommandParameterException.class)
    public void testCommandShouldNotBeNull() {
        new Command(null);
    }

    @Test
    public void testCreteCommand() {
        Command command = new Command("C 20 4");
        Assert.assertArrayEquals(new String[]{"20", "4"}, command.getArgs());
    }
}
