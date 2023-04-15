package wordlegame.model;

import java.util.ArrayList;
import java.util.HashMap;

import wordlegame.GameObserver;

public class HiddenWord
{
    ArrayList<GameObserver> observers = new ArrayList<GameObserver>();

    String hiddenWord;
    String guessedWord;
    HashMap<Character, Integer> dictionary;
    ArrayList<Character> guessedLetters;
    ArrayList<String> colors;
    int guesses;

    public HiddenWord()
    {

    }

    public void setHiddenWord(String hiddenWord)
    {
        this.hiddenWord = hiddenWord.toUpperCase();
        this.guesses = 6;
        this.createDictionary();
    }

    public void createDictionary()
    {
        this.dictionary = new HashMap<Character, Integer>();

        for (int i = 0; i < hiddenWord.length(); i++)
        {
            if (dictionary.keySet().contains(hiddenWord.charAt(i)) == false)
            {
                dictionary.put(hiddenWord.charAt(i), getOccurances(hiddenWord.charAt(i)));
            }
        }
    }

    public int getOccurances(char letter)
    {
        int occurances = 0;
        for (int i = 0; i < hiddenWord.length(); i++)
        {
            if (hiddenWord.charAt(i) == (letter))
            {
                occurances++;
            }
        }
        return occurances;
    }

    public void checkGuess(String guessedWord)
    {
        this.guessedWord = guessedWord.toUpperCase();
        this.guessedLetters = new ArrayList<Character>();
        this.colors = new ArrayList<String>();

        for (int i = 0; i < this.guessedWord.length(); i++)
        {
            this.guessedLetters.add(this.guessedWord.charAt(i));
            this.colors.add("GRAY");
        }

        this.checkGreen();
        this.checkYellow();

        this.guesses--;

        this.resetDictionary();
    }

    public void checkGreen()
    {
        for (int i = 0; i < this.guessedWord.length(); i++)
        {
            if (this.guessedWord.charAt(i) == this.hiddenWord.charAt(i))
            {
                this.colors.set(i, "GREEN");
            }
        }
    }

    public void checkYellow()
    {
        for (int i = 0; i < this.guessedWord.length(); i++)
        {
            if (this.dictionary.keySet().contains(this.guessedWord.charAt(i)) && this.colors.get(i) == "GRAY" && this.dictionary.get(this.guessedWord.charAt(i)) != 0)
            {
                this.colors.set(i, "YELLOW");
                this.dictionary.replace(this.hiddenWord.charAt(i), this.dictionary.get(this.hiddenWord.charAt(i))-1);
            }
        }
    }

    public void resetDictionary()
    {
        this.createDictionary();
    }

    public ArrayList<Character> getGuessedLetters()
    {
        return this.guessedLetters;
    }

    public ArrayList<String> getColors()
    {
        return this.colors;
    }

    public boolean isGameOver()
    {
        if (this.colors.contains("GRAY") == false || this.colors.contains("YELLOW") == false)
        {
            return true;
        }
        else if (this.guesses == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void register(GameObserver observer)
    {
        observers.add(observer);
    }

    public void unregister(GameObserver observer)
    {
        observers.remove(observer);
    }

    public void notifyObservers()
    {
        for (int i = 0; i < observers.size(); i ++)
        {
            observers.get(i).update();
        }
    }
}