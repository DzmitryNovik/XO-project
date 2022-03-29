package ru.novik.xo.controllers;

import org.junit.jupiter.api.Test;
import ru.novik.xo.model.Field;
import ru.novik.xo.model.Figure;
import ru.novik.xo.model.exceptions.InvalidPointException;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CurrentMoveControllerTest {

    @Test
    void currentMoveO() throws InvalidPointException {
        CurrentMoveController currentMoveController = new CurrentMoveController();
        final Field field = new Field(3);
        try {
            field.setFigure(new Point(0, 0), Figure.X);
            field.setFigure(new Point(0, 1), Figure.X);
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        assertEquals(Figure.O, currentMoveController.currentMove(field));
    }

    @Test
    void currentMoveX() throws InvalidPointException {
        CurrentMoveController currentMoveController = new CurrentMoveController();
        final Field field = new Field(3);
        try {
            field.setFigure(new Point(0, 0), Figure.X);
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        assertEquals(Figure.X, currentMoveController.currentMove(field));
    }

    @Test
    void currentMoveWhenFieldIsFull() throws InvalidPointException {
        CurrentMoveController currentMoveController = new CurrentMoveController();
        final Field field = new Field(3);
        try {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    field.setFigure(new Point(i, j), Figure.X);
                }
            }
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        assertNull(currentMoveController.currentMove(field));
    }
}