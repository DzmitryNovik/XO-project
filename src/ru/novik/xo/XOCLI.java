package ru.novik.xo;

import ru.novik.xo.model.Field;
import ru.novik.xo.model.Figure;
import ru.novik.xo.model.Game;
import ru.novik.xo.model.Player;
import ru.novik.xo.model.exceptions.InvalidPointException;
import ru.novik.xo.view.ConsoleView;

public class XOCLI {
    public static void main(final String[] args) {
        final String nameOne = "Dima";
        final String nameTwo = "Valia";

        final Player[] players = new Player[2];
        players[0] = new Player(nameOne, Figure.X);
        players[1] = new Player(nameTwo, Figure.O);

        final Game gameXO = new Game(players, new Field(3), "XO");

        final ConsoleView consoleView = new ConsoleView();
        while (true) {
            consoleView.show(gameXO);
            try {
                if (!consoleView.move(gameXO)) break;
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
            consoleView.show(gameXO);
        }
    }
}
