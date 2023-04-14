package wordlegame;

import wordlegame.model.HiddenWord;
import wordlegame.view.CategorySelectionGUI;
import wordlegame.view.WordleGuessingGameGUI;

public class Controller
{
    HiddenWord hiddenWord;
    CategorySelectionGUI homeScreen;
    WordleGuessingGameGUI board;

    public Controller(HiddenWord hiddenWord)
    {
        this.hiddenWord = hiddenWord;
        this.homeScreen = new CategorySelectionGUI();
        this.board = new WordleGuessingGameGUI();
    }
}