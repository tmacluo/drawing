package com.citi.drawing.domain;

import com.citi.drawing.common.exception.InvalidCanvasParameterException;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Canvas {

    public static final String HORIZONTAL_CHAR = "-";
    private static final char VERTICAL_CHAR = '|';
    private static final char LINE_CHAR = 'x';
    private static final char EMPTY = ' ';

    private final char[][] canvasArray;
    private final int width;
    private final int height;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        canvasArray = new char[height][width];
        // by default the array should fill with empty char
        Arrays.stream(canvasArray).forEach(row -> Arrays.fill(row, EMPTY));
    }

    public void display() {
        System.out.println(build());
    }

    public String build() {
        StringBuilder builder = new StringBuilder();
        builder.append(drawHorizontalLine()).append("\n");
        for (int i = 0; i < height; i++) {
            builder.append(VERTICAL_CHAR);
            for (int j = 0; j < width; j++) {
                builder.append(canvasArray[i][j]);
            }
            builder.append(VERTICAL_CHAR).append("\n");
        }
        builder.append(drawHorizontalLine());
        return builder.toString();
    }

    public void drawPoints(PointsPair points) {
        // ensure x1 and y1 is in the range
        // trim it in case x2, y2 is out of range
        rangeCheck(points.x1, points.y1);
        if (points instanceof Line) {
            fillLineChar(points.getX1(), points.getY1(), points.getX2(), points.getY2());
        }
        if (points instanceof Rectangle) {
            fillRectangleChar(points.getX1(), points.getY1(), points.getX2(), points.getY2());
        }
    }

    private void rangeCheck(int x, int y) {
        if (x < 1 || x > width || y < 1 || y > height) {
            throw new InvalidCanvasParameterException("the coordinate is out of range, max width is " + width + ", max height is " + height);
        }
    }

    private void fillRectangleChar(int x1, int y1, int x2, int y2) {
        // draw top line
        fillLineChar(x1, y1, x2, y1);
        // draw left line
        fillLineChar(x1, y1, x1, y2);
        // draw right line
        fillLineChar(x2, y1, x2, y2);
        // draw bottom line
        fillLineChar(x1, y2, x2, y2);
    }

    private void fillLineChar(int x1, int y1, int x2, int y2) {
        int startRow = Math.max(y1 - 1, 0);
        int endRow = Math.min(y2 - 1, height - 1);
        int startCol = Math.max(x1 - 1, 0);
        int endCol = Math.min(x2 - 1, width - 1);

        for (int row = startRow; row <= endRow; row++) {
            for (int col = startCol; col <= endCol; col++) {
                canvasArray[row][col] = LINE_CHAR;
            }
        }
    }

    private String drawHorizontalLine() {
        // hava two extra horizontal char to align with the vertical char
        return IntStream.range(0, width + 2)
                .mapToObj(i -> HORIZONTAL_CHAR)
                .collect(Collectors.joining());
    }

}
