package com.citi.drawing.presentation;

import com.citi.drawing.common.exception.InvalidCommandParameterException;

import java.util.Arrays;
import java.util.Objects;

/**
 * Command dto that accepts input from console, or web UI in the future.
 */
public class Command {

    String operator;

    String[] args;

    public Command(String source) {
        resolve(source);
    }

    private void resolve(String source) {
        if (Objects.isNull(source) || source.isEmpty()) {
            throw new InvalidCommandParameterException("at least one parameter should be provided");
        }

        String[] split = source.trim().split(" ");
        this.operator = split[0];
        this.args = Arrays.copyOfRange(split, 1, split.length);
    }

    public String getOperator() {
        return operator;
    }

    public String[] getArgs() {
        return args;
    }
}
