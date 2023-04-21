package wordlegame.view;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class StatsGUI extends JFrame 
{
    private JLabel gamesWonLabel; 
    private JLabel totalGamesLabel;
    private JLabel percentageLabel;

    public StatsGUI()
    {
        super("Game Statistics"); 
        setPreferredSize(new Dimension(300,120));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        gamesWonLabel = new JLabel("Number of Wins: 0");
        gamesWonLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        gamesWonLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        mainPanel.add(gamesWonLabel);

        totalGamesLabel = new JLabel("Total Games Played: 0");
        totalGamesLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        totalGamesLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        mainPanel.add(totalGamesLabel);

        percentageLabel = new JLabel("Percentage of Wins: 0");
        percentageLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        percentageLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        mainPanel.add(percentageLabel);

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
        gamesWonLabel.setText("Number of Wins: " + gamesWon);
    }

    public void updateTotalGames(int totalGames)
    {
        totalGamesLabel.setText("Total Games Played: " + totalGames);
    }

    public void updatePercentage(double percentage)
    {
        percentageLabel.setText("Percentage of Wins: " + String.format("%.2f", percentage) + "%"); //the .2f is for 2 decimal points btw
    }

    public void updateStats(int gamesWon, int totalGames, double percentage)
    {
        updateGamesWon(gamesWon);
        updateTotalGames(totalGames);
        updatePercentage(percentage);
    }

}
