package wordlegame.view;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel
{
    JFrame mainFrame;
    private JPanel mainPanel;
    ArrayList<LetterButtons> letterButtons;
    int attempts;

    public Board() 
    {
        attempts = 0;
        letterButtons = new ArrayList<LetterButtons>();

        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.BLACK);

        this.setLayout(new GridLayout(6, 5, 10, 10));
        for (int i = 0; i < 30; i ++)
        {
            LetterButtons letterButton = new LetterButtons(100, this);
            this.add(letterButton);
            this.letterButtons.add(letterButton); 
            
        }
       
    }

   public void passColorInfo(ArrayList<String> colors)
   {
    for (int i=0; i<colors.size(); i++)
        {
            if (colors.get(i).equals("YELLOW"))
            {
                letterButtons.get(i).setColor(Color.YELLOW);
            }
            else if (colors.get(i).equals("GREEN"))
            {
                letterButtons.get(i).setColor(Color.GREEN);
            }
            else
            {
                letterButtons.get(i).setColor(Color.GRAY);
            }
        }
        this.repaint();
   }

   public ArrayList<LetterButtons> getLetterButtons() 
   {
        return letterButtons;
   }

   public void displayWord(ArrayList<Character> letters, ArrayList<String> colors)
   {
        for (int i = 0; i < letters.size(); i++) 
        {
            char letter = letters.get(i);
            String color = colors.get(i);
            String stringLetter =String.valueOf(letter);
            letterButtons.get(i+5*attempts).setText(stringLetter);
            letterButtons.get(i+5*attempts).setColor(color);
        }

        attempts += 1;
        this.repaint();
   }
}