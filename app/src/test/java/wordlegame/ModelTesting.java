/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package wordlegame;
import wordlegame.model.HiddenWord;
import wordlegame.model.GameStatistics;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue; 

import org.junit.Test;

public class ModelTesting 
{
    private HiddenWord hw; 

    @Test
    public void testGetGamesWon() 
    {
        GameStatistics stats = new GameStatistics();
        assertEquals(0, stats.getGamesWon());
    }

    @Test
    public void testIncrementGamesWon() 
    {
        GameStatistics stats = new GameStatistics();
        stats.incrementGamesWon();
        assertEquals(1, stats.getGamesWon());
        stats.incrementGamesWon();
        assertEquals(2, stats.getGamesWon());
    }

    @Test
    public void testGetGamesPlayed() 
    {
        GameStatistics stats = new GameStatistics();
        assertEquals(0, stats.getGamesPlayed());
    }

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

    }

    @Test
    public void testSetHiddenWord() 
    {
        hw = new HiddenWord();
        hw.setHiddenWord("SHARK", "animals.txt");
        assertEquals("SHARK", hw.getHiddenWord());
    }

    @Test
    public void testGetHiddenWord() 
    {
        HiddenWord hiddenWord = new HiddenWord();
        hiddenWord.setHiddenWord("SHARK", "animals.txt");
        assertEquals("SHARK", hiddenWord.getHiddenWord());
    }

    @Test
    public void testGetOccurances() 
    {
        HiddenWord hiddenWord = new HiddenWord();
        hiddenWord.setHiddenWord("HIDDEN", "words.txt");

        assertEquals(2, hiddenWord.getOccurances('D'));
        assertEquals(1, hiddenWord.getOccurances('H'));
        assertEquals(0, hiddenWord.getOccurances('Z'));
    }

    @Test
    public void testCheckGuessValid() 
    {
        HiddenWord hiddenWord = new HiddenWord();
        hiddenWord.setHiddenWord("APPLE", "words.txt");
        hiddenWord.checkGuess("APPLR");
        assertTrue(hiddenWord.getGuessStatus());

    }

    @Test
    public void testCheckGreen() 
    {
        HiddenWord hiddenWord = new HiddenWord();
        hiddenWord.setHiddenWord("SHARK", "animals.txt");
        hiddenWord.checkGuess("SHARK");

        assertTrue(hiddenWord.getColors().get(0).equals("GREEN")); 
        assertTrue(hiddenWord.getColors().get(1).equals("GREEN")); 
        assertTrue(hiddenWord.getColors().get(2).equals("GREEN")); 
        assertTrue(hiddenWord.getColors().get(3).equals("GREEN")); 
        assertTrue(hiddenWord.getColors().get(4).equals("GREEN")); 

    }

    @Test
    public void testCheckYellow() 
    {
        HiddenWord hiddenWord = new HiddenWord();
        hiddenWord.setHiddenWord("SHARK", "animals.txt");
        hiddenWord.checkGuess("SNAKE");

        assertTrue(hiddenWord.getColors().get(0).equals("GREEN")); 
        assertTrue(hiddenWord.getColors().get(1).equals("GRAY")); 
        assertTrue(hiddenWord.getColors().get(2).equals("GREEN")); 
        assertTrue(hiddenWord.getColors().get(3).equals("YELLOW")); 
        assertTrue(hiddenWord.getColors().get(4).equals("GRAY")); 
    }
    

    @Test
    public void testIsGameOverLoser() 
    {
        HiddenWord hw = new HiddenWord();
        hw.setHiddenWord("SHARK", "animals.txt");
        hw.checkGuess("SLOTH");
        hw.checkGuess("SKINK");
        hw.checkGuess("EAGLE");
        hw.checkGuess("SLOTH");
        hw.checkGuess("SLOTH");
        hw.checkGuess("SLOTH");
        assertTrue(hw.isGameOver());
        assertFalse(hw.isWinner());
    }

    @Test
    public void testIsGameOverWinner() 
    {
        HiddenWord hw = new HiddenWord();
        hw.setHiddenWord("SHARK", "animals.txt");
        hw.checkGuess("SHARK");
        assertTrue(hw.isGameOver());
        assertTrue(hw.isWinner());
    }

    @Test
    public void testIsGameOverWinnerLater() 
    {
        HiddenWord hw = new HiddenWord();
        hw.setHiddenWord("SHARK", "animals.txt");
        hw.checkGuess("SLOTH");
        hw.checkGuess("SHARK");
        assertTrue(hw.isGameOver());
        assertTrue(hw.isWinner());
    }
  
    @Test
    public void testInCategory() 
    {
        HiddenWord hw = new HiddenWord();
        hw.setHiddenWord("SHARK", "animals.txt");

        // Test a word that is in the category file
        hw.checkGuess("SLOTH");
        assertTrue(hw.getInCategory());

        // Test a word that is not in the category file
        hw.checkGuess("CAIRO");
        assertFalse(hw.getInCategory());
    }
}


    
  
    

    






    


