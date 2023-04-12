package wordlegame.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

import java.awt.event.*;
import java.text.ParseException;

public class UserGuessBox extends JPanel
{
    //private JTextField textBox;

    public UserGuessBox()
    {
        //JPanel mainPanel = new JPanel();
        JButton enterButton = new JButton("enter");
        MaskFormatter wordleGuess = null;
        JFormattedTextField wordleGuessBox = null;
        try {
            wordleGuess = new MaskFormatter("UUUUU");
            wordleGuess.setPlaceholderCharacter('X');
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        //textBox = new JTextField(5);
        //textBox.setPreferredSize( new Dimension( 5, 30 ) );
        wordleGuessBox = new JFormattedTextField(wordleGuess);
        wordleGuessBox.setPreferredSize( new Dimension( 5, 30 ) );
        wordleGuessBox.setVisible(true);
        //this.add(textBox);
        this.add(wordleGuessBox);
        this.add(enterButton);
        this.setPreferredSize(new Dimension(10, 30));
        this.setBackground(Color.BLACK);
    }

}