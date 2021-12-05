package org.academiadecodigo.loopeytunes.tictactoe;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class GameKeyboard implements KeyboardHandler {
    private final Cursor cursor;

    public GameKeyboard(Cursor cursor){
        this.cursor = cursor;
        setKeys();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (cursor.isPlaying()) {

            switch (keyboardEvent.getKey()) {
                case KeyboardEvent.KEY_UP:
                    cursor.moveUp();
                    break;
                case KeyboardEvent.KEY_DOWN:
                    cursor.moveDown();
                    break;
                case KeyboardEvent.KEY_LEFT:
                    cursor.moveLeft();
                    break;
                case KeyboardEvent.KEY_RIGHT:
                    cursor.moveRight();
                    break;
                case KeyboardEvent.KEY_SPACE:
                    cursor.setPlaying(false);
                    cursor.makeMove();
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void setKeys() {
        Keyboard kb = new Keyboard (this);

        KeyboardEvent upPressed = new KeyboardEvent();
        upPressed.setKey(KeyboardEvent.KEY_UP);
        upPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent downPressed = new KeyboardEvent();
        downPressed.setKey(KeyboardEvent.KEY_DOWN);
        downPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent leftPressed = new KeyboardEvent();
        leftPressed.setKey(KeyboardEvent.KEY_LEFT);
        leftPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent rightPressed = new KeyboardEvent();
        rightPressed.setKey(KeyboardEvent.KEY_RIGHT);
        rightPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent spacePressed = new KeyboardEvent();
        spacePressed.setKey(KeyboardEvent.KEY_SPACE);
        spacePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        kb.addEventListener(upPressed);
        kb.addEventListener(leftPressed);
        kb.addEventListener(downPressed);
        kb.addEventListener(rightPressed);
        kb.addEventListener(spacePressed);
    }
}