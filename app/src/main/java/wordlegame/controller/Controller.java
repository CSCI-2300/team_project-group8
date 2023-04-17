package wordlegame.controller;

import wordlegame.model.HiddenWord;
import wordlegame.view.CategorySelectionGUI;
import wordlegame.view.WordleGuessingGameGUI;
import wordlegame.GameController;
import wordlegame.model.RandomWordGenerator;

public class Controller implements GameController
{
    HiddenWord hiddenWord;
    CategorySelectionGUI homeScreen;
    WordleGuessingGameGUI board;
    String fileName;
    RandomWordGenerator generator;
    String randomWord;

    public Controller(HiddenWord hiddenWord)
    {
        this.hiddenWord = hiddenWord;
        this.homeScreen = new CategorySelectionGUI(this);
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
            case "Cities":
                this.fileName = "cities.txt";
                break;
        }

        this.generator = new RandomWordGenerator(this.fileName);
        this.randomWord = generator.getRandomWord();

        hiddenWord.setHiddenWord(this.randomWord);

        this.board = new WordleGuessingGameGUI(this, hiddenWord);
    }

    public void getUserGuess(String userGuess)
    {
        this.hiddenWord.checkGuess(userGuess);
    }

    
}