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
    int attempts;

    public Board() 
    {
        //new
        attempts = 0;
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
            this.letterButtons.add(letterButton); //added this
            
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

   public void displayWord(ArrayList<Character> letters, ArrayList<String> colors)
   {

    //StringBuilder sb = new StringBuilder(); //i used string builder it basically just appends chars or strings to it and is mutable
        for (int i = 0; i < letters.size(); i++) 
        {
            char letter = letters.get(i);
            String color = colors.get(i);
            String stringLetter =String.valueOf(letter);
            letterButtons.get(i+5*attempts).setText(stringLetter);
            letterButtons.get(i+5*attempts).setColor(color);
            //i found this html thing online the first on sets the color and the html at the end closes the html formatting
            //sb.append("<html><span style='color:" + color + "'>" + letter + "</span></html>");

        }
        attempts += 1;
    
        //JLabel hiddenWordLabel = new JLabel(sb.toString());
        //hiddenWordLabel.setFont(new Font("Serif", Font.PLAIN, 40));
        //hiddenWordLabel.setHorizontalAlignment(SwingConstants.CENTER);
    
        //mainPanel.add(hiddenWordLabel, BorderLayout.SOUTH);
        //mainPanel.revalidate();
        this.repaint();

   }


    
}