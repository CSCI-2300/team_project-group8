/*package wordlegame.view;

import java.awt.*;
import javax.swing.*;

public class LetterButtons extends JButton implements Icon
{
    JFrame mainFrame;
    JPanel mainPanel;
    JLabel imageLabel;
    int height; 
    int width; 

    public LetterButtons(int width, int height)
    {
        this.width = width; 
        this.height = height; 

        mainPanel = new JPanel();
        imageLabel = new JLabel(this);
        mainPanel.add(imageLabel);
    }

    @Override
   public int getIconHeight()
   {
      return this.height;
   }

   @Override
   public int getIconWidth()
   {
      return this.width;
   }

   @Override
    public void paintIcon(Component component, Graphics graphics, int x, int y)
    {
        //inside of box: gray
        graphics.setColor(Color.GRAY);
        graphics.fillRect(x, y, width, height);

        //border of box: black 
        graphics.setColor(Color.BLACK);
        graphics.drawRect(x, y, width - 1, height - 1); 
    }

}*/
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
      //setPreferredSize(new Dimension(this.length, this.length));
      color = Color.GRAY; 
    }

   public void setColor(Color c)
   {
      this.color = c;
   }
}

/*
public class LetterButtons extends JPanel
{
   JPanel letterPanel;
   private int length;
   public LetterButtons(int length)
   {
      letterPanel = new JPanel();
      this.length = length;
      letterPanel.setPreferredSize(new Dimension(this.length, this.length));
      letterPanel.setBackground(Color.GRAY);
    }*/ 
/*   package wordlegame.view;

    import javax.swing.*;
    import java.awt.Color;
    import java.awt.Dimension;
    import java.awt.Graphics;
    
    
    public class LetterButtons extends JButton
    {
       private int length;
       private Color color;
       public LetterButtons(int length)
       {
          this.length = length;
          //setPreferredSize(new Dimension(this.length, this.length));
          this.setPreferredSize(new Dimension(this.length,this.length));
          color = Color.GRAY; 
          this.setForeground(color);
        }
    
       public void setColor(Color c)
       {
          this.color = c;
       }
    } */