/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package wordlegame;
import wordlegame.model.HiddenWord;
import wordlegame.view.StatsGUI;
import wordlegame.model.GameStatistics;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ModelTesting {

    //this is testing the getGamesWon() method 
    @Test
    public void testGetGamesWon() 
    {
        GameStatistics stats = new GameStatistics();
        assertEquals(0, stats.getGamesWon());
    }

    //testing if games won increments
    @Test
    public void testIncrementGamesWon() 
    {
        GameStatistics stats = new GameStatistics();
        stats.incrementGamesWon();
        assertEquals(1, stats.getGamesWon());
        stats.incrementGamesWon();
        assertEquals(2, stats.getGamesWon());
    }

    //testing if games played retrieves the right number 
    @Test
    public void testGetGamesPlayed() 
    {
        GameStatistics stats = new GameStatistics();
        assertEquals(0, stats.getGamesPlayed());
    }

    //testing if the games played increments correctly 
    @Test
    public void testIncrementGamesPlayed() 
    {
        GameStatistics stats = new GameStatistics();
        stats.incrementGamesPlayed();
        assertEquals(1, stats.getGamesPlayed());
        stats.incrementGamesPlayed();
        assertEquals(2, stats.getGamesPlayed());
    }

    @Test
    public void getWinPercentage() 
    {
        GameStatistics gameStatistics = new GameStatistics();
        gameStatistics.incrementGamesPlayed();
        gameStatistics.incrementGamesWon();
        double testingPercentageHundred = 100; 
        assertEquals(testingPercentageHundred, gameStatistics.getWinPercentage(), 0.0);


        gameStatistics.incrementGamesPlayed();
        double testingPercentageFifty = 50; 
        assertEquals(testingPercentageFifty, gameStatistics.getWinPercentage(), 0.0);


        //gameStatistics.resetStats();
        //double testingPercentageZero = 0; 
        //assertEquals(testingPercentageZero, gameStatistics.getWinPercentage(), 0.0);
    }

}