package wordlegame.view;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener
{
    JFrame mainFrame;
    ArrayList<LetterButtons> letterButtons;
    Timer timer;
    ArrayList<Character> letters;
    ArrayList<String> colors;
    int attempts;
    int count;
    UserGuessBox userGuessBox;

    public Board(UserGuessBox userGuessBox) 
    {
        this.userGuessBox = userGuessBox;
        letterButtons = new ArrayList<LetterButtons>();
        count = 0;

        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.BLACK);

        this.setLayout(new GridLayout(6, 5, 10, 10));
        for (int i = 0; i < 30; i ++)
        {
            LetterButtons letterButton = new LetterButtons(100, this);
            this.add(letterButton);
            this.letterButtons.add(letterButton); 
            
        }

    timer = new Timer(200,this);
    }

   public void displayWord(ArrayList<Character> letters, ArrayList<String> colors, int attempts)
   {
        this.letters = letters;
        this.colors = colors;
        this.attempts = attempts;
        count = 0; 
        timer.start();
        userGuessBox.disableAll();
        this.repaint();
   } 

   public void actionPerformed(ActionEvent e)
   {
        char letter = letters.get(count);
        String color = colors.get(count);
        String stringLetter =String.valueOf(letter);
        letterButtons.get(count+5*(attempts-1)).setText(stringLetter);
        letterButtons.get(count+5*(attempts-1)).setColor(color);
        count++;
        if (count == 5)
        {
            timer.stop();
            userGuessBox.enableAll();
        }
   }
}