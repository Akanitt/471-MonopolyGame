package monopoly;

public class Player {
    private String name;
    private Die[] dice;
    private Board board;
    private Piece piece;

    public Player(String name, Die[] dice, Board board) {
        this.name = name;
        this.dice = dice;
        this.board = board;
        piece = new Piece(board.getStartSquare());
    }

    public void takeTurn() {
        int fvTot = 0;
        for (Die die : dice) {
            die.roll();
            fvTot += die.getFaceValue();
        }
        Square oldLoc = getLocation();
        Square newLoc = board.getSquare(oldLoc, fvTot);
        piece.setLocation(newLoc);
    }

    public Square getLocation() {
        return piece.getLocation();
    }

    public String getName() {
        return name;
    }
}
