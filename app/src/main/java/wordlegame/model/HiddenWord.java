package wordlegame.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import wordlegame.GameObserver;

public class HiddenWord
{
    ArrayList<GameObserver> observers = new ArrayList<GameObserver>();

    String hiddenWord;
    String fileName;
    String guessedWord;
    HashMap<Character, Integer> dictionary;
    ArrayList<Character> guessedLetters;
    ArrayList<String> colors;
    boolean valid = false;
    boolean inCategory = false;
    int guesses;
    boolean winner;

    private int gamesWon; 

    public HiddenWord()
    {
        this.gamesWon = 0; 
    }

    public void setHiddenWord(String hiddenWord, String fileName)
    {
        this.hiddenWord = hiddenWord.toUpperCase();
        this.fileName = fileName;
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
        this.valid = false;
        this.inCategory = false;
        this.validateGuess(guessedWord);
        if (!valid)
        {
            this.notifyObservers();
            return;
        }
        this.inCategory(guessedWord);
        if (!inCategory)
        {
            this.notifyObservers();
            return;
        }
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
                    this.dictionary.put(guessedLetter, occurrences - 1); 
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

    public void validateGuess(String userGuess)
    {
        if (userGuess.length() != 5)
        {
            this.valid = false;
        }
        else
        {
            this.valid = true;
        }
    }

    public boolean getGuessStatus()
    {
        return this.valid;
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

    public int getGamesWon() {
        return gamesWon;
    }

    public void inCategory(String guessedWord)
    {
        try 
        {
            Scanner scanner = new Scanner(new File(this.fileName));
            while (scanner.hasNextLine())
            {
                String newWord = scanner.nextLine().toUpperCase();
                if (newWord.equals(guessedWord.toUpperCase()))
                {
                    inCategory = true;
                }
            }
        }
        catch (FileNotFoundException error)
        {
            System.out.println("File could not be read");
        }
    }

    public boolean getInCategory()
    {
        return this.inCategory;
    }
}