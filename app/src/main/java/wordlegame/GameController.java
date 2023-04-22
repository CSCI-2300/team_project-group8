package wordlegame;

public interface GameController
{
    public void getCategory(String category);
    public void getUserGuess(String userGuess);
    public void incrementGamesPlayed();
    public void incrementGamesWon();
}