package ru.novik.xo.controllers;

import ru.novik.xo.model.Field;
import ru.novik.xo.model.Figure;
import ru.novik.xo.model.exceptions.AlreadyOccupiedException;
import ru.novik.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Field field,
                            final Point point,
                            final Figure figure) throws InvalidPointException,
                                                        AlreadyOccupiedException {
        if (field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);
    }
}
