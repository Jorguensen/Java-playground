import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class Player implements KeyboardHandler {

    public Pieces pieces;
    private Keyboard kb;
    private Rectangle currentPiece;
    private Rectangle cursor = new Rectangle(Field.padding + 6 * Field.cellSize, Field.padding + 10 * Field.cellSize, Field.cellSize, Field.cellSize);
    private Position cursorPosition = new Position((Field.padding + cursor.getX()) / Field.cellSize - 6, (Field.padding + cursor.getY()) / Field.cellSize);
    private int score = 0;
    private int shots = 0;
    private boolean win = false;
    public boolean pressedStart = false;
    private Text scoreText = new Text(363,710, score + "");
    private boolean gameIsOver = false;

    public void setGameIsOver() {
        gameIsOver = true;
    }

    public int getScore(){
        return score;
    }

    public void drawScoreText(){
        scoreText.setColor(Color.GRAY);
        scoreText.draw();
        scoreText.grow(12,12);
    }

    public void changeScoreText(int score){
        this.scoreText.setText(score + "");
    }

    public Player() {

        kb = new Keyboard(this);
        addEventListeners();
    }

    public void createPieces() {
        this.pieces = new Pieces();
        this.currentPiece = pieces.getCarrier();
    }


    public void addEventListeners() {
        KeyboardEvent pressingA = new KeyboardEvent();
        pressingA.setKey(KeyboardEvent.KEY_A);
        pressingA.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        kb.addEventListener(pressingA);

        KeyboardEvent pressingW = new KeyboardEvent();
        pressingW.setKey(KeyboardEvent.KEY_W);
        pressingW.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        kb.addEventListener(pressingW);

        KeyboardEvent pressingS = new KeyboardEvent();
        pressingS.setKey(KeyboardEvent.KEY_S);
        pressingS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        kb.addEventListener(pressingS);

        KeyboardEvent pressingD = new KeyboardEvent();
        pressingD.setKey(KeyboardEvent.KEY_D);
        pressingD.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        kb.addEventListener(pressingD);

        KeyboardEvent pressingSpace = new KeyboardEvent();
        pressingSpace.setKey(KeyboardEvent.KEY_SPACE);
        pressingSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        kb.addEventListener(pressingSpace);

        KeyboardEvent pressingR = new KeyboardEvent();
        pressingR.setKey(KeyboardEvent.KEY_R);
        pressingR.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        kb.addEventListener(pressingR);


        KeyboardEvent pressing0 = new KeyboardEvent();
        pressing0.setKey(KeyboardEvent.KEY_0);
        pressing0.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        kb.addEventListener(pressing0);

    }

    public void drawCursor() {
        cursor.draw();
        cursor.setColor(Color.CYAN);
        cursor.fill();
    }


    public void deleteCursor() {
        cursor.delete();
    }


    public boolean pressedStart() {
        return pressedStart;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if(gameIsOver){
            if(keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE){
                System.exit(0);
            }
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_0) {
            pressedStart = true;
        }

        if (pressedStart) {
            if (pieces != null) {
                if (pieces.getPiecesPlaced() < 5) {
                    switch (keyboardEvent.getKey()) {


                        case KeyboardEvent.KEY_A:
                            if (!(currentPiece.getX() < 7 * Field.cellSize)) {
                                currentPiece.translate(-Field.cellSize, 0);
                            }
                            break;
                        case KeyboardEvent.KEY_W:

                            if (!(currentPiece.getY() < 2 * Field.cellSize)) {
                                currentPiece.translate(0, -Field.cellSize);
                            }
                            break;
                        case KeyboardEvent.KEY_S:
                            if (!(currentPiece.getY() > 9 * Field.cellSize)) {
                                currentPiece.translate(0, Field.cellSize);
                            }
                            break;
                        case KeyboardEvent.KEY_D:
                            if (!(currentPiece.getX() > 20 * Field.cellSize)) {
                                currentPiece.translate(Field.cellSize, 0);
                            }
                            break;
                        case KeyboardEvent.KEY_SPACE:
                            Position[] thisBoatPositions = new Position[currentPiece.getWidth() / Field.cellSize];
                            for (int i = 0; i < (currentPiece.getWidth() / Field.cellSize); i++) {
                                thisBoatPositions[i] = new Position(((Field.padding + currentPiece.getX()) / Field.cellSize) - 6 + i, (Field.padding + currentPiece.getY()) / Field.cellSize - 1);
                            }
                            if (this.pieces.getCarrier().equals(currentPiece)) {
                                this.pieces.setPosCarrier(thisBoatPositions);


                            } else if (this.pieces.getBattleship().equals(currentPiece)) {
                                this.pieces.setPosBattleship(thisBoatPositions);


                            } else if (this.pieces.getCruiser().equals(currentPiece)) {
                                this.pieces.setPosCruiser(thisBoatPositions);


                            } else if (this.pieces.getSubmarine().equals(currentPiece)) {
                                this.pieces.setPosSubmarine(thisBoatPositions);


                            } else if (this.pieces.getDestroyer().equals(currentPiece)) {
                                this.pieces.setPosDestroyer(thisBoatPositions);


                            }
                            pieces.incrementPiecesPlaced();

                            currentPiece = pieces.getNextPiece();
                            break;

                    }
                } else {

                    switch (keyboardEvent.getKey()) {

                        case KeyboardEvent.KEY_A:
                            if (!(cursor.getX() < 7 * Field.cellSize)) {
                                cursor.translate(-Field.cellSize, 0);
                            }
                            break;
                        case KeyboardEvent.KEY_W:
                            if (!(cursor.getY() < 11 * Field.cellSize)) {
                                cursor.translate(0, -Field.cellSize);
                            }
                            break;
                        case KeyboardEvent.KEY_S:
                            if (!(cursor.getY() > 18 * Field.cellSize)) {
                                cursor.translate(0, Field.cellSize);
                            }
                            break;
                        case KeyboardEvent.KEY_D:
                            if (!(cursor.getX() > 24 * Field.cellSize)) {
                                cursor.translate(Field.cellSize, 0);
                            }
                            break;
                        case KeyboardEvent.KEY_SPACE:
                            cursorPosition.setCol((Field.padding + cursor.getX()) / Field.cellSize - 6);
                            cursorPosition.setRow((Field.padding + cursor.getY()) / Field.cellSize);
                    }


                }
            }
        }


    }

    public Position getCursorPosition() {
        return cursorPosition;
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void setScore() {
        this.score += 50;
    }

    public void setShots() {
        this.shots++;
    }

    public int getShots() {
        return shots;
    }

    public void setWin() {
        this.win = true;
    }

    public boolean isWin() {
        return win;
    }
}


