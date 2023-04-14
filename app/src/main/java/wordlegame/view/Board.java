package wordlegame.view;

import java.awt.*;
import javax.swing.*;

public class Board extends JPanel
{
    JFrame mainFrame;
    private JPanel mainPanel;

    public Board() 
    {
        //mainFrame = new JFrame();

        //mainPanel = new JPanel();

        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.BLACK);

        this.setLayout(new GridLayout(6, 5, 10, 10));

        for (int i = 0; i < 30; i ++)
        {
            LetterButtons letterButton = new LetterButtons(100);
            this.add(letterButton);
            
        }

        
    }

    
}