package com.itheo.knights.chess.pieces;

import com.itheo.knights.chess.board.Square;

import java.util.List;

public interface Piece {

    List<Square> getPossibleMoves();
    void move(Square position);
}
