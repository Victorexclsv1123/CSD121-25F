# AI Use Statement

I watched YT and CHATGPT to help me finish  this lab

# AI Conversations

act a my tutor in programming and guide me steps by steps
ChatGPT said:
Thought for 39s

awesome—i’ll be your programming tutor. here’s a clear, step-by-step plan and a first lesson you can do right now. we’ll use Python, Java, and a bit of SQL since those match what you’re studying.

your roadmap (simple + doable)

Daily (60–90 min):

10 min — review notes from yesterday

30–45 min — new concept + tiny practice

15–30 min — mini-project or kata

5 min — write 2 bullets of what you learned

Tools check (once):

Python py --version (or python --version)

Java java --version (aim for 21)

Git git --version

Editors: VS Code or IntelliJ; DB tool: DBeaver/SQLite

Create a workspace:

dev/
01-python/
02-java/
03-sql/


Initialize Git in dev:

cd dev
git init

week 1 plan (at a glance)

Day 1: variables, loops, strings (Py) · classes 101 (Java) · SELECT basics (SQL)

Day 2: functions + tests (Py) · constructors/getters (Java) · WHERE/ORDER BY (SQL)

Day 3: lists/dicts (Py) · arrays & ArrayList (Java) · JOIN intro (SQL)

Day 4: file I/O (Py) · toString/equals (Java) · GROUP BY (SQL)

Day 5: small console app: Note Keeper (Py)

Day 6: small OOP app: Task class + Manager (Java)

Day 7: review, refactor, commit history tidy-up

lesson 1 — do this now ✅

Pick Python first (fast win). If you prefer Java, jump to part B; SQL is part C.

A) Python — strings & loops (25–35 min)

1. Create a file 01-python/lesson1.py with these tasks:

Write count_vowels(s) → returns how many a/e/i/o/u (case-insensitive).

Write reverse_words(s) → "hello world" → "world hello".

Write caesar_encrypt(text, shift) → shift letters A–Z/a–z; keep spaces/punctuation.

Starter skeleton (type it out, then complete):

def count_vowels(s: str) -> int:
# TODO: loop characters and count vowels
return 0

def reverse_words(s: str) -> str:
# TODO: split, reverse, join
return ""

def caesar_encrypt(text: str, shift: int) -> str:
# TODO: shift letters; preserve case; wrap around
return ""

if __name__ == "__main__":
print(count_vowels("Sault College"))   # expect: 5
print(reverse_words("I love coding"))  # "coding love I"
print(caesar_encrypt("abc XYZ!", 2))   # "cde ZAB!"


2. Run it (python lesson1.py) and fix any errors.
3. Commit it:

git add 01-python/lesson1.py
git commit -m "Lesson 1: loops & strings"


Stretch: add caesar_decrypt by calling encrypt(text, -shift).

B) Java — class basics (20–30 min)

Goal: make a tiny Rectangle class and test it.

Create 02-java/src/Main.java and 02-java/src/Rectangle.java.

Rectangle.java (skeleton):

public class Rectangle {
private double width;
private double height;

    public Rectangle(double width, double height) {
        // TODO: set fields; validate > 0
    }

    public double area() { return 0.0; }      // TODO
    public double perimeter() { return 0.0; } // TODO

    @Override
    public String toString() {
        // e.g., "Rectangle(3.0 x 4.0, area=12.0, perim=14.0)"
        return "";
    }
}


Main.java (skeleton):

public class Main {
public static void main(String[] args) {
Rectangle r = new Rectangle(3, 4);
System.out.println(r.area());      // 12.0
System.out.println(r.perimeter()); // 14.0
System.out.println(r);
}
}


Compile/run (IntelliJ or javac/java). Commit when it works.

C) SQL — warm-up (10–15 min)

In SQLite or MySQL, create a tiny table and query:

CREATE TABLE students(
id INTEGER PRIMARY KEY,
name TEXT NOT NULL,
grade INTEGER
);

