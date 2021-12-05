public enum TypePiece {

    CARRIER(5),
    BATTLESHIP(4),
    CRUISER(3),
    SUBMARINE(3),
    DESTROYER(2);

    private int positions;

    TypePiece (int positions) {
        this.positions=positions;
    }
}
