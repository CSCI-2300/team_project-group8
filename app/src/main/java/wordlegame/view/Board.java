package wordlegame.view;

import java.awt.*;
import javax.swing.*;

public class Board extends JPanel
{
    JFrame mainFrame;
    JPanel mainPanel;

    public Board() 
    {
        mainFrame = new JFrame();
        mainPanel = new JPanel();

        mainPanel.setLayout(new GridLayout(6, 5, 20, 20));

        for (int i = 0; i < 30; i ++)
        {
            LetterButtons square = new LetterButtons(100,100);
            mainPanel.add(square);
        }

        mainFrame.add(mainPanel);

        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public static void main(String[] args)
    {
        Board board = new Board();
    }
}