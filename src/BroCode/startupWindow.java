package BroCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class startupWindow extends JFrame
{

    JButton startButton = new JButton("Start Game");

    startupWindow()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(69, 69);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.setLocationRelativeTo(null);


        this.add(startButton, BorderLayout.CENTER);
        this.setVisible(true);

        startButton.setFocusable(false);
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
