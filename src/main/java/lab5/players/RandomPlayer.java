package lab5.players;

import lab5.game.Board;
import lab5.game.Position;

import java.util.List;
import java.util.Random;

public class RandomPlayer extends Player {

    private Random randy = new Random();

    public RandomPlayer(String name) {
        super(name);
    }

    @Override
    public Position pickNextMove(Board currentBoard) {

        List<Position> empty = currentBoard.getEmptyCells();

        // just in case the board is full
        if (empty.size() == 0) {
            return null;
        }

        int index = randy.nextInt(empty.size());
        return empty.get(index);
    }
}