INSERT INTO students(name, grade) VALUES
('Ava', 85), ('Ben', 92), ('Chloe', 74);

-- Queries:
SELECT * FROM students;
SELECT name, grade FROM students WHERE grade >= 80 ORDER BY grade DESC;


Save the script as 03-sql/lesson1.sql and commit.

how we’ll work together

you do the tasks above.

paste your code/output (or errors) here.

I’ll review, correct, and give you the next micro-step + a small challenge.

If you want, I can also turn this into a weekly checklist you can print or track—just say the word. Ready when you are—start with Python A-1 and show me your result!

You said:
for (int row = 0; row < board.length; row++) {
for (int col = 0; col < board[row].length; col++) {
board[row][col] = ' ';
}
}

what could be the error?
ChatGPT said:

That loop is syntactically correct, so if you’re getting an error, it’s likely caused by something outside the loop. Let’s go through all possible cases step by step 👇

✅ Correct usage (what it should look like)
char[][] board = new char[3][3];

for (int row = 0; row < board.length; row++) {
for (int col = 0; col < board[row].length; col++) {
board[row][col] = ' ';
}
}


This fills a 2D char array with blank spaces ' '.

⚠️ Possible causes of errors
1. board is not initialized

You might have declared the array but never gave it a size:

char[][] board;


❌ This will cause a NullPointerException.

✅ Fix:

board = new char[3][3];

2. Array type mismatch

If board isn’t a char[][] (for example it’s String[][]), assigning ' ' (a char literal) causes:

incompatible types: char cannot be converted to String


✅ Fix:

Either change ' ' → " " if it’s a String[][],

Or make the array type char[][].

3. Out-of-bounds indexing

If you accidentally used wrong limits like:

for (int row = 0; row <= board.length; row++)


then you’ll get:

ArrayIndexOutOfBoundsException


✅ Fix: use < board.length, not <=.

4. Null row

If you made a jagged array (e.g. board = new char[3][];), then board[row] is null until you allocate each subarray.

✅ Fix:

for (int row = 0; row < board.length; row++) {
board[row] = new char[3]; // initialize each row
for (int col = 0; col < board[row].length; col++) {
board[row][col] = ' ';
}
}

🧠 Debug tip

To see exactly what’s wrong, print before the loop:

System.out.println(board); // or use Arrays.deepToString(board)


If it prints null, you forgot to allocate it.

Would you like to show me the full part of your code where you declared board?
That way I can pinpoint the exact line causing your error.

You said:
tic tac toe game
ChatGPT said:

nice—let’s build a simple console Tic-Tac-Toe in Java step by step. this fixes the board-init issue you had and gives you a full playable loop.

1) create Main.java

Paste this whole file into your src folder and run it.

import java.util.Scanner;

public class Main {
// --- Game state ---
private static final int N = 3;
private static final char[][] board = new char[N][N];
private static char current = 'X'; // X goes first

