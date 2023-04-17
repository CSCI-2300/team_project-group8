package wordlegame.view;

import wordlegame.GameObserver;

import wordlegame.controller.Controller;
import wordlegame.model.HiddenWord;

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

    public WordleGuessingGameGUI(Controller controller, HiddenWord hiddenWord)
    {
        this.controller = controller;
        this.hiddenWord = hiddenWord;
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
        JOptionPane.showMessageDialog(mainFrame, "Game over! The word was " + hiddenWord.getHiddenWord() + ".", "Game over", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
    
    public void update()
    {
        ArrayList<Character> letters = hiddenWord.getGuessedLetters();
        ArrayList<String> colors = hiddenWord.getColors();
        int guesses = hiddenWord.getGuesses();
        gameBoard.displayWord(letters,colors,guesses);
        if (hiddenWord.isGameOver())
        {
            userGuessBox.setVisible(false);
            this.gameOver();
        }
        mainPanel.repaint();
    }  
}