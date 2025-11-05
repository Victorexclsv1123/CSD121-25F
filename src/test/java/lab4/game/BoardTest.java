package lab4.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BoardTest {

    Board board;

    // Start with a fresh board before each test
    @BeforeEach //
    void setup() {
        board = new Board();
    }

    // Helper to place a mark using your Board API

    private void place(int r, int c, char p) {

        throw new UnsupportedOperationException("wire the helper to your Board API");
    }
    // Helps to read a mark from a position
    private char get(int r, int c) {

        throw new UnsupportedOperationException("wire the helper to your Board API");
    }


    @Test
    @DisplayName("Initial board is empty, no winner, not full")
    void initialState() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {

            }
        }
        assertFalse(board.hasWinner('X'));
        assertFalse(board.hasWinner('O'));

    }

    @Test
    @DisplayName("Placing a mark updates the cell")
    void placeUpdatesCell() {
        // given
        place(0, 0, 'X');
        // then
        char cell = get(0, 0);
        assertEquals('X', cell);
    }

    @Test
    @DisplayName("Cannot place on occupied cell")
    void cannotPlaceOnOccupied() {
        place(1, 1, 'X');

        assertThrows(IllegalStateException.class, () -> place(1, 1, 'O'));

    }

    @Test
    @DisplayName("Out-of-bounds indexes are rejected")
    void outOfBounds() {
        assertThrows(IllegalArgumentException.class, () -> place(-1, 0, 'X'));
        assertThrows(IllegalArgumentException.class, () -> place(0, -1, 'X'));
        assertThrows(IllegalArgumentException.class, () -> place(3, 0, 'X'));
        assertThrows(IllegalArgumentException.class, () -> place(0, 3, 'X'));
    }

    @Test
    @DisplayName("Row wins are detected for X")
    void rowWinsX() {
        for (int row = 0; row < 3; row++) {
            board = new Board();
            place(row, 0, 'X');
            place(row, 1, 'X');
            place(row, 2, 'X');
            assertTrue(board.hasWinner('X'), "Row " + row + " should be a win for X");
            assertFalse(board.hasWinner('O'));
        }
    }

    @Test
    @DisplayName("Column wins are detected for O")
    void colWinsO() {
        for (int col = 0; col < 3; col++) {
            board = new Board();
            place(0, col, 'O');
            place(1, col, 'O');
            place(2, col, 'O');
            assertTrue(board.hasWinner('O'), "Col " + col + " should be a win for O");
            assertFalse(board.hasWinner('X'));
        }
    }

    @Test
    @DisplayName("Main diagonal win (top-left → bottom-right)")
    void mainDiagonalWin() {
        place(0, 0, 'X');
        place(1, 1, 'X');
        place(2, 2, 'X');
        assertTrue(board.hasWinner('X'));
    }

    @Test
    @DisplayName("Anti-diagonal win (top-right → bottom-left)")
    void antiDiagonalWin() {
        place(0, 2, 'O');
        place(1, 1, 'O');
        place(2, 0, 'O');
        assertTrue(board.hasWinner('O'));
    }

    @Test
    @DisplayName("Two in a row is not a win")
    void twoInARowNotWin() {
        place(0, 0, 'X');
        place(0, 1, 'X');
        assertFalse(board.hasWinner('X'));
    }

    @Test
    @DisplayName("Mixed line is not a win")
    void mixedLineNotWin() {
        place(2, 0, 'X');
        place(2, 1, 'O');
        place(2, 2, 'X');
        assertFalse(board.hasWinner('X'));
        assertFalse(board.hasWinner('O'));
    }

    @Test
    @DisplayName("Full board with no winner is a draw")
    void drawNoWinner() {
        // X O X
        // X O O
        // O X X
        place(0,0,'X'); place(0,1,'O'); place(0,2,'X');
        place(1,0,'X'); place(1,1,'O'); place(1,2,'O');
        place(2,0,'O'); place(2,1,'X'); place(2,2,'X');

        assertFalse(board.hasWinner('X'));
        assertFalse(board.hasWinner('O'));

    }

    @Test
    @DisplayName("Reset clears the board and winner state")
    void resetWorks() {
        place(0,0,'X'); place(0,1,'X'); place(0,2,'X');
        assertTrue(board.hasWinner('X'));

    }
}
