package lab5.players;

import lab5.game.Board;
import lab5.game.PlayerToken;
import lab5.game.Position;

import java.util.List;
import java.util.Random;

public class OmolaPlayer extends Player {

    private Random rand = new Random();

    public OmolaPlayer(String name) {
        super(name);
    }

    @Override
    public Position pickNextMove(Board currentBoard) {

        // get all empty positions
        List<Position> empty = currentBoard.getEmptyCells();

        // just in case the board is already full
        if (empty.isEmpty()) {
            return null;
        }

        // who am I on this turn?
        PlayerToken turn = currentBoard.getNextTurnToken();
        PlayerToken opp = (turn == PlayerToken.X) ? PlayerToken.O : PlayerToken.X;

        // Try to find a winning move
        for (Position pos : empty) {
            Board copy = new Board(currentBoard);

            if (copy.getWinner() == turn) {
                return pos;
            }
        }

        //Try to block opponent's move
        for (Position pos : empty) {
            Board copy = new Board(currentBoard);

            copy.place(pos, opp);

            if (copy.getWinner() == opp) {
                return pos;
            }
        }

        // Will pick any available positions
        int index = rand.nextInt(empty.size());
        return empty.get(index);
    }
}