    public static void main(String[] args) {
        initBoard();
        Scanner sc = new Scanner(System.in);

        while (true) {
            printBoard();

            // 1) get a valid move
            int row, col;
            while (true) {
                System.out.printf("Player %c, enter row and col (1-3 1-3): ", current);
                if (!sc.hasNextInt()) { sc.next(); continue; }
                row = sc.nextInt();
                if (!sc.hasNextInt()) { sc.next(); continue; }
                col = sc.nextInt();

                // convert to 0-based
                row--; col--;

                if (inBounds(row, col) && board[row][col] == ' ') {
                    break;
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            }

            // 2) apply move
            board[row][col] = current;

            // 3) check win/draw
            if (isWin(current)) {
                printBoard();
                System.out.printf("Player %c wins!%n", current);
                break;
            }
            if (isDraw()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }

            // 4) swap player
            current = (current == 'X') ? 'O' : 'X';
        }

        sc.close();
    }

    // --- Helpers ---

    private static void initBoard() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                board[r][c] = ' '; // <— your loop is correct if board is allocated
            }
        }
    }

    private static boolean inBounds(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    private static void printBoard() {
        System.out.println();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(" " + board[r][c] + " ");
                if (c < N - 1) System.out.print("|");
            }
            System.out.println();
            if (r < N - 1) System.out.println("---+---+---");
        }
        System.out.println();
    }

    private static boolean isWin(char p) {
        // rows
        for (int r = 0; r < N; r++) {
            if (board[r][0] == p && board[r][1] == p && board[r][2] == p) return true;
        }
        // cols
        for (int c = 0; c < N; c++) {
            if (board[0][c] == p && board[1][c] == p && board[2][c] == p) return true;
        }
        // diags
        if (board[0][0] == p && board[1][1] == p && board[2][2] == p) return true;
        if (board[0][2] == p && board[1][1] == p && board[2][0] == p) return true;
        return false;
    }

    private static boolean isDraw() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (board[r][c] == ' ') return false;
            }
        }
        return true;
    }
}

2) how to run

In IntelliJ: Right-click Main.java → Run 'Main.main()'

CLI:

javac Main.java
java Main

3) quick checklist (to pass most rubrics)

✅ clean board print

✅ input validation (only empty cells, in bounds)

✅ win + draw detection

✅ alternating players

4) common pitfalls (if you still see errors)

NullPointerException: you didn’t allocate the board (new char[3][3]). In the code above it’s allocated globally.

ArrayIndexOutOfBoundsException: don’t use <=; keep < N. Also convert user input (1–3) to 0–2.

String vs char: board is char[][], so use ' ' not " ".

want the OOP version with a Board class and unit tests next? I can refactor this into Board, Game, and Main with JavaDoc to match your lab style.

You said:
chart layout
ChatGPT said:

can you clarify what you mean by “chart layout”?
are you referring to:

📊 Tic Tac Toe board layout (visual grid) in your java console?

📈 chart layout for forex/trading (like in TradingView or MT5)?

🧩 a GUI (JavaFX/Swing) layout that displays the tic tac toe board graphically?

once i know which one you mean, i’ll show you step-by-step how to build that exact layout (code or visual). which one do you want?

You said:
tictac toe
ChatGPT said:
Thought for 5s

gotcha—Tic-Tac-Toe layout. here are two clean options you can use right away:

A) nice console layout (simple & clear)

Shows a grid with coordinates so players know where to play.

public class BoardPrinter {
public static void print(char[][] b) {
System.out.println("    1   2   3");
for (int r = 0; r < 3; r++) {
System.out.printf("%d  ", r + 1);
for (int c = 0; c < 3; c++) {
char cell = (b[r][c] == 0) ? ' ' : b[r][c];
System.out.print(" " + cell + " ");
if (c < 2) System.out.print("|");
}
System.out.println();
if (r < 2) System.out.println("   ---+---+---");
}
System.out.println();
}
}


Use it:

char[][] board = new char[3][3]; // default '\0'
BoardPrinter.print(board);

B) JavaFX GUI layout (buttons in a 3×3 grid)

