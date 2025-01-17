/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minesweepergui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author User
 */
public class Difficulty {
    private JFrame frame = new JFrame("Welcome to Minesweeper");
    private JLabel textLabel = new JLabel();
    private JPanel textPanel = new JPanel();
    private JPanel boardPanel = new JPanel();
    private JPanel textPanel1 = new JPanel();
    private JButton easy = new JButton();
    private JButton normal = new JButton();
    private JButton hard = new JButton();

 
    public Difficulty() {
        frame.setVisible(true);
        frame.setSize(560, 560);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        textLabel.setFont(new Font("Arial", Font.BOLD, 25));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Choose Difficulty");
        textLabel.setOpaque(true);

 
        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);
        boardPanel.setBackground(Color.black);
        boardPanel.setLayout(new GridLayout(1, 3));
        boardPanel.setSize(500, 50);
        easy.setText("EASY");
        easy.setFont(new Font("Arial", Font.BOLD, 30));
        easy.setVisible(true);
        easy.setSize(50, 50);
        normal.setText("NORMAL");
        normal.setFont(new Font("Arial", Font.BOLD, 30));
        normal.setVisible(true);
        normal.setSize(50, 50);
        hard.setText("HARD");
        hard.setFont(new Font("Arial", Font.BOLD, 30));
        hard.setVisible(true);
        hard.setSize(50, 50);
 
       
        easy.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   
                    frame.setVisible(false);
                   EventQueue.invokeLater(() -> {
                   MinesweeperGUI ex = new MinesweeperGUI(10, 10, 11);
                   ex.setVisible(true);
        });
                }
            });
        normal.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   
                    frame.setVisible(false);
                    EventQueue.invokeLater(() -> {
                   MinesweeperGUI ex = new MinesweeperGUI(15, 15, 20);
                   ex.setVisible(true);
        });
                }
            });
        hard.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    frame.setVisible(false);
                    EventQueue.invokeLater(() -> {
                   MinesweeperGUI ex = new MinesweeperGUI(17, 17, 30);
                   ex.setVisible(true);
        });
                }
            });
        boardPanel.add(easy);
        boardPanel.add(normal);
        boardPanel.add(hard);
        frame.add(boardPanel);

 
            

}
}