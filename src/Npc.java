import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import java.util.ArrayList;

public class Npc {


    public Pieces pieces;
    private Rectangle currentPiece;
    private Position cursorPosition = new Position((int) Math.floor(Math.random() * 19), (int) Math.floor(Math.random() * 10));
    private int score = 0;
    private int shots = 0;
    private boolean win = false;
    private ArrayList<Position> usedPos = new ArrayList<>();
    private Position[] boatHitPos = new Position[17];
    private int boatHitPosIndex = 0;
    private Text scoreText = new Text(651,710, score + "");


    public void drawScoreText(){
        scoreText.setColor(Color.GRAY);
        scoreText.draw();
        scoreText.grow(12,12);
    }

    public void changeScoreText(int score){
        this.scoreText.setText(score + "");
    }

    public int getScore() {
        return score;
    }

    public void addBoatHitPos(Position boatHitPos) {
        this.boatHitPos[boatHitPosIndex] = boatHitPos;
        this.boatHitPosIndex+= 1;
    }

    public Npc() {
        this.pieces = new Pieces();
        this.currentPiece = pieces.getCarrier();
        deleteAllPieces();
        pieceSetup();
    }


    public void deleteAllPieces() {
        this.pieces.getCarrier().delete();
        this.pieces.getCruiser().delete();
        this.pieces.getBattleship().delete();
        this.pieces.getDestroyer().delete();
        this.pieces.getSubmarine().delete();

    }

    public boolean isHereABoat(int col, int row) {
        if (pieces.getPosCarrier()[0] != null) {
            for (int i = 0; i < pieces.getPosCarrier().length; i++) {
                if (pieces.getPosCarrier()[i].getCol() == col && pieces.getPosCarrier()[i].getRow() == row) {
                    return true;
                }
            }
        }
        if (pieces.getPosCruiser()[0] != null) {
            for (int i = 0; i < pieces.getPosCruiser().length; i++) {
                if (pieces.getPosCruiser()[i].getCol() == col && pieces.getPosCruiser()[i].getRow() == row) {
                    return true;
                }
            }
        }
        if (pieces.getPosBattleship()[0] != null) {
            for (int i = 0; i < pieces.getPosBattleship().length; i++) {
                if (pieces.getPosBattleship()[i].getCol() == col && pieces.getPosBattleship()[i].getRow() == row) {
                    return true;
                }
            }
        }
        if (pieces.getPosDestroyer()[0] != null) {
            for (int i = 0; i < pieces.getPosDestroyer().length; i++) {
                if (pieces.getPosDestroyer()[i].getCol() == col && pieces.getPosDestroyer()[i].getRow() == row) {
                    return true;
                }
            }
        }
        if (pieces.getPosSubmarine()[0] != null) {
            for (int i = 0; i < pieces.getPosSubmarine().length; i++) {
                if (pieces.getPosSubmarine()[i].getCol() == col && pieces.getPosSubmarine()[i].getRow() == row) {
                    return true;
                }
            }
        }
        return false;
    }


    public void pieceSetup() {
        while (pieces.getPiecesPlaced() < 5) {
            int currentPieceSize = currentPiece.getWidth() / Field.cellSize;
            int colRandom = (int) Math.floor(Math.random() * (25 - 5 + 1) + 5);
            int rowRandom = (int) Math.floor(Math.random() * (20 - 10 + 1) + 10);
            Position[] thisBoatPositions = new Position[currentPiece.getWidth() / Field.cellSize];

            while ((colRandom + currentPieceSize > 18 || colRandom < 0 || rowRandom < 10 || rowRandom > 17) || isHereABoat(colRandom, rowRandom)) {
                colRandom = (int) Math.floor(Math.random() * (25 - 5 + 1) + 5);
                rowRandom = (int) Math.floor(Math.random() * (20 - 10 + 1) + 10);
            }

            for (int i = 0; i < (currentPieceSize); i++) {
                thisBoatPositions[i] = new Position(colRandom++, rowRandom);
                thisBoatPositions[i].isBoat();
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

            currentPiece = this.pieces.getNextPiece();
        }

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

    public Position getCursorPosition() {
        return cursorPosition;
    }

    public int random02(){
        return (int) Math.floor(Math.random() * 3);
    }

    public void setCursorPosition() {

        int col = (int) Math.floor(Math.random() * 19);
        int row = (int) Math.floor(Math.random() * 9);

        if (usedPos != null) {
            for (Position pos : usedPos) {
                while (pos.getCol() == col && pos.getRow() == row) {
                    col = (int) Math.floor(Math.random() * 19);
                    row = (int) Math.floor(Math.random() * 9);
                }
            }
            usedPos.add(new Position(col, row));
        }

        this.cursorPosition.setCol(col);
        this.cursorPosition.setRow(row);

    }

    public void setScore() {
        this.score += 50;
    }
}

