package wordlegame.view;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class StatsGUI extends JFrame 
{
    private JLabel gamesWonLabel; 
    private JLabel totalGamesLabel;
    private JLabel percentageLabel;
    private int gamesWon = 0;
    private int totalGamesPlayed = 0;

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
        percentageLabel.setText("Percentage of Wins: " + String.format("%.2f", percentage) + "%"); 
    }

    public void updateStats(int gamesWon, int totalGames, double percentage)
    {
        updateGamesWon(gamesWon);
        updateTotalGames(totalGames);
        updatePercentage(percentage);
    }

    public int getGamesWon() 
    {
        return gamesWon;
    }
    
    public int getTotalGamesPlayed() 
    {
        return totalGamesPlayed;
    }
}
