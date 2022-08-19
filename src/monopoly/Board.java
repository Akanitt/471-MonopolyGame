package monopoly;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final int SIZE = 40;
    private List<Square> squares = new ArrayList<>(SIZE);

    public Board() {
        buildSquares();
        linkSquares();
    }

    public Square getSquare(Square oldLoc, int step) {
        int newLoc = (oldLoc.getIndex() + step) % SIZE;
        return squares.get(newLoc);
    }
    public Square getStartSquare() {
        return squares.get(0);
    }

    private void buildSquares() {
        for (int i = 0; i < SIZE; i++) {
            build(i);
        }
    }

    private void build(int i) {
        Square s = new Square("Square " + i, i - 1);
        squares.add(s);
    }

    private void linkSquares() {
        for (int i = 0; i < (SIZE - 1); i++) {
            link(i);
        }
        Square first = squares.get(0);
        Square last = squares.get(SIZE - 1);
        last.setNextSquare(first);
    }

    private void link(int i) {
        Square current = squares.get(i);
        Square next = squares.get(i + 1);
        current.setNextSquare(next);
    }
}
