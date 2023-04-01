package wordlegame.view;

import java.awt.*;
import javax.swing.*;

public class LetterButtons implements Icon
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
        
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainFrame.add(mainPanel); 

        imageLabel = new JLabel(this);
        mainPanel.add(imageLabel);

        mainFrame.pack();
        mainFrame.setVisible(true);
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

}