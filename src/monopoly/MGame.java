package monopoly;

import java.util.ArrayList;
import java.util.List;

public class MGame {
    private static final int N = 20;
    private int roundCnt;
    private Die[] dice = {new Die(), new Die()};
    private List<Player> players;
    private Board board;

    public MGame() {
        board = new Board();
        players = new ArrayList<>();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void playGame() {
        for (roundCnt = 0; roundCnt < N; roundCnt++) {
            playRound();
        }
    }

    private void playRound() {
        for (Player player : players) {
            player.takeTurn();
        }
    }
}
