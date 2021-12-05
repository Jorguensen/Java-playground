import java.util.Objects;

public class Position {

    private int col;
    private int row;
    private boolean isMarked = false;
    private boolean isBoat = false;


    Position(int col, int row) {
        this.col = col;
        this.row = row;

    }


    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setIsMarked() {
        isMarked = true;
    }

    public boolean isMarked(){
        return this.isMarked;
    }

    public boolean getIsABoat(){ return isBoat;}

    public void isBoat() {
        isBoat = true;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return "Position{" +
                "col=" + col +
                ", row=" + row +
                '}';
    }



    @Override
    public int hashCode() {
        return Objects.hash(col, row);
    }
}
