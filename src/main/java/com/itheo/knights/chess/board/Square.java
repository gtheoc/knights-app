package com.itheo.knights.chess.board;

import java.util.Objects;

public class Square {
    private int x;
    private int y;
    private SquareColour colour;

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Square(int x, int y, SquareColour colour) {
        this.x = x;
        this.y = y;
        this.colour = colour;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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
        return "[" + x + ", " + y + "]";
    }
}
