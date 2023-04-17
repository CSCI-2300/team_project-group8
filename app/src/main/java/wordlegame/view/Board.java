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
    //new
    ArrayList<LetterButtons> letterButtons;

    public Board() 
    {
        //new
        letterButtons = new ArrayList<LetterButtons>();

        //mainFrame = new JFrame();
        //mainPanel = new JPanel();

        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.BLACK);

        this.setLayout(new GridLayout(6, 5, 10, 10));
        for (int i = 0; i < 30; i ++)
        {
            //need to modify here but cant due to constructor 
            LetterButtons letterButton = new LetterButtons(100, this);
            this.add(letterButton);
            
        }
        

        /* 
        for (int i = 0; i < 30; i ++)
        {
            LetterButtons letterButton = new LetterButtons(100, this);
            letterButtons.add(letterButton);
            this.add(letterButton);
            letterButton.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e)
                {
                    JButton source = (JButton)e.getSource();
                    System.out.println(source.getText());
                }
            });
        }
        */
       
        
    }

    /* 
    public void setLetter(int index, char letter, String color) 
    {
       LetterButtons button = (LetterButtons) buttonsPanel.getComponent(index);
       button.setLetter(letter);
       button.setColor(color);
    }
   */   

   //new
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


    
}