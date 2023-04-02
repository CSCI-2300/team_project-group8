package wordlegame.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class UserGuessBox extends JPanel
{
    private JTextField textBox;


    public UserGuessBox()
    {
        //JPanel mainPanel = new JPanel();
        JButton enterButton = new JButton("enter");
        textBox = new JTextField(5);
        textBox.setPreferredSize( new Dimension( 5, 30 ) );
        this.add(textBox);
        this.add(enterButton);
        this.setPreferredSize(new Dimension(10, 30));
        this.setBackground(Color.BLACK);
    }

}