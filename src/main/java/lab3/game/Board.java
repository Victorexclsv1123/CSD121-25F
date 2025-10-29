package lab3.game;

public class Board {
    public static final int SIZE = 3;
    public static final char EMPTY = ' ';

    private final char[][] cells;

    public Board() {
        this.cells = new char[SIZE][SIZE];
        reset();
    }

    /** Clears the board to all EMPTY cells. */
    public void reset() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                cells[r][c] = EMPTY;
            }
        }
    }

    /** Returns the mark at (row, col). */
    public char get(int row, int col) {
        requireInBounds(row, col);
        return cells[row][col];
    }

    /** True if (row, col) is empty. */
    public boolean isEmpty(int row, int col) {
        requireInBounds(row, col);
        return cells[row][col] == EMPTY;
    }

    /**
     * Places a mark ('X' or 'O') at (row, col) if empty.
     * @throws IllegalArgumentException if out of bounds, invalid mark, or the cell is taken.
     */
    public void place(int row, int col, char mark) {
        requireInBounds(row, col);
        if (mark != 'X' && mark != 'O') {
            throw new IllegalArgumentException("Mark must be 'X' or 'O'.");
        }
        if (!isEmpty(row, col)) {
            throw new IllegalArgumentException("Cell already taken.");
        }
        cells[row][col] = mark;
    }

    /** True if all 9 cells are filled. */
    public boolean isFull() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (cells[r][c] == EMPTY) return false;
            }
        }
        return true;
    }

    /** True if the given player ('X' or 'O') has three in a row. */
    public boolean isWinner(char player) {
        // rows
        for (int r = 0; r < SIZE; r++) {
            if (cells[r][0] == player && cells[r][1] == player && cells[r][2] == player) return true;
        }
        // columns
        for (int c = 0; c < SIZE; c++) {
            if (cells[0][c] == player && cells[1][c] == player && cells[2][c] == player) return true;
        }
        // diagonals
        if (cells[0][0] == player && cells[1][1] == player && cells[2][2] == player) return true;
        if (cells[0][2] == player && cells[1][1] == player && cells[2][0] == player) return true;

        return false;
    }

    /** Returns a simple string rendering of the board. */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Current Board:\n");
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                sb.append('[').append(cells[r][c]).append(']');
            }
            sb.append('\n');
        }
        return sb.toString();
    }


    private void requireInBounds(int row, int col) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            throw new IllegalArgumentException("Indices must be between 0 and " + (SIZE - 1));
        }
    }
}
/* */