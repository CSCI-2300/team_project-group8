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
    boolean winner;

    public HiddenWord()
    {
    }

    public void setHiddenWord(String hiddenWord)
    {
        System.out.println(hiddenWord);
        this.hiddenWord = hiddenWord.toUpperCase();
        guesses = 0;
        this.createDictionary();
    }

    public String getHiddenWord() 
    {
        return this.hiddenWord;
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
        this.guesses += 1;
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

        this.notifyObservers();
        this.resetDictionary();
    }

    public void checkGreen()
    {
        for (int i = 0; i < this.guessedWord.length(); i++)
        {
            char guessedLetter = this.guessedWord.charAt(i);
            if (guessedLetter == this.hiddenWord.charAt(i))
            {
                this.colors.set(i, "GREEN");
                int occurrences = this.dictionary.get(guessedLetter);
                this.dictionary.put(guessedLetter, occurrences - 1);
            }
        }
    }   

    public void checkYellow()
    {
        for (int i = 0; i < this.guessedWord.length(); i++)
        {
            char guessedLetter = this.guessedWord.charAt(i);
            if (this.dictionary.keySet().contains(guessedLetter)) 
            {
                int occurrences = this.dictionary.get(guessedLetter);
                if (occurrences > 0 && this.colors.get(i) != "GREEN") 
                {
                    this.colors.set(i, "YELLOW");
                    this.dictionary.put(guessedLetter, occurrences - 1); //one occurance has been used
                } 
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
        if (this.colors.contains("GRAY") == false && this.colors.contains("YELLOW") == false)
        {
            this.winner = true;
            return true;
        }
        else if (this.guesses == 6)
        {
            this.winner = false;
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean isWinner()
    {
        return this.winner;
    }

    public int getGuesses()
    {
        return this.guesses;
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