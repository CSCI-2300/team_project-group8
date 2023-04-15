package wordlegame.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

import java.awt.event.*;
import java.text.ParseException;

public class UserGuessBox extends JPanel
{

    public UserGuessBox()
    {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        JButton enterButton = new JButton("enter");
        MaskFormatter wordleGuess = null;
        JFormattedTextField wordleGuessBox = null;
        try {
            wordleGuess = new MaskFormatter("UUUUU");
            //wordleGuess.setPlaceholderCharacter('X');
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        wordleGuessBox = new JFormattedTextField(wordleGuess);
        wordleGuessBox.setPreferredSize( new Dimension( 5, 30 ) );
        wordleGuessBox.setVisible(true);
        this.add(wordleGuessBox);
        this.add(enterButton);
        this.setPreferredSize(new Dimension(10, 30));
        this.setBackground(Color.BLACK);
    }

}