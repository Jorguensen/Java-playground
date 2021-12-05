import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Pieces {

    private TypePiece[] typePiece;
    private Rectangle carrier;
    private Rectangle cruiser;
    private Rectangle destroyer;
    private Rectangle submarine;
    private Rectangle battleship;
    private Position[] posCarrier = new Position[5];
    private Position[] posCruiser = new Position[3];
    private Position[] posDestroyer = new Position[2];
    private Position[] posSubmarine = new Position[3];
    private Position[] posBattleship = new Position[4];
    private int piecesPlaced = 0;


    public Pieces(){
        createPieces();
    }


    public void createPieces() {
        this.typePiece = TypePiece.values();
        for (int i = 0; i < typePiece.length; i++) {
            switch (i) {
                case 0:
                    carrier = new Rectangle(Field.padding + (Field.cellSize) * 6, Field.padding + Field.cellSize, Field.cellSize * 5, Field.cellSize);
                    carrier.draw();
                    carrier.setColor(Color.GRAY);
                    carrier.fill();
                    break;
                case 1:
                    cruiser = new Rectangle(Field.padding + (Field.cellSize) * 6, Field.padding + Field.cellSize * 2, Field.cellSize * 3, Field.cellSize);
                    cruiser.draw();
                    cruiser.setColor(Color.GRAY);
                    cruiser.fill();
                    break;
                case 2:
                    destroyer = new Rectangle(Field.padding + (Field.cellSize) * 6, Field.padding + Field.cellSize * 3, Field.cellSize * 2, Field.cellSize);
                    destroyer.draw();
                    destroyer.setColor(Color.GRAY);
                    destroyer.fill();
                    break;
                case 3:
                    submarine = new Rectangle(Field.padding + (Field.cellSize) * 6, Field.padding + Field.cellSize * 4, Field.cellSize * 3, Field.cellSize);
                    submarine.draw();
                    submarine.setColor(Color.GRAY);
                    submarine.fill();
                    break;
                case 4:
                    battleship = new Rectangle(Field.padding + (Field.cellSize) * 6, Field.padding + Field.cellSize * 5, Field.cellSize * 4, Field.cellSize);
                    battleship.draw();
                    battleship.setColor(Color.GRAY);
                    battleship.fill();
                    break;
            }
        }


    }
    public Rectangle getCarrier() {
        return carrier;
    }

    public Rectangle getCruiser() {
        return cruiser;
    }

    public Rectangle getDestroyer() {
        return destroyer;
    }

    public Rectangle getSubmarine() {
        return submarine;
    }

    public Rectangle getBattleship() {
        return battleship;
    }

    public Position[] getPosCarrier() {
        return posCarrier;
    }

    public Position[] getPosCruiser() {
        return posCruiser;
    }

    public Position[] getPosDestroyer() {
        return posDestroyer;
    }

    public Position[] getPosSubmarine() {
        return posSubmarine;
    }

    public Position[] getPosBattleship() {
        return posBattleship;
    }

    public int getPiecesPlaced() {
        return piecesPlaced;
    }
    public void incrementPiecesPlaced() {
        this.piecesPlaced++;
    }

    public Rectangle getNextPiece(){
        switch(this.piecesPlaced){
            case 1:
                return cruiser;
            case 2:
                return destroyer;
            case 3:
                return submarine;
            case 4:
                return battleship;
        }
        return null;
    }

    public void setPosCarrier(Position[] posCarrier) {
        this.posCarrier = posCarrier;
    }

    public void setPosCruiser(Position[] posCruiser) {
        this.posCruiser = posCruiser;
    }

    public void setPosDestroyer(Position[] posDestroyer) {
        this.posDestroyer = posDestroyer;
    }

    public void setPosSubmarine(Position[] posSubmarine) {
        this.posSubmarine = posSubmarine;
    }

    public void setPosBattleship(Position[] posBattleship) {
        this.posBattleship = posBattleship;
    }



}

