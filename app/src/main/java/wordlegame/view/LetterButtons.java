
package wordlegame.view;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;


public class LetterButtons extends JPanel
{
   private int length;
   private Color color;
   public LetterButtons(int length)
   {
      this.length = length;
      setPreferredSize(new Dimension(this.length, this.length));
      color = Color.GRAY; 
      setBackground(color);
    }

   public void setColor(Color c)
   {
      this.color = c;
   }
}

