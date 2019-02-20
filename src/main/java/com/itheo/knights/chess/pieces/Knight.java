package com.itheo.knights.chess.pieces;

import com.itheo.knights.chess.board.Square;
import com.itheo.knights.chess.pieces.moves.KnightMoves;

import java.util.List;
import java.util.stream.Collectors;

public class Knight extends ChessPiece {

    public Knight() {
    }

    public Knight(Square position, PieceColour colour) {
        super(position, colour);
    }

    @Override
    public List<Square> getPossibleMoves() {
        return KnightMoves.stream()
                .map(move -> new Square(getPosition().getX() + move.getX(), getPosition().getY() + move.getY()))
                .collect(Collectors.toList());
    }

    @Override
    public void move(Square toPosition) {
        getPosition().setX(toPosition.getX());
        getPosition().setY(toPosition.getY());
    }
}
