package ru.novik.xo.model;

import org.junit.jupiter.api.Test;
import ru.novik.xo.model.exceptions.AlreadyOccupiedException;
import ru.novik.xo.model.exceptions.InvalidPointException;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    void getSize() {
        final Field field = new Field();
        assertEquals(3, field.getSize());
    }

    @Test
    void setFigure() throws InvalidPointException, AlreadyOccupiedException {
        final Field field = new Field();
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }
}