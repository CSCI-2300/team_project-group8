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
    /*
     * public void update() 
     * {
     * 
     * }
     */

    public void gameOver() 
    {
        JOptionPane.showMessageDialog(mainFrame, "Game over! The word was " + hiddenWord.getHiddenWord() + ".", "Game over", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
    
     /* 
     public void update() {
        ArrayList<Character> guessedLetters = hiddenWord.getGuessedLetters();
        ArrayList<String> colors = hiddenWord.getColors();
    
        for (int i = 0; i < guessedLetters.size(); i++) {
            char letter = guessedLetters.get(i);
            String color = colors.get(i);
            gameBoard.getLetterButtons().get(i).setText(String.valueOf(letter));
            gameBoard.getLetterButtons().get(i).setColor(color);
        }
    
        if (hiddenWord.isGameOver()) {
            gameOver();
        }
    }
    */
    
     
     public void update() 
     {
        ArrayList<Character> letters = hiddenWord.getGuessedLetters();
        ArrayList<String> colors = hiddenWord.getColors();
    
        StringBuilder sb = new StringBuilder(); //i used string builder it basically just appends chars or strings to it and is mutable
        for (int i = 0; i < letters.size(); i++) 
        {
            char letter = letters.get(i);
            String color = colors.get(i);
            //i found this html thing online the first on sets the color and the html at the end closes the html formatting
            sb.append("<html><span style='color:" + color + "'>" + letter + "</span></html>");

        }
    
        JLabel hiddenWordLabel = new JLabel(sb.toString());
        hiddenWordLabel.setFont(new Font("Serif", Font.PLAIN, 40));
        hiddenWordLabel.setHorizontalAlignment(SwingConstants.CENTER);
    
        mainPanel.add(hiddenWordLabel, BorderLayout.SOUTH);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
    

    public void displayWord()
    {
        ArrayList<Character> letters = this.hiddenWord.getGuessedLetters();
        ArrayList<String> colors = this.hiddenWord.getColors();

        for (int i = 0; i < letters.size(); i++) {
            char letter = letters.get(i);
            String color = colors.get(i);
            System.out.print(color + letter + "\u001B[0m ");
        }
    
        System.out.println();
    }

    //modified
    //public void update() {
        //ArrayList<Character> guessedLetters = hiddenWord.getGuessedLetters();
        //ArrayList<String> colors = hiddenWord.getColors();
    
        //for (int i = 0; i < guessedLetters.size(); i++) {
           // Character letter = guessedLetters.get(i);
            //String color = colors.get(i);
    
          // for (LetterButtons button : gameBoard.getButtons()) {
                //if (button.getText().charAt(0) == letter) {
                //   button.setColor(color);
                   // button.setText(letter.toString());
             //   }
           // }
      //  }
    
       // if (hiddenWord.isGameOver()) {
          //  gameOver();
       // }
   // }
    
}