package ru.novik.xo.view;

import ru.novik.xo.controllers.CurrentMoveController;
import ru.novik.xo.controllers.MoveController;
import ru.novik.xo.controllers.WinnerController;
import ru.novik.xo.model.Field;
import ru.novik.xo.model.Figure;
import ru.novik.xo.model.Game;
import ru.novik.xo.model.exceptions.AlreadyOccupiedException;
import ru.novik.xo.model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();
    private final WinnerController winnerController = new WinnerController();
    private final MoveController moveController = new MoveController();

    public void show(final Game game) {
        System.out.format("Game name: %s\n", game.getName());
        final Field field = game.getField();
        for (int x = 0; x < field.getSize(); x++) {
            if (x != 0)
                printSeparator();
            printLine(field, x);
        }
    }

    public boolean move(final Game game) throws InvalidPointException {
        final Field field = game.getField();
        final Figure winner = winnerController.getWinner(field);
        if (winner != null) {
            System.out.format("Winner is %s:", winner);
            return false;
        }
        final Figure currentFigure = currentMoveController.currentMove(field);
        if (currentFigure == null) {
            System.out.println("No winner and no moves left");
            return false;
        }
        System.out.format("Please enter coordinate for %s\n:", currentFigure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(field, point, currentFigure);
        } catch (final InvalidPointException | AlreadyOccupiedException e) {
            System.out.println("Point is invalid!");
        }
        return true;
    }

    private Point askPoint() {
        return new Point(askCoordinate("X"), askCoordinate("Y"));
    }

    private int askCoordinate(final String coordinateName) {
        System.out.format("Please input %s:", coordinateName);
        Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("No String value!");
            return askCoordinate(coordinateName);
        }
    }

    private void printLine(final Field field,
                           final int x) {
        for (int y = 0; y < field.getSize(); y++) {
            if (y != 0)
                System.out.print("|");
            System.out.print(" ");
            final Figure figure;
            try {
                figure = field.getFigure(new Point(y, x));
            } catch (final InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");
        }
        System.out.println();
    }

    public void printSeparator() {
        System.out.println("-----------");
    }
}
