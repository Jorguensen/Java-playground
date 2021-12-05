package org.academiadecodigo.loopeytunes.tictactoe;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {
    public static final int PADDING = 10;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    public static final Rectangle FIELD = new Rectangle(PADDING, PADDING, WIDTH, HEIGHT);

    public Field() {
        FIELD.draw();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                new Position(i * WIDTH / 3 + PADDING, j * HEIGHT / 3 + PADDING, WIDTH / 3, HEIGHT / 3);
            }
        }
    }
}
