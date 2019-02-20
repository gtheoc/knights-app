package com.itheo.knights.chess.pieces.moves;

import java.util.stream.Stream;

public enum KnightMoves {

    BACK_LEFT(-1, -2),
    BACK_RIGHT(1, -2),
    FRONT_LEFT(-1, 2),
    FRONT_RIGHT(1, 2),
    LEFT_BACK(-2, -1),
    RIGHT_BACK(2, -1),
    LEFT_FRONT(-2, 1),
    RIGHT_FRONT(2, 1);

    private int x;
    private int y;

    KnightMoves(int x, int y) {
        this.x = x;
        this.y = y;
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

    public static Stream<KnightMoves> stream() {
        return Stream.of(KnightMoves.values());
    }
}
