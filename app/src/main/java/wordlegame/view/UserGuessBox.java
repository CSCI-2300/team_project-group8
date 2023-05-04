package wordlegame.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.*;
import java.text.ParseException;
import wordlegame.controller.Controller;

public class UserGuessBox extends JPanel implements ActionListener, KeyListener
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
        wordleGuessBox.addKeyListener(this);
        enterButton.addActionListener(this);
        this.add(wordleGuessBox);
        this.add(enterButton);
        this.setPreferredSize(new Dimension(10, 30));
        this.setBackground(Color.BLACK);
    }

    public void resetEntry()
    {
        String userGuess = wordleGuessBox.getText().trim();

        wordleGuessBox.setValue(null); 
        wordleGuessBox.requestFocus();
        wordleGuessBox.getCaret().setDot(0);

        this.passGuess(userGuess);
    }

    public void passGuess(String guess)
    {
        controller.getUserGuess(guess);
    }

    public void enableAll()
    {
        this.enterButton.setEnabled(true);
        this.wordleGuessBox.setEnabled(true);
    }

    public void disableAll()
    {
        this.enterButton.setEnabled(false);
        this.wordleGuessBox.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent event) 
    {
        resetEntry();
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        if (e.getKeyCode()==KeyEvent.VK_ENTER)
        {
            this.resetEntry();  
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {}

    @Override
    public void keyTyped(KeyEvent arg0) {}
}