package minesweepergui;
public class Cell {
    private boolean containsMine;
    private boolean isMarked;
    private boolean isRevealed;
    private int adjacentMines;
 
    public Cell() {
        this.containsMine = false;
        this.isMarked = false;
        this.isRevealed = false;
        this.adjacentMines = 0;
    }
 
    public boolean containsMine() {
        return containsMine;
    }
 
    public void setContainsMine(boolean containsMine) {
        this.containsMine = containsMine;
    }
 
    public boolean isMarked() {
        return isMarked;
    }
 
    public void setMarked(boolean marked) {
        isMarked = marked;
    }
 
    public boolean isRevealed() {
        return isRevealed;
    }
 
    public void setRevealed(boolean revealed) {
        isRevealed = revealed;
    }
 
    public int getAdjacentMines() {
        return adjacentMines;
    }
 
    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
    }
}