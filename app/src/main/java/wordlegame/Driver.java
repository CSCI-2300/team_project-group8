package wordlegame;

import wordlegame.model.HiddenWord;
import wordlegame.controller.Controller;

public class Driver {

    public static void main(String[] args) {

        HiddenWord hiddenWord = new HiddenWord();

        Controller controller = new Controller(hiddenWord);
    }
}
