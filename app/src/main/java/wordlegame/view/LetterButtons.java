package wordlegame.view;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//public class LetterButtons extends JPanel implements ActionListener
public class LetterButtons extends JPanel 
{
   private int length;
   private Color color;
   Board gameBoard; 
   private JButton button;

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
      setBackground(Color.decode(color));
   }

   public void setText(String text) 
   {
        button.setText(text);
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


