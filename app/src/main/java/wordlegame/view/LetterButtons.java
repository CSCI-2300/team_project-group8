package wordlegame.view;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//public class LetterButtons extends JPanel implements ActionListener
public class LetterButtons extends JPanel 
{
   private int length;
   private Color color;
   Board gameBoard; 
   private JButton button;
   GridBagConstraints gbc;

    //new
   //private char letter; 
   //new
   //private String text; 

   //aded char letter to constructor
   public LetterButtons(int length, Board gameboard)   
   {
      this.length = length;
      //this.gameBoard = gameBoard;
      setPreferredSize(new Dimension(this.length, this.length));
      color = Color.GRAY; 
      setBackground(color);
      setLayout(new GridBagLayout());
      gbc = new GridBagConstraints();
      //this.setLayout(new BorderLayout());
    
      // create and add the button to the panel
      /* 
      button = new JButton();
      button.setPreferredSize(new Dimension(length, length));
      button.addActionListener(this);
      add(button);
      */
    }

   public void setColor(Color c)
   {
      this.color = c;
   }

   //new
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
      //this.setBackground(Color.decode(color));
      this.repaint();
   }

   public void setText(String text) 
   {
        JLabel charLab = new JLabel(text);
        charLab.setFont(new Font("Serif", Font.PLAIN, 40));
        charLab.setForeground(Color.WHITE);
        //this.add(charLab, BorderLayout.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(charLab, gbc);
        this.revalidate();
        this.repaint();
   }

   /* 
   public void addActionListener(ActionListener listener)
   {
        button.addActionListener(listener);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      JButton source = (JButton)e.getSource();
      System.out.println(source.getText());
   }
   */

   //public void setLetter()
   //{
   //     this.letter = letter;
  // }

   //public char getLetter()
   //{
    //    return letter; 
   //}
   

   //public String getText()
   //{
      //return text; 
   //}
}


