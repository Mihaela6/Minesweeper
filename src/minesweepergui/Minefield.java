package minesweepergui;
import java.util.Random;
 
public class Minefield {
    private Cell[][] field;
    private int rows;
    private int cols;
    private int mines;
 
    public Minefield(int rows, int cols, int mines) {
        this.rows = rows;
        this.cols = cols;
        this.mines = mines;
        this.field = new Cell[rows][cols];
        initField();
    }
 
    private void initField() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                field[i][j] = new Cell();
            }
        }
        placeMines();
        calculateAdjacentMines();
    }
 
    private void placeMines() {
        Random rand = new Random();
        int placedMines = 0;
 
        while (placedMines < mines) {
            int row = rand.nextInt(rows);
            int col = rand.nextInt(cols);
 
            if (!field[row][col].containsMine()) {
                field[row][col].setContainsMine(true);
                placedMines++;
            }
        }
    }
 
    private void calculateAdjacentMines() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!field[i][j].containsMine()) {
                    int count = 0;
                    for (int x = -1; x <= 1; x++) {
                        for (int y = -1; y <= 1; y++) {
                            int newRow = i + x;
                            int newCol = j + y;
                            if (isValidCell(newRow, newCol) && field[newRow][newCol].containsMine()) {
                                count++;
                            }
                        }
                    }
                    field[i][j].setAdjacentMines(count);
                }
            }
        }
    }
 
    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
 
    public void markCell(int row, int col) {
        if (isValidCell(row, col) && !field[row][col].isRevealed()) {
            field[row][col].setMarked(!field[row][col].isMarked());
        }
    }
 
    public void revealCell(int row, int col) {
        if (isValidCell(row, col) && !field[row][col].isRevealed() && !field[row][col].isMarked()) {
            field[row][col].setRevealed(true);
            if (field[row][col].containsMine()) {
                // Играчът е разкрил мина, загуба
                return;
            }
 
            if (field[row][col].getAdjacentMines() == 0) {
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        if (!(x == 0 && y == 0)) {
                            revealCell(row + x, col + y);
                        }
                    }
                }
            }
        }
    }
 
    public boolean checkWin() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!field[i][j].containsMine() && !field[i][j].isRevealed()) {
                    return false;
                }
            }
        }
        return true;
    }
 
    public boolean checkLoss(int row, int col) {
        return field[row][col].containsMine() && field[row][col].isRevealed();
    }
 
    // Getters за редове и колони за употреба в графичния интерфейс
    public int getRows() {
        return rows;
    }
 
    public int getCols() {
        return cols;
    }
 
    public Cell getCell(int row, int col) {
        return field[row][col];
    }
}