This gives you a clickable board. Paste into Main.java (JavaFX project).

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
private final Button[][] cells = new Button[3][3];
private char current = 'X';
private final Label status = new Label("Player X to move");

    @Override
    public void start(Stage stage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(8);
        grid.setVgap(8);
        grid.setPadding(new Insets(12));

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                Button btn = new Button(" ");
                btn.setMinSize(80, 80);
                btn.setStyle("-fx-font-size: 28; -fx-font-weight: bold;");
                final int rr = r, cc = c;
                btn.setOnAction(e -> handleMove(rr, cc));
                cells[r][c] = btn;
                grid.add(btn, c, r);
            }
        }

        Button reset = new Button("Reset");
        reset.setOnAction(e -> resetBoard());

        BorderPane root = new BorderPane();
        root.setCenter(grid);
        BorderPane bottom = new BorderPane();
        bottom.setLeft(status);
        bottom.setRight(reset);
        bottom.setPadding(new Insets(10, 12, 10, 12));
        root.setBottom(bottom);

        Scene scene = new Scene(root, 340, 360);
        stage.setTitle("Tic-Tac-Toe");
        stage.setScene(scene);
        stage.show();
    }

    private void handleMove(int r, int c) {
        Button b = cells[r][c];
        if (!b.getText().isBlank()) return; // already filled
        b.setText(String.valueOf(current));

        if (isWin(current)) {
            status.setText("Player " + current + " wins!");
            lockBoard();
            return;
        }
        if (isDraw()) {
            status.setText("It's a draw!");
            return;
        }

        current = (current == 'X') ? 'O' : 'X';
        status.setText("Player " + current + " to move");
    }

    private boolean isWin(char p) {
        String s = String.valueOf(p).repeat(3);
        // rows & cols
        for (int i = 0; i < 3; i++) {
            if ((cells[i][0].getText() + cells[i][1].getText() + cells[i][2].getText()).equals(s)) return true;
            if ((cells[0][i].getText() + cells[1][i].getText() + cells[2][i].getText()).equals(s)) return true;
        }
        // diagonals
        if ((cells[0][0].getText() + cells[1][1].getText() + cells[2][2].getText()).equals(s)) return true;
        if ((cells[0][2].getText() + cells[1][1].getText() + cells[2][0].getText()).equals(s)) return true;
        return false;
        }

    private boolean isDraw() {
        for (Button[] row : cells)
            for (Button b : row)
                if (b.getText().isBlank()) return false;
        return true;
    }

    private void lockBoard() {
        for (Button[] row : cells)
            for (Button b : row) b.setDisable(true);
    }

    private void resetBoard() {
        for (Button[] row : cells)
            for (Button b : row) { b.setText(" "); b.setDisable(false); }
        current = 'X';
        status.setText("Player X to move");
    }

    public static void main(String[] args) {
        launch(args);
    }
}


Run tips (JavaFX):

IntelliJ: add JavaFX SDK to project; VM options:
--module-path <path to javafx>/lib --add-modules javafx.controls,javafx.graphics

If you don’t have JavaFX set up, stick to the console version first.

want me to turn this into an OOP design (Board, Game, AIPlayer) next, or add a winning-line highlight in JavaFX?

You said:
package lab3.ui;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        char[][] board = new char[3][3];

        // Initialize the board with spaces
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            printBoard(board);
            System.out.println("Player " + player + ", enter your move (row and column):");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid move. Please enter values between 0 and 2.");
                continue;
            }

            if (board[row][col] == ' ') {
                board[row][col] = player;

                if (Winner(board, player)) {
                    printBoard(board);
                    System.out.println("Congratulations! Player " + player + " wins!");
                    gameOver = true;
                } else if (isBoardFull(board)) {
                    printBoard(board);
                    System.out.println("It's a draw!");
                    gameOver = true;
                } else {
                    player = (player == 'X') ? 'O' : 'X'; // switch player
                }

            } else {
                System.out.println("Invalid move. Cell already taken.");
            }




        }

        scanner.close();
    }


    public static void printBoard(char[][] board) {
        System.out.println("Current Board:");
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print("[" + board[row][col] + "]");
            }
            System.out.println();
        }
    }

    public static boolean Winner(char[][] board, char player) {
        // Check rows
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    public static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

}

this is my code from youtube and help me in encapsulation
ChatGPT said:
Thought for 16s

Great start! To apply encapsulation, we’ll hide the raw char[][] behind a Board class (fields private), and expose only safe methods (e.g., place, getCell, isFull, hasWinner). Then a Game class will own the game flow/state (currentPlayer, isOver) and the Main class will only handle I/O. No more direct array poking from Main.

