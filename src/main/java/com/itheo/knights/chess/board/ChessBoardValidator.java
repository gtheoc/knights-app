package com.itheo.knights.chess.board;

public class ChessBoardValidator {

    private final int totalX;
    private final int totalY;

    public ChessBoardValidator(int totalX, int totalY) {
        this.totalX = totalX;
        this.totalY = totalY;
    }

    public boolean isWithinBounds(Square position) {
        return position.getX() < totalX && position.getX() >= 0
                && position.getY() < totalY && position.getY() >= 0;
    }
}
