package org.academiadecodigo.loopeytunes.tictactoe;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import java.util.ArrayList;
import java.util.Arrays;

public class GameRules {
    private boolean gameOver;
    private final Sound win = new Sound("/resources/win.wav");
    private Picture gameOverPic;

    public boolean checkWin(ArrayList<String> playsList) {

        for (String[] posArray : winPositions()) {
            if (playsList.contains(posArray[0]) && playsList.contains(posArray[1]) && playsList.contains(posArray[2])) {
                win.play(true);

                int initialX = Integer.parseInt(posArray[0].split("#")[0]);
                int finalX = Integer.parseInt(posArray[2].split("#")[0]);

                int initialY = Integer.parseInt(posArray[0].split("#")[1]);
                int finalY = Integer.parseInt(posArray[2].split("#")[1]);


                if ((Arrays.equals(posArray, winPositions()[0])) || (Arrays.equals(posArray, winPositions()[1])) || (Arrays.equals(posArray, winPositions()[2]))) {
                    Picture horizontal = new Picture(initialX + 50, finalY + 90, "resources/horizontal_line.png");
                    horizontal.grow(20, 0);
                    horizontal.draw();
                }

                if ((Arrays.equals(posArray, winPositions()[3])) || (Arrays.equals(posArray, winPositions()[4])) || (Arrays.equals(posArray, winPositions()[5]))) {
                    Picture vertical = new Picture(finalX + 90, initialY + 50, "resources/vertical_line.png");
                    vertical.grow(0, 20);
                    vertical.draw();
                }

                if (Arrays.equals(posArray, winPositions()[6])) {
                    Picture diagonal = new Picture(initialX + 90, initialY + 100, "resources/diagonal_2.png");
                    diagonal.grow(10, 50);
                    diagonal.draw();
                }

                if (Arrays.equals(posArray, winPositions()[7])) {
                    Picture diagonal = new Picture(initialX + 100, finalY + 70, "resources/diagonal_1.png");
                    diagonal.grow(10, 50);
                    diagonal.draw();
                }

                Picture winPic = new Picture(35, 215, "resources/win_pic.png");
                winPic.draw();

                gameOver = true;

                return gameOver;

            }
        }

        return gameOver;
    }

    public boolean checkLoss(ArrayList<String> opponentPosList) {

        for (String[] posArray : winPositions()) {
            if (opponentPosList.contains(posArray[0]) && opponentPosList.contains(posArray[1]) && opponentPosList.contains(posArray[2])) {
                gameOverPic = new Picture(25,215,"resources/game_over_pic.png");
                gameOverPic.draw();
                gameOver = true;
                return gameOver;

            }
        }

        return gameOver;
    }

    public boolean checkTie(ArrayList<String> posList) {
        if (posList.size() == 9) {
            gameOver = true;
            gameOverPic = new Picture(25,215,"resources/game_over_pic.png");
            gameOverPic.draw();
            return gameOver;
        }

        return gameOver;
    }

    public String[][] winPositions() {
        return new String[][]{
                {"10#10", "210#10", "410#10"},
                {"10#210", "210#210", "410#210"},
                {"10#410", "210#410", "410#410"},
                {"10#10", "10#210", "10#410"},
                {"210#10", "210#210", "210#410"},
                {"410#10", "410#210", "410#410"},
                {"10#10", "210#210", "410#410"},
                {"10#410", "210#210", "410#10"}};
    }

}
