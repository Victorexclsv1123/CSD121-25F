package lab5.players;

import lab5.game.Board;
import lab5.game.Position;

import java.util.List;
import java.util.Random;

public class RandomPlayer extends Player {

    private Random random = new Random();

    public RandomPlayer(String name) {
        super(name);
    }

    @Override
    public Position pickNextMove(Board currentBoard) {
        // Get all empty cells on the board
        List<Position> empty = currentBoard.getEmptyCells();

        if (empty.isEmpty()) {
            return null;
        }

        // Pick a random index from the list
        int index = random.nextInt(empty.size());

        // Return that position
        return empty.get(index);
    }
}
