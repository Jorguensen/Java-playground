import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Player player;
    private Npc npc;
    private Field field;
    private Position[] playerBoatPositions = new Position[17];
    private Position[] botBoatPositions = new Position[17];
    private Sound seaSound = new Sound("resources/ocean-wave-2.wav");
    private Sound explosionSound = new Sound("resources/explosion-01.wav");
    private Sound missed = new Sound("resources/gun-gunshot-02.wav");
    private Sound applauseSound = new Sound("resources/applause-01.wav");



    public Game() {
        player = new Player();
        npc = new Npc();
        menu();
        field = new Field();
        this.seaSound.play(true);
        this.seaSound.setLoop(100);
    }

    public void menu() {
        Picture picture = new Picture(Field.padding, Field.padding, "resources/capa final.png");
        while (!player.pressedStart()) {
            picture.draw();
        }
        picture.delete();
        Picture picture2 = new Picture(Field.padding, Field.padding, "resources/grelha_Prancheta 1.png");
        picture2.draw();
        player.drawScoreText();
        npc.drawScoreText();
    }


    public void init() {

        player.createPieces();
        while (player.pieces.getPiecesPlaced() < 5) {
            System.out.print("");
        }
        int i = 0;

        while (i <= playerBoatPositions.length - 1) {

            for (int j = 0; j < player.pieces.getPosCarrier().length; j++) {
                playerBoatPositions[i] = player.pieces.getPosCarrier()[j];
                i++;

            }
            for (int j = 0; j < player.pieces.getPosCruiser().length; j++) {
                playerBoatPositions[i] = player.pieces.getPosCruiser()[j];
                i++;
            }
            for (int j = 0; j < player.pieces.getPosDestroyer().length; j++) {
                playerBoatPositions[i] = player.pieces.getPosDestroyer()[j];
                i++;
            }
            for (int j = 0; j < player.pieces.getPosSubmarine().length; j++) {
                playerBoatPositions[i] = player.pieces.getPosSubmarine()[j];
                i++;
            }
            for (int j = 0; j < player.pieces.getPosBattleship().length; j++) {
                playerBoatPositions[i] = player.pieces.getPosBattleship()[j];
                i++;
            }

        }

        int l = 0;

        while (l <= botBoatPositions.length - 1) {
            for (int j = 0; j < npc.pieces.getPosCarrier().length; j++) {
                botBoatPositions[l] = npc.pieces.getPosCarrier()[j];
                l++;

            }
            for (int j = 0; j < npc.pieces.getPosCruiser().length; j++) {
                botBoatPositions[l] = npc.pieces.getPosCruiser()[j];
                l++;
            }
            for (int j = 0; j < npc.pieces.getPosDestroyer().length; j++) {
                botBoatPositions[l] = npc.pieces.getPosDestroyer()[j];
                l++;
            }
            for (int j = 0; j < npc.pieces.getPosSubmarine().length; j++) {
                botBoatPositions[l] = npc.pieces.getPosSubmarine()[j];
                l++;
            }
            for (int j = 0; j < npc.pieces.getPosBattleship().length; j++) {
                botBoatPositions[l] = npc.pieces.getPosBattleship()[j];
                l++;
            }

        }

        markField();
        player.drawCursor();


    }


    public void markCursorPosition(int x, int y) {
        x = (x * Field.cellSize) + Field.padding + (6 * Field.cellSize);
        y = (y * Field.cellSize) + Field.padding;
        Rectangle pos = new Rectangle(x, y, Field.cellSize, Field.cellSize);
        if (field.checkIsABoat(player.getCursorPosition()) && !(field.checkIsMarked(player.getCursorPosition()))) {
            field.markPos(player.getCursorPosition());
            pos.draw();
            pos.fill();
            pos.setColor(Color.ORANGE);
            explosionSound.play(true);
            player.setScore();
            player.changeScoreText(player.getScore());
            player.setShots();
            return;
        }
        if (!(field.checkIsABoat(player.getCursorPosition())) && !(field.checkIsMarked(player.getCursorPosition()))) {
            pos.draw();
            pos.fill();
            pos.setColor(Color.BLUE);
            missed.play(true);
        }
        player.deleteCursor();
        player.drawCursor();
    }

    public void markBotCursorPosition() {
        Position cursorPos = npc.getCursorPosition();
        int x = (npc.getCursorPosition().getCol() * Field.cellSize) + Field.padding + (6 * Field.cellSize);
        int y = ((npc.getCursorPosition().getRow() + 1) * Field.cellSize) + Field.padding;
        Rectangle pos = new Rectangle(x, y, Field.cellSize, Field.cellSize);
        if (field.checkIsABoat(cursorPos) && !(field.checkIsMarked(cursorPos))) {
            field.markPos(cursorPos);
            pos.draw();
            pos.fill();
            pos.setColor(Color.ORANGE);
            explosionSound.play(true);
            npc.setScore();
            npc.changeScoreText(npc.getScore());
            npc.setShots();
            npc.setCursorPosition();
            return;
        }
        if (!(field.checkIsABoat(cursorPos)) && !(field.checkIsMarked(cursorPos))) {
            pos.draw();
            pos.fill();
            pos.setColor(Color.BLUE);
        }
    }


    public void start() {
        int initialCursorCol = player.getCursorPosition().getCol();
        int initialCursorRow = player.getCursorPosition().getRow();

        while (!(player.isWin() && npc.isWin())) {

//            while (!((Field.padding + initialCursorCol / Field.cellSize - 6) == player.getCursorPosition().getCol() && (Field.padding + initialCursorRow / Field.cellSize - 6) == player.getCursorPosition().getRow())) {
            if (!(initialCursorCol == player.getCursorPosition().getCol() && initialCursorRow == player.getCursorPosition().getRow())) {
                System.out.println("");
                initialCursorCol = player.getCursorPosition().getCol();
                initialCursorRow = player.getCursorPosition().getRow();
                markCursorPosition(initialCursorCol, initialCursorRow);
                markBotCursorPosition();
                npc.setCursorPosition();
            }
            gameOver();
            System.out.print("");
            if (player.isWin()) {
                System.out.println("\nPLAYER WON");
                break;
            } else if (npc.isWin()) {
                System.out.println("\n BOT WON");
                break;
            }


        }


    }


    public void markField() {

        for (int i = 0; i < field.positionsAvailable.length; i++) {
            for (int j = 0; j < playerBoatPositions.length; j++) {

                if (field.positionsAvailable[i].getCol() == playerBoatPositions[j].getCol() && field.positionsAvailable[i].getRow() == playerBoatPositions[j].getRow()) {
                    field.positionsAvailable[i].isBoat();
                }
            }
        }


        for (int i = 0; i < field.positionsAvailable.length; i++) {

            for (int j = 0; j < botBoatPositions.length; j++) {


                if (field.positionsAvailable[i].getCol() == botBoatPositions[j].getCol() && field.positionsAvailable[i].getRow() == botBoatPositions[j].getRow()) {

                    field.positionsAvailable[i].isBoat();
                }
            }
        }

    }

    public boolean gameOver() {

        if (player.getShots() == 17) {
            player.setWin();
            Picture gameOverPicture = new Picture(Field.padding,Field.padding,"resources/Gameover_Prancheta 1.png");
            gameOverPicture.draw();
            player.setGameIsOver();
            applauseSound.play(true);
            return true;
        } else if (npc.getShots() == 17) {
            npc.setWin();
            Picture gameOverPicture = new Picture(Field.padding,Field.padding,"resources/Gameover_Prancheta 1.png");
            gameOverPicture.draw();
            player.setGameIsOver();
            return true;
        }

        return false;
    }



}
