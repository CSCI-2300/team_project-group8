package wordlegame.view;

import wordlegame.GameObserver;
import wordlegame.controller.Controller;
import wordlegame.model.HiddenWord;
import wordlegame.view.StatsGUI;
import wordlegame.model.GameStatistics;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class WordleGuessingGameGUI implements GameObserver
{
    private JFrame mainFrame;
    private JPanel mainPanel;
    private Board gameBoard;
    private UserGuessBox userGuessBox;

    Controller controller;
    HiddenWord hiddenWord;
    GameStatistics gameStatistics;

    public WordleGuessingGameGUI(Controller controller, HiddenWord hiddenWord, GameStatistics gameStatistics)
    {
        this.controller = controller;
        this.hiddenWord = hiddenWord;
        this.gameStatistics = gameStatistics;
        hiddenWord.register(this);
        controller.loadStatistics();

        mainFrame = new JFrame("Wordle");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setBackground(Color.BLACK);
        mainPanel.setLayout(new BorderLayout(20, 5));  
        mainPanel.setPreferredSize(new Dimension(580,800));

        JLabel title = new JLabel("WORDLE", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 80));
        title.setForeground(Color.WHITE);

        gameBoard = new Board();
        mainPanel.add(gameBoard);
        userGuessBox = new UserGuessBox(controller);

        mainPanel.add(title, BorderLayout.NORTH);
        mainPanel.add(gameBoard, BorderLayout.CENTER);
        mainPanel.add(userGuessBox, BorderLayout.SOUTH);

        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainFrame.getContentPane().add(mainPanel);
  
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public void gameOver()
    {
        int chosenButton = 0;
        StatsGUI statsPage = new StatsGUI();
        Object[] options = { "Quit", "Reset Statistics" };
        statsPage.setPreferredSize(new Dimension(300, 215));

        if (hiddenWord.isWinner())
        {
            controller.incrementGamesPlayed();
            controller.incrementGamesWon();
            controller.uploadStatistics();
            statsPage.updateCurrentGameLabel("won", hiddenWord.getHiddenWord());
            statsPage.updateStats(gameStatistics.getGamesWon(), gameStatistics.getGamesPlayed(), gameStatistics.getWinPercentage());
            chosenButton = JOptionPane.showOptionDialog(mainFrame,
                        statsPage,
                        "Game Statistics", 
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null, 
                        options,
                        options[0]);
        }
        else
        {
            controller.incrementGamesPlayed();
            controller.uploadStatistics();
            statsPage.updateCurrentGameLabel("lost", hiddenWord.getHiddenWord());
            statsPage.updateStats(gameStatistics.getGamesWon(), gameStatistics.getGamesPlayed(), gameStatistics.getWinPercentage());
            chosenButton = JOptionPane.showOptionDialog(mainFrame,
                        statsPage,
                        "Game Statistics", 
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null, 
                        options,
                        options[0]);
        }

        if (chosenButton == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }

        else if (chosenButton == JOptionPane.NO_OPTION)
        {
            gameStatistics.resetStats();
            gameStatistics.uploadStatistics();
            System.exit(0);
        }

        else 
        {
            System.exit(0);
        }

    }

    public void update()
    {
        ArrayList<Character> letters = hiddenWord.getGuessedLetters();
        ArrayList<String> colors = hiddenWord.getColors();
        int guesses = hiddenWord.getGuesses();
        if (hiddenWord.getGuessStatus() && hiddenWord.getInCategory())
        {   
            gameBoard.displayWord(letters,colors,guesses);
            if (hiddenWord.isGameOver())
            {
                userGuessBox.setVisible(false);
                this.gameOver();
            }
        }  
        else if (!hiddenWord.getGuessStatus())
        {
            JOptionPane.showMessageDialog(mainFrame, "Please enter a 5 letter word", "Can't accept guess", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (!hiddenWord.getInCategory())
        {
            JOptionPane.showMessageDialog(mainFrame, "Please enter a valid 5 letter word from the category", "Can't accept guess", JOptionPane.INFORMATION_MESSAGE);
        }
        mainPanel.repaint();
    }
}