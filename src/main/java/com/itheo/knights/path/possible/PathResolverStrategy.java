package com.itheo.knights.path.possible;

import com.itheo.knights.chess.board.ChessBoard;
import com.itheo.knights.chess.board.Square;
import com.itheo.knights.chess.pieces.ChessPiece;

import java.util.List;

public interface PathResolverStrategy {
    List<List<Square>> apply(ChessBoard chess, ChessPiece piece, Square targetPosition, int totalMoves);
}