Here’s a clean 3-file refactor you can drop in:

Board.java (encapsulates the grid)
package lab3.ui;

public class Board {
private static final int N = 3;
private final char[][] grid = new char[N][N];

    public Board() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                grid[r][c] = ' ';
            }
        }
    }

    public int size() { return N; }

    /** Read-only access to a cell (no setter exposes the array!). */
    public char getCell(int row, int col) {
        requireInBounds(row, col);
        return grid[row][col];
    }

    /** Attempt to place a mark; returns true if successful. */
    public boolean place(int row, int col, char player) {
        requireInBounds(row, col);
        if (grid[row][col] != ' ') return false;
        grid[row][col] = player;
        return true;
    }

    public boolean isFull() {
        for (int r = 0; r < N; r++)
            for (int c = 0; c < N; c++)
                if (grid[r][c] == ' ') return false;
        return true;
    }

    public boolean hasWinner(char p) {
        // rows
        for (int r = 0; r < N; r++)
            if (grid[r][0] == p && grid[r][1] == p && grid[r][2] == p) return true;
        // cols
        for (int c = 0; c < N; c++)
            if (grid[0][c] == p && grid[1][c] == p && grid[2][c] == p) return true;
        // diags
        if (grid[0][0] == p && grid[1][1] == p && grid[2][2] == p) return true;
        if (grid[0][2] == p && grid[1][1] == p && grid[2][0] == p) return true;
        return false;
    }

    /** Pretty console render (no external mutation). */
    public void print() {
        System.out.println("    1   2   3");
        for (int r = 0; r < N; r++) {
            System.out.printf("%d  ", r + 1);
            for (int c = 0; c < N; c++) {
                System.out.print(" " + grid[r][c] + " ");
                if (c < N - 1) System.out.print("|");
            }
            System.out.println();
            if (r < N - 1) System.out.println("   ---+---+---");
        }
        System.out.println();
    }

    private void requireInBounds(int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= N)
            throw new IndexOutOfBoundsException("Row/Col must be 0..2");
    }
}

Game.java (encapsulates game state/logic)
package lab3.ui;

public class Game {
private final Board board = new Board();
private char current = 'X';
private boolean over = false;
private Character winner = null; // null = none yet

    public Board getBoard() { return board; }
    public char getCurrentPlayer() { return current; }
    public boolean isOver() { return over; }
    public Character getWinner() { return winner; } // may be null

    /**
     * Play a turn. Returns:
     *  - true if the move was accepted, false if the cell was taken.
     * Throws IndexOutOfBoundsException for bad coordinates.
     */
    public boolean play(int row, int col) {
        ensureNotOver();
        boolean placed = board.place(row, col, current);
        if (!placed) return false;

        if (board.hasWinner(current)) {
            over = true;
            winner = current;
        } else if (board.isFull()) {
            over = true; // draw, winner stays null
        } else {
            current = (current == 'X') ? 'O' : 'X';
        }
        return true;
    }

    private void ensureNotOver() {
        if (over) throw new IllegalStateException("Game is already over");
    }
}

Main.java (UI only; no direct array access)
package lab3.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
Game game = new Game();
Scanner sc = new Scanner(System.in);

        while (!game.isOver()) {
            game.getBoard().print();
            System.out.printf("Player %c, enter row and col (1-3 1-3): ",
                    game.getCurrentPlayer());

            int row, col;
            try {
                row = sc.nextInt() - 1; // to 0-based
                col = sc.nextInt() - 1;
            } catch (InputMismatchException e) {
                System.out.println("Please enter two integers like: 2 3");
                sc.nextLine(); // clear bad input
                continue;
            }

            try {
                boolean ok = game.play(row, col);
                if (!ok) {
                    System.out.println("Cell already taken. Try another.");
                }
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Out of bounds. Use 1..3 for row and col.");
            } catch (IllegalStateException ex) {
                System.out.println(ex.getMessage());
            }
        }

        // end screen
        game.getBoard().print();
        Character winner = game.getWinner();
        if (winner == null) System.out.println("It's a draw!");
        else System.out.printf("Congratulations! Player %c wins!%n", winner);

        sc.close();
    }
}

