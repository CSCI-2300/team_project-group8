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
        if (hiddenWord.isWinner())
        {
            controller.incrementGamesPlayed();
            controller.incrementGamesWon();
            //StatsGUI statsGUI = new StatsGUI();
            //statsGUI.setVisible(true);
            JOptionPane.showMessageDialog(mainFrame, "You Win! The word was " + hiddenWord.getHiddenWord() + ".\n" + "Games Played: " + 
            this.gameStatistics.getGamesPlayed() + "\n"+ "Games Won: " + this.gameStatistics.getGamesWon() + "\n"+ "Win Rate: " + this.gameStatistics.getWinPercentage() + "\n",
             "Game over", JOptionPane.INFORMATION_MESSAGE);
        //if you dont want to use the file, i can incorporate these methods into the code
        //double percentage = (double) controller.getGamesWon() / controller.getTotalGames() * 100.0;
        //statsGUI.updateStats(controller.getGamesWon(), controller.getTotalGames(), percentage);

            //hiddenWord.incrementGamesWon();   // Increment games won

    }
        else
        {
            controller.incrementGamesPlayed();
            //StatsGUI statsGUI = new StatsGUI();
            //statsGUI.setVisible(true);
            JOptionPane.showMessageDialog(mainFrame, "You Win! The word was " + hiddenWord.getHiddenWord() + ".\n" + "Games Played: " + 
            this.gameStatistics.getGamesPlayed() + "\n"+ "Games Won: " + this.gameStatistics.getGamesWon() + "\n"+ "Win Rate: " + this.gameStatistics.getWinPercentage() + "\n",
            "Game over", JOptionPane.INFORMATION_MESSAGE);
         //if you dont want to use the file, i can incorporate these methods into the code
        //double percentage = (double) controller.getGamesWon() / controller.getTotalGames() * 100.0;
        //statsGUI.updateStats(controller.getGamesWon(), controller.getTotalGames(), percentage);
        }
        System.exit(0);
    }

    
    public void update()
    {
        ArrayList<Character> letters = hiddenWord.getGuessedLetters();
        ArrayList<String> colors = hiddenWord.getColors();
        int guesses = hiddenWord.getGuesses();
        if (hiddenWord.getGuessStatus())
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
        mainPanel.repaint();
    }
}