package wordlegame.controller;

import wordlegame.model.HiddenWord;
import wordlegame.view.CategorySelectionGUI;
import wordlegame.view.WordleGuessingGameGUI;
import wordlegame.GameController;
import wordlegame.model.RandomWordGenerator;
import wordlegame.model.GameStatistics;


public class Controller implements GameController
{
    HiddenWord hiddenWord;
    CategorySelectionGUI homeScreen;
    WordleGuessingGameGUI board;
    String fileName;
    RandomWordGenerator generator;
    String randomWord;
    GameStatistics gameStatistics;

    public Controller()
    {
        this.hiddenWord = new HiddenWord(); 
        this.homeScreen = new CategorySelectionGUI(this);
        this.gameStatistics = new GameStatistics();
    }

    public void getCategory(String category)
    {
        switch(category)
        {
            case "Animals":
                this.fileName = "animals.txt";
                break;
            case "Countries":
                this.fileName = "countries.txt";
                break;
            case "Capital Cities":
                this.fileName = "cities.txt";
                break;
        }

        this.generator = new RandomWordGenerator(this.fileName);
        this.randomWord = generator.getRandomWord();

        hiddenWord.setHiddenWord(this.randomWord, this.fileName);

        this.board = new WordleGuessingGameGUI(this, hiddenWord, this.gameStatistics);
    }

    public void getUserGuess(String userGuess)
    {
        this.hiddenWord.checkGuess(userGuess);
    }

    public void incrementGamesPlayed()
    {
        gameStatistics.incrementGamesPlayed();
    }

    public void incrementGamesWon()
    {
        gameStatistics.incrementGamesWon();
    }

    public void loadStatistics()
    {
        gameStatistics.loadStatistics();
    }

    public void uploadStatistics()
    {
        gameStatistics.uploadStatistics();
    }
}