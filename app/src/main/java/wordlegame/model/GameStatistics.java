package wordlegame.model;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter; 
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

    public double getWinPercentage()
    {
        double winRate = (gamesWon*1.00/gamesPlayed)*100;
        return winRate;
    }

    public void loadStatistics()
    {
        try
        {
            this.statsFile = new File("statistics.txt");
            if (this.statsFile.createNewFile())
            {
                if (this.statsFile.length() == 0)
                {
                    FileWriter myWriter = new FileWriter(this.statsFile);
                    myWriter.write("0\n");
                    myWriter.write("0");
                    myWriter.close();
                }
            }
        }
        catch (IOException error)
        {
            System.out.println("Could not write to file.");
        }

        try
        {
            Scanner scanner = new Scanner(this.statsFile);
            int lineNumber = 0;
            while (scanner.hasNextLine())
            {
                if (lineNumber == 0)
                {
                    this.gamesPlayed = Integer.parseInt(scanner.nextLine());
                    System.out.println(this.gamesPlayed);
                }
                else 
                {
                    this.gamesWon = Integer.parseInt(scanner.nextLine());
                    System.out.println(this.gamesWon);
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
        try
        {
            FileWriter myWriter = new FileWriter(this.statsFile, false);
            myWriter.write(String.valueOf(this.gamesPlayed) + "\n");
            myWriter.write(String.valueOf(this.gamesWon));
            myWriter.close();
        }
        catch (IOException error)
        {
            System.out.println("Could not write to file.");
        }
    }
}