What changed (encapsulation wins)

board is private inside Board. Only Board mutates it.

Main can’t touch the array; it goes through public methods (place, getCell, hasWinner, isFull, print).

Game owns flow and current player; Main just asks for input & displays output.

Safer API: bounds checking and illegal states throw exceptions instead of silently corrupting state.

Quick tasks for you

Create the three files above (same package).

Run Main.

If you need to satisfy a rubric: add JavaDoc comments to all public methods and write a tiny unit test for Board.place and Board.hasWinner.

Want me to add JavaDoc + JUnit tests next, or evolve this into a GUI (JavaFX) using the same Board/Game classes?

You said:
public boolean hasWinner(char p) {
// rows
for (int r = 0; r < N; r++)
if (grid[r][0] == p && grid[r][1] == p && grid[r][2] == p) return true;
// cols
for (int c = 0; c < N; c++)
if (grid[0][c] == p && grid[1][c] == p && grid[2][c] == p) return true;
// diags
if (grid[0][0] == p && grid[1][1] == p && grid[2][2] == p) return true;
if (grid[0][2] == p && grid[1][1] == p && grid[2][0] == p) return true;
return false;

can u explaimn this code is
ChatGPT said:

perfect question 👏 let’s break down what that hasWinner() method actually does and why it’s written this way.

🧩 What this method does

It checks whether a player (p) has won the tic-tac-toe game — that means the player has filled an entire row, column, or diagonal with their symbol ('X' or 'O').

💡 Step-by-step explanation
public boolean hasWinner(char p) {


p is the player symbol being checked, e.g., 'X' or 'O'.

The method returns true if that player has a winning line, otherwise false.

1️⃣ Check all rows
for (int r = 0; r < N; r++)
if (grid[r][0] == p && grid[r][1] == p && grid[r][2] == p) return true;


Loops through each row r.

Checks if all 3 cells in that row match the same player symbol.

Example:

X | X | X
- + - + -
|   |


If player 'X' owns the whole first row, the condition is true → returns true.

2️⃣ Check all columns
for (int c = 0; c < N; c++)
if (grid[0][c] == p && grid[1][c] == p && grid[2][c] == p) return true;


Loops through each column c.

Checks if all 3 cells in that column match the player.

Example:

X |   |  
X |   |  
X |   |


That means 'X' wins vertically.

3️⃣ Check diagonals
if (grid[0][0] == p && grid[1][1] == p && grid[2][2] == p) return true;
if (grid[0][2] == p && grid[1][1] == p && grid[2][0] == p) return true;


There are two diagonals:

Main diagonal (↘) from top-left to bottom-right: (0,0), (1,1), (2,2)

Anti-diagonal (↙) from top-right to bottom-left: (0,2), (1,1), (2,0)

If either diagonal is filled with the same player, that’s also a win.

4️⃣ No wins found
return false;


If none of the above checks succeeded, the player hasn’t won yet.

✅ Summary
Check Type	Coordinates Checked	Example Pattern	Meaning
Rows	(r,0)(r,1)(r,2)	X X X in one row	Horizontal win
Columns	(0,c)(1,c)(2,c)	X down a column	Vertical win
Diagonal	(0,0)(1,1)(2,2)	↘ diagonal	Win top-left → bottom-right
Anti-Diagonal	(0,2)(1,1)(2,0)	↙ diagonal	Win top-right → bottom-left

would you like me to draw an ASCII visual (grid) showing how each check looks? it can help you visualize exactly which cells are being compared in each loop.