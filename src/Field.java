
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {

    public static final int padding = 10;
    public static final int cols = 25;
    public static final int rows = 25;
    public static int width;
    public static int height;
    public static final int cellSize = 32;
    public Rectangle canvas;
    public Position[] positionsAvailable = new Position[361];


    public Field() {

        width = cols * cellSize;
        height = rows * cellSize;

        canvas = new Rectangle(padding, padding, width, height);
        canvas.draw();

        int i = 0;
        while(i < 361) {
            for (int j = 0; j < cols - 6; j++) {
                for (int k = 0; k < rows - 6; k++) {
                    positionsAvailable[i] = new Position(j, k);
                    i++;
                }
            }
        }
    }

    public void markPos(Position position){
        for (int i = 0; i < positionsAvailable.length; i++) {
            if (positionsAvailable[i].getCol() == position.getCol() && positionsAvailable[i].getRow() == position.getRow()){
                positionsAvailable[i].setIsMarked();
            }
        }
    }

    public boolean checkIsMarked(Position position){
        for (int i = 0; i < positionsAvailable.length; i++) {
            if (positionsAvailable[i].getCol() == position.getCol() && positionsAvailable[i].getRow() == position.getRow() && positionsAvailable[i].isMarked()){
                return true;
            }
        }
        return false;
    }

    public boolean checkIsABoat (Position position){
        for (int i = 0; i < positionsAvailable.length; i++) {
            if (positionsAvailable[i].getCol() == position.getCol() && positionsAvailable[i].getRow() == position.getRow() && positionsAvailable[i].getIsABoat()){
                return true;
            }
        }
        return false;
    }
}
