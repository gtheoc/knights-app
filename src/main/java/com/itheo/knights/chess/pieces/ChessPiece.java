package com.itheo.knights.chess.pieces;

import com.itheo.knights.chess.board.Square;

import java.util.List;

public abstract class ChessPiece implements Piece {

    private Square position;
    private PieceColour colour;

    public ChessPiece() {
    }

    public ChessPiece(Square position, PieceColour colour) {
        this.position = position;
        this.colour = colour;
    }

    public Square getPosition() {
        return position;
    }

    public void setPosition(Square position) {
        this.position = position;
    }

    public PieceColour getColour() {
        return colour;
    }

    public void setColour(PieceColour colour) {
        this.colour = colour;
    }

    public abstract List<Square> getPossibleMoves();
    public abstract void move(Square position);

}
