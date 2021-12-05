package org.academiadecodigo.loopeytunes.tictactoe;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Position {

   protected Rectangle rectangle;

    public Position(int x, int y, int width, int height ) {

        rectangle = new Rectangle(x, y, width, height);
        rectangle.draw();
    }
}
