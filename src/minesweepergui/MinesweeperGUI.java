package minesweepergui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
 
public class MinesweeperGUI extends JFrame {
    private Minefield minefield;
    private JButton[][] buttons;
 
    public MinesweeperGUI(int rows, int cols, int mines) {
        minefield = new Minefield(rows, cols, mines);
        buttons = new JButton[rows][cols];
        initUI(rows, cols);
    }
 
    private void initUI(int rows, int cols) {
        setTitle("Minesweeper");
        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(rows, cols));
 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        JButton button = (JButton) e.getSource();
                        int row = -1, col = -1;
                        for (int x = 0; x < rows; x++) {
                            for (int y = 0; y < cols; y++) {
                                if (buttons[x][y] == button) {
                                    row = x;
                                    col = y;
                                }
                            }
                        }
                        if (SwingUtilities.isLeftMouseButton(e)) {
                            minefield.revealCell(row, col);
                            updateBoard();
                            if (minefield.checkLoss(row, col)) {
                                JOptionPane.showMessageDialog(null, "You Lost!");
                                System.exit(0);
                            }
                            if (minefield.checkWin()) {
                                JOptionPane.showMessageDialog(null, "You Win!");
                                System.exit(0);
                            }
                        } else if (SwingUtilities.isRightMouseButton(e)) {
                            minefield.markCell(row, col);
                            updateBoard();
                        }
                    }
                });
                add(buttons[i][j]);
            }
        }
    }
 
    private void updateBoard() {
        for (int i = 0; i < minefield.getRows(); i++) {
            for (int j = 0; j < minefield.getCols(); j++) {
                Cell cell = minefield.getCell(i, j);
                if (cell.isRevealed()) {
                    if (cell.containsMine()) {
                        buttons[i][j].setText("💣");
                    } else {
                        buttons[i][j].setText(String.valueOf(cell.getAdjacentMines()));
                    }
                } else if (cell.isMarked()) {
                    buttons[i][j].setText("🚩");
                } else {
                    buttons[i][j].setText("");
                }
            }
        }
    }
 
    public static void main(String[] args) {
        Difficulty start = new Difficulty();
    }
}