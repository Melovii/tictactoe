package BroCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class startupWindow extends JFrame
{

    JButton startButton = new JButton("Start Game");
    JButton quitButton = new JButton("Quit Game");

    startupWindow()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(69, 69);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.setLocationRelativeTo(null);


        this.add(startButton, BorderLayout.NORTH);
        this.add(quitButton, BorderLayout.SOUTH);
        this.pack();

        this.setVisible(true);

        startButton.setFocusable(false);
        quitButton.setFocusable(false);

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        startButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                new myWindow();
            }
        });
    }
}
