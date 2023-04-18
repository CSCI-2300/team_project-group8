package wordlegame.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

import wordlegame.controller.Controller;

import java.awt.event.*;
import java.text.ParseException;

public class UserGuessBox extends JPanel implements ActionListener
{
    JFormattedTextField wordleGuessBox = null;
    JButton enterButton;
    Controller controller;

    public UserGuessBox(Controller controller)
    {
        this.controller = controller;
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        enterButton = new JButton("enter");
        MaskFormatter wordleGuess = null;
        try 
        {
            wordleGuess = new MaskFormatter("UUUUU");
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        wordleGuessBox = new JFormattedTextField(wordleGuess);
        wordleGuessBox.setPreferredSize( new Dimension( 5, 30 ) );
        wordleGuessBox.setVisible(true);
        enterButton.addActionListener(this);
        this.add(wordleGuessBox);
        this.add(enterButton);
        this.setPreferredSize(new Dimension(10, 30));
        this.setBackground(Color.BLACK);
    }
/* 
    @Override
    public void actionPerformed(ActionEvent event) {
        String userGuess;
        userGuess = this.wordleGuessBox.getText();
        this.controller.getUserGuess(userGuess);
        System.out.println(userGuess);

        wordleGuessBox.setText("");
        wordleGuessBox.requestFocus();
        wordleGuessBox.getCaret().setDot(0);
    }
    */

    
    @Override
    public void actionPerformed(ActionEvent event) 
    {
        String userGuess = wordleGuessBox.getText().trim();
        if (userGuess.isEmpty()) 
        {
            return;
        }

        controller.getUserGuess(userGuess);
        System.out.println(userGuess);
        
        wordleGuessBox.setValue(null); 
        wordleGuessBox.requestFocus();
        wordleGuessBox.getCaret().setDot(0);
}

}