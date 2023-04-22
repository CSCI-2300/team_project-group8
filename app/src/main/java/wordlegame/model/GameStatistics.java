package wordlegame.model;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class GameStatistics
{
    int gamesPlayed;
    int gamesWon;
    File statsFile;

    public GameStatistics()
    {
        this.gamesPlayed = 0;
        this.gamesPlayed = 0;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void incrementGamesWon()
    {
        this.gamesWon++;
    }

    public int getGamesPlayed()
    {
        return gamesPlayed;
    }

    public void incrementGamesPlayed()
    {
        gamesPlayed++;
    } 

    public float getWinPercentage()
    {
        return gamesWon/gamesPlayed;
    }

    public void loadStatistics()
    {
        this.statsFile = new File("statistics.txt");

        try
        {
            Scanner scanner = new Scanner(this.statsFile);
            int lineNumber = 0;
            while (scanner.hasNextLine())
            {
                if (lineNumber == 0)
                {
                    this.gamesPlayed = Integer.parseInt(scanner.nextLine());
                }
                else 
                {
                    this.gamesWon = Integer.parseInt(scanner.nextLine());
                }
                lineNumber++;
            }
        }
        catch (FileNotFoundException error)
        {
            System.out.println("Could not find file.");
        }
    }

    public void uploadStatistics()
    {

    }
}