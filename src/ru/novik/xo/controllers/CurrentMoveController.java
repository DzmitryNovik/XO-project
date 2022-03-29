package ru.novik.xo.controllers;

import ru.novik.xo.model.Field;
import ru.novik.xo.model.Figure;
import ru.novik.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Field field) throws InvalidPointException {
        int figureCounter = 0;

        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                if (field.getFigure(new Point(i, j)) != null) {
                    figureCounter++;
                }
            }
        }

        if (figureCounter == field.getSize() * field.getSize()) {
            return null;
        }

        if (figureCounter % 2 != 0) {
            return Figure.X;
        }

        return Figure.O;


    }
}
