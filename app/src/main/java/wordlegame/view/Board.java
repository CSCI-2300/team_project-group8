package wordlegame.view;

import java.awt.*;
import javax.swing.*;

public class Board extends JPanel
{
    //JFrame mainFrame;
    private JPanel mainPanel;

    public Board() 
    {
        //mainFrame = new JFrame();
        mainPanel = new JPanel();

        mainPanel.setPreferredSize(new Dimension(500,500));
        mainPanel.setBackground(Color.BLACK);

        mainPanel.setLayout(new GridLayout(6, 5, 10, 10));

        //mainFrame.add(mainPanel);

        //mainFrame.pack();
        //mainFrame.setVisible(true);

        for (int i = 0; i < 30; i ++)
        {
            LetterButtons letterButton = new LetterButtons(50);
            mainPanel.add(letterButton);
            //JPanel secondPanel = new JPanel();
            //secondPanel.setBackground(Color.GRAY);
            //mainPanel.add(secondPanel);
            //secondPanel.setPreferredSize(new Dimension(50,50));
            //LetterButtons square = new LetterButtons(50,50);
            //Graphics graphics = secondPanel.getGraphics();
            //square.paintIcon(this, graphics, 25, 25);
        }
    }

    /*public static void main(String[] args)
    {
        Board board = new Board();
    }*/
}