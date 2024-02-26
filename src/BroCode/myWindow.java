package BroCode;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myWindow extends JFrame implements ActionListener {

    JButton[] box = new JButton[9];
    JPanel TitlePanel = new JPanel();
    JLabel BottomTitle = new JLabel();
    JPanel GridPanel = new JPanel();

    public int[] slots = new int[9];

    boolean player1_turn;
    int counter = 0;

    // Winning patterns
    int[][] winningPatterns = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // horizontal
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // vertical
            {0, 4, 8}, {2, 4, 6}              // diagonal
    };

    // Window settings
    myWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420, 520);
        this.getContentPane().setBackground(Color.darkGray);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        BottomTitle.setBackground(Color.DARK_GRAY);
        BottomTitle.setForeground(Color.WHITE);
        BottomTitle.setFont(new Font("Calibri", Font.PLAIN, 69));
        BottomTitle.setHorizontalAlignment(JLabel.CENTER);
        BottomTitle.setText("Tic-Tac-Toe");
        BottomTitle.setOpaque(true);

        TitlePanel.setLayout(new BorderLayout());
        TitlePanel.setBounds(0, 0, 420, 100);
        TitlePanel.add(BottomTitle);

        GridPanel.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 9; i++) {
            box[i] = new JButton();
            box[i].setFont(new Font("Calibri", Font.PLAIN, 69));
            box[i].setFocusable(false);
            box[i].addActionListener(this);
            GridPanel.add(box[i]);
        }

        this.add(GridPanel);
        this.add(BottomTitle, BorderLayout.NORTH);
        this.setVisible(true);
    }

    public void checkTurn() {
        player1_turn = counter % 2 == 0;
        counter++;
    }

    public boolean checkWin() {
        for (int[] pattern : winningPatterns) {
            if (box[pattern[0]].getText().equals(box[pattern[1]].getText()) &&
                    box[pattern[1]].getText().equals(box[pattern[2]].getText()) &&
                    !box[pattern[0]].getText().isEmpty()) {
                // Highlight winning pattern
                for (int i : pattern) {
                    box[i].setBackground(Color.GREEN);
                }
                return true;
            }
        }
        return false;
    }

    public boolean checkDraw() {
        for (int i = 0; i < 9; i++) {
            if (box[i].getText().isEmpty()) {
                return false; // If any button is empty, game is not draw
            }
        }
        return true; // All buttons filled, game is draw
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == box[i]) {
                if (box[i].getText().isEmpty()) {
                    checkTurn();
                    if (player1_turn) {
                        box[i].setText("X");
                    } else {
                        box[i].setText("O");
                    }

                    if (checkWin()) {
                        BottomTitle.setText(player1_turn ? "Player X wins!" : "Player O wins!");
                        for (JButton button : box) {
                            button.setEnabled(false);
                        }
                    } else if (checkDraw()) {
                        BottomTitle.setText("It's a draw!");
                        for (JButton button : box) {
                            button.setEnabled(false);
                        }
                    }
                }
            }
        }
    }
}