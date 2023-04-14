package wordlegame.model;

import java.util.ArrayList;

import wordlegame.GameObserver;

public class HiddenWord
{
    String hiddenWord;
    ArrayList<GameObserver> observers = new ArrayList<GameObserver>();
    public HiddenWord()
    {
        this.hiddenWord = "CLOUD";
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