package com.itheo.knights.chess.board;

import com.itheo.knights.traverse.Node;

import java.util.Objects;

public class Square extends Node {

    private SquareColour colour;

    public Square(int x, int y) {
        super(x, y);
    }

    public Square(int x, int y, SquareColour colour) {
        super(x, y);
        this.colour = colour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Square square = (Square) o;
        return getX() == square.getX()
                && getY() == square.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY(), colour);
    }

    @Override
    public String toString() {
        return "[" + this.getX() + ", " + this.getY() + "]";
    }
}
