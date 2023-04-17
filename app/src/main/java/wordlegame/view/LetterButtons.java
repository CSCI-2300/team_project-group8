package wordlegame.view;

import javax.swing.*;
import java.awt.*;


public class LetterButtons extends JPanel 
{
   private int length;
   private Color color;
   Board gameBoard; 
   GridBagConstraints gbc;

   public LetterButtons(int length, Board gameboard)   
   {
      this.length = length;
      setPreferredSize(new Dimension(this.length, this.length));
      color = Color.GRAY; 
      setBackground(color);
      setLayout(new GridBagLayout());
      gbc = new GridBagConstraints();
    }

   public void setColor(Color c)
   {
      this.color = c;
   }

   public Color getColor()
   {
      return color; 
   }

   public void setColor(String color) 
   {
      if (color.equals("GRAY"))
      {
         this.setBackground(Color.GRAY);
      }
      else if (color.equals("YELLOW"))
      {
         this.setBackground(Color.YELLOW);
      }
      else
      {
         this.setBackground(Color.GREEN);
      }
      this.repaint();
   }

   public void setText(String text) 
   {
        JLabel charLab = new JLabel(text);
        charLab.setFont(new Font("Serif", Font.PLAIN, 40));
        charLab.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(charLab, gbc);
        this.revalidate();
        this.repaint();
   }
}


