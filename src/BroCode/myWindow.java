package BroCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myWindow extends JFrame {

    JButton[] boxes = new JButton[9];
    JPanel TitlePanel = new JPanel();
    JPanel GridPanel = new JPanel();
    JLabel BottomTitle = new JLabel();


    public int[] slots = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    myWindow() {
        for (int i = 0; i < boxes.length; i++) {
            final int INDEX = i;
            boxes[i] = new JButton();
            boxes[i].setFont(new Font("Calibri", Font.PLAIN, 69));
            boxes[i].setFocusable(false);
            GridPanel.add(boxes[i]);
            boxes[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (boxes[INDEX].getText().equals(""))
                    {
                        if ((counter % 2) == 1) // if counter is odd, it's O's turn
                        {
                            boxes[INDEX].setText(user1);
                            slots[INDEX] = 1;
                        } else // if counter is even, it's X's turn
                        {
                            boxes[INDEX].setText(user2);
                            slots[INDEX] = 0;
                        }
                    }
                    counter++;
                    checkDraw();
                    checkWinner();
                }
            });
        }

        // window settings
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

        this.add(GridPanel);
        this.add(BottomTitle, BorderLayout.NORTH);
        this.setVisible(true);

    }

    String user1 = "O";
    String user2 = "X";
    int counter = 0;

    public void whoWins() {
        boolean flag = true;
        if ((counter % 2) == 1) // if counter is odd, it's X's turn
        {
            BottomTitle.setText("X wins!");
            flag = false;
        }
        else if ((counter % 2 == 0))// if counter is even, it's O's turn
        {
            BottomTitle.setText("O wins!");
            flag = false;
        }
        if (flag == false)
        {
            for (int j=0; j<9; j++)
            {
                boxes[j].setEnabled(false);
            }
        }
    }

    public void checkDraw()
    {
        boolean empty_flag = false;
        for (int i=0; i<9; i++)
        {
            if (boxes[i].getText().equals(""))
            {
                empty_flag = true;
            }
        }
        if (empty_flag == false)
        {
            for (int j=0; j<9; j++)
            {
                boxes[j].setEnabled(false);
            }
            BottomTitle.setText("It's a draw!");
        }
    }


    public void checkWinner()
    {

        // horizontal line conditions
        if (slots[0] == slots[1] && slots[1] == slots[2]) {
            for (int i = 0; i < 3; i++)
            {
                boxes[i].setFont(new Font("Calibri", Font.BOLD, 69));
                boxes[i].setBackground(Color.GREEN);
            }
            whoWins();
        }

        if (slots[3] == slots[4] && slots[3] == slots[5]) {
            for (int i = 3; i < 6; i++)
            {
                boxes[i].setFont(new Font("Calibri", Font.BOLD, 69));
                boxes[i].setBackground(Color.GREEN);
            }
            whoWins();
        }

        if (slots[6] == slots[7] && slots[7] == slots[8]) {
            for (int i = 6; i < 9; i++)
            {
                boxes[i].setFont(new Font("Calibri", Font.BOLD, 69));
                boxes[i].setBackground(Color.GREEN);
            }
            whoWins();
        }

        // vertical line conditions

        if (slots[0] == slots[3] && slots[3] == slots[6])
        {
            for (int i=0; i<9; i+=3)
            {
                boxes[i].setFont(new Font("Calibri", Font.BOLD, 69));
                boxes[i].setBackground(Color.GREEN);
            }
            whoWins();
        }

        if (slots[1] == slots[4] && slots[4] == slots[7])
        {
            for (int i=1; i<9; i+=3)
            {
                boxes[i].setFont(new Font("Calibri", Font.BOLD, 69));
                boxes[i].setBackground(Color.GREEN);
            }
            whoWins();
        }

        if (slots[2] == slots[5] && slots[5] == slots[8])
        {
            for (int i=2; i<9; i+=3)
            {
                boxes[i].setFont(new Font("Calibri", Font.BOLD, 69));
                boxes[i].setBackground(Color.GREEN);
            }
            whoWins();
        }

        // diagonal line conditions
        if (slots[0] == slots[4] && slots[4] == slots[8])
        {
            for (int i=0; i<=8; i += 4)
            {
                boxes[i].setFont(new Font("Calibri", Font.BOLD, 69));
                boxes[i].setBackground(Color.GREEN);
            }
            whoWins();
        }
        if (slots[2] == slots[4] && slots[4] == slots[6])
        {
            for (int i=2; i<=6; i += 2)
            {
                boxes[i].setFont(new Font("Calibri", Font.BOLD, 69));
                boxes[i].setBackground(Color.GREEN);
            }
            whoWins();
        }
        // end of method
    }
}