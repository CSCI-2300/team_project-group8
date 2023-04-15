package wordlegame.controller;

import wordlegame.model.HiddenWord;
import wordlegame.view.CategorySelectionGUI;
import wordlegame.view.WordleGuessingGameGUI;
import wordlegame.GameController;

public class Controller implements GameController
{
    HiddenWord hiddenWord;
    CategorySelectionGUI homeScreen;
    WordleGuessingGameGUI board;

    public Controller(HiddenWord hiddenWord)
    {
        this.hiddenWord = hiddenWord;
        this.homeScreen = new CategorySelectionGUI();
        this.board = new WordleGuessingGameGUI(this, hiddenWord);
    }

    public void getCategory(String category)
    {

    }
}