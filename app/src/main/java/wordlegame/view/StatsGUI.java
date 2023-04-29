package wordlegame.view;

import javax.swing.*;
import java.awt.*;

public class StatsGUI extends JPanel
{
    private JLabel gamesWonLabel; 
    private JLabel totalGamesLabel;
    private JLabel percentageLabel;
    private JLabel currentGameLabel;

    public StatsGUI()
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        currentGameLabel = new JLabel("You won!");
        currentGameLabel.setFont(new Font("Serif", Font.BOLD, 25));
        this.add(currentGameLabel);

        this.add(Box.createRigidArea(new Dimension(0,25)));

        gamesWonLabel = new JLabel("Number of Wins: 0");
        gamesWonLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        gamesWonLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        this.add(gamesWonLabel);

        this.add(Box.createRigidArea(new Dimension(0,15)));

        totalGamesLabel = new JLabel("Total Games Played: 0");
        totalGamesLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        totalGamesLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        this.add(totalGamesLabel);

        this.add(Box.createRigidArea(new Dimension(0,15)));

        percentageLabel = new JLabel("Percentage of Wins: 0");
        percentageLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        percentageLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        this.add(percentageLabel);

        this.add(Box.createRigidArea(new Dimension(0,15)));

        setVisible(true);
        setOpaque(true);
    }

    public void updateCurrentGameLabel(String status, String hiddenWord)
    {
        String message = "";
        switch(status)
        {
            case "won":
                this.setBackground(new Color(88, 137, 93));
                message = String.format("<html><center>You win! The hidden word was <font color='white'><b>%s</b></font>. </center></html>", hiddenWord);
                currentGameLabel.setText(message);
                break;
            case "lost":
                this.setBackground(new Color(160, 40, 48));
                message = String.format("<html><center>You lose! The hidden word was <font color='white'><b>%s</b></font>. </center></html>", hiddenWord);
                currentGameLabel.setText(message);
                break;
        }
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
}
