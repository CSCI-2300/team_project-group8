package wordlegame.model;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.Random;
import java.io.IOException;

public class RandomWordGenerator
{
    String fileName;
    ArrayList<String> wordList;

    public RandomWordGenerator(String fileName)
    {
        this.fileName = fileName;
    }

    public void readFile() throws IOException
    {
        this.wordList = new ArrayList<String>();

        Scanner scanner = new Scanner(new File(this.fileName));
        while (scanner.hasNextLine())
        {
            String newWord = scanner.nextLine();
            this.wordList.add(newWord);
        }
    }

    public String getRandomWord()
    {
        try 
        {
            this.readFile();
        }
        catch (IOException error)
        {
            System.out.println(error.getMessage());
        }

        Random randomizer = new Random();
        return wordList.get(randomizer.nextInt(this.wordList.size()));
    }
}