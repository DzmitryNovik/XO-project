package ru.novik.xo.controllers;

import org.junit.jupiter.api.Test;
import ru.novik.xo.model.Field;
import ru.novik.xo.model.Figure;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class WinnerControllerTest {

    @Test
    void getWinnerWhenWinnerRow() throws Exception {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.X);
            assertEquals(Figure.X, winnerController.getWinner(field));
        }
    }

    @Test
    void getWinnerWhenNoWinnerRow() throws Exception {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.O);
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    void getWinnerWhenWinnerColumn() throws Exception {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.X);
            assertEquals(Figure.X, winnerController.getWinner(field));
        }
    }

    @Test
    void getWinnerWhenNoWinnerColumn() throws Exception {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.O);
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    void getWinnerWhenWinnerDiagOne() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field field = new Field(3);
        for (int i = 0; i < 3; i++) {
            field.setFigure(new Point(i, i), Figure.X);
        }
        assertEquals(Figure.X, winnerController.getWinner(field));
    }

    @Test
    void getWinnerWhenNoWinnerDiagOne() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field field = new Field(3);
        for (int i = 0; i < 2; i++) {
            field.setFigure(new Point(i, i), Figure.X);
        }
        field.setFigure(new Point(2, 2), Figure.O);
        assertNull(winnerController.getWinner(field));
    }

    @Test
    void getWinnerWhenWinnerDiagTwo() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field field = new Field(3);
        for (int i = 0; i < 3; i++) {
            int j = 2 - i;
            field.setFigure(new Point(i, j), Figure.X);
        }
        assertEquals(Figure.X, winnerController.getWinner(field));
    }

    @Test
    void getWinnerWhenNoWinnerDiagTwo() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field field = new Field(3);
        for (int i = 0; i < 2; i++) {
            int j = 2 - i;
            field.setFigure(new Point(i, j), Figure.X);
        }
        field.setFigure(new Point(2, 0), Figure.O);
        assertNull(winnerController.getWinner(field));
    }


}