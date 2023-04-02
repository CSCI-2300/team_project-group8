package wordlegame.view;

import java.awt.*;
import javax.swing.*;

public class WordleGuessingGameGUI
{
    private JFrame mainFrame;
    private JPanel mainPanel;
    private Board gameBoard;
    private UserGuessBox userGuessBox;

    public WordleGuessingGameGUI()
    {
        mainFrame = new JFrame("Wordle");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setBackground(Color.BLACK);
        //mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setLayout(new BorderLayout(20, 5));  
        mainPanel.setPreferredSize(new Dimension(500,700));


        JLabel title = new JLabel("WORDLE");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 80));
        title.setForeground(Color.WHITE);

        gameBoard = new Board();
        mainPanel.add(gameBoard);
        userGuessBox = new UserGuessBox();

        mainPanel.add(title, BorderLayout.NORTH);
        mainPanel.add(gameBoard, BorderLayout.CENTER);
        mainPanel.add(userGuessBox, BorderLayout.SOUTH);

        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainFrame.add(mainPanel);
  
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}