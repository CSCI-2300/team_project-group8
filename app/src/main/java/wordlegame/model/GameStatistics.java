package wordlegame.model;

public class GameStatistics
{
    int gamesPlayed;
    int gamesWon;

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
}