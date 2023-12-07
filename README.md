# Drawing-app
A simple program that can draw lines and rectangles on a canvas.

# Key features
```
Command 		Expected Result
C w h           Create a new canvas of width w and height h.
L x1 y1 x2 y2   Create a new line from (x1,y1) to (x2,y2). Currently only  horizontal or 
                vertical lines - supported. Horizontal and vertical lines will be drawn using the 'x'
                character.
R x1 y1 x2 y2   Create a new rectangle, whose upper left corner is (x1,y1) and lower 
                right corner is (x2, y2). Horizontal and vertical lines will be drawn using the 'x' character.
Q               Quit the program.

```

# Environment
```
jdk 8
junit 4.13.1
maven
```

# Quick start
```
Option 1:
java -jar ./lib/drawing-1.0.0.jar

Option2 :
run main method in app.java

```

Release notes
============
```
    2023-12-11
    1.0.0
    inital commit
```