package wordlegame.view;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class StatsGUI extends JFrame 
{
    private JLabel gamesWonLabel; 

    public StatsGUI()
    {
        super("Game Statistics"); 
        setPreferredSize(new Dimension(300,150));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        gamesWonLabel = new JLabel("Number of Wins: 0");
        gamesWonLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        gamesWonLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        mainPanel.add(gamesWonLabel);

        gamesWonLabel = new JLabel("Total Games Played: 0");
        gamesWonLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        gamesWonLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        mainPanel.add(gamesWonLabel);

        gamesWonLabel = new JLabel("Percentage of Wins: 0");
        gamesWonLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        gamesWonLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        mainPanel.add(gamesWonLabel);

        /* 
        //should we add this?
        JButton resetButton = new JButton("Reset Stats");
        resetButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(resetButton);
        */

        add(mainPanel);
        pack();
        setVisible(true);

    }

    public void updateGamesWon(int gamesWon)
    {
        gamesWonLabel.setText("Games Won: " + gamesWon);
    }

}
