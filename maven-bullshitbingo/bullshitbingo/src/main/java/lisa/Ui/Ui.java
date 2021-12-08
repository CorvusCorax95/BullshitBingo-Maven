package lisa.Ui;

import lisa.Game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Collections;

public class Ui implements MouseListener {
    private JPanel rootPane;
    private final JFrame mainFrame;

    private JLabel[][] board = null;

    public Ui() {
        mainFrame = new JFrame();
        mainFrame.setTitle("Bullshit Bingo!");

        mainFrame.setSize(Constants.MAIN_WIDTH, Constants.MAIN_HEIGHT);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        board = new JLabel[Constants.COLUMNS][Constants.LINES];

    }

    public JLabel[][] getBoard() {
        return board;
    }

    public void initFunctionality(){

       JLabel End = new JLabel();
       JLabel Reset = new JLabel();
       JLabel New = new JLabel();

       Reset.setName("Reset");
       Reset.setOpaque(true);
       Reset.setBackground(Color.WHITE);
       Reset.setBounds(600, 470, 75, 25);
       Reset.setText("Reset");
       Reset.setHorizontalAlignment((SwingConstants.CENTER));
       Reset.setVerticalAlignment((SwingConstants.CENTER));
       Reset.addMouseListener(this);
       mainFrame.getContentPane().add(Reset);

        End.setName("End");
        End.setOpaque(true);
        End.setBackground(Color.WHITE);
        End.setBounds(600, 500, 75, 25);
        End.setText("End");
        End.setHorizontalAlignment((SwingConstants.CENTER));
        End.setVerticalAlignment((SwingConstants.CENTER));
        End.addMouseListener(this);
        mainFrame.getContentPane().add(End);

        New.setName("New");
        New.setOpaque(true);
        New.setBackground(Color.WHITE);
        New.setBounds(600, 440, 75, 25);
        New.setText("New");
        New.setHorizontalAlignment((SwingConstants.CENTER));
        New.setVerticalAlignment((SwingConstants.CENTER));
        New.addMouseListener(this);
        mainFrame.getContentPane().add(New);

    }

    public void initBoard() {

        this.mainFrame.setVisible(false);
        this.mainFrame.getContentPane().removeAll();
        initFunctionality();

        //using the nth entry of String array with possible options
        int pcount = 0;
        Collections.shuffle(Arrays.asList(Constants.bullshit));

        for (int i = 0; i < Constants.LINES; i++) {
            for (int j = 0; j < Constants.COLUMNS; j++) {
                board[i][j] = new JLabel();
                board[i][j].setName("board" + i + j);
                board[i][j].setOpaque(true);
                board[i][j].setBackground(Color.WHITE);
                board[i][j].setBounds(j * 125 + 30, i * 125 + 30, 120, 120);
                board[i][j].setText(Constants.bullshit[pcount]);
                board[i][j].setHorizontalAlignment((SwingConstants.CENTER));
                board[i][j].setVerticalAlignment((SwingConstants.CENTER));
                board[i][j].addMouseListener(this);

                mainFrame.getContentPane().add(board[i][j]);
                pcount++;
            }
        }
        mainFrame.getContentPane().revalidate();
        mainFrame.getContentPane().repaint();
        mainFrame.setVisible(true);

    }



    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getComponent().getName() == "Reset") {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    board[i][j].setBackground(Color.WHITE);
                }
            }

        } else if (e.getComponent().getName() == "End") {

            Game.setEndGame(true);
            mainFrame.getContentPane().removeAll();
            mainFrame.dispose();
            System.exit(0);

        } else if (e.getComponent().getName() == "New") {

            initBoard();

        } else {

            e.getComponent().setBackground(Color.GREEN);

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
