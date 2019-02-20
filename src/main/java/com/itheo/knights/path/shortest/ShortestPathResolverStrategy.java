package com.itheo.knights.path.shortest;

import com.itheo.knights.chess.board.ChessBoard;
import com.itheo.knights.chess.board.Square;
import com.itheo.knights.chess.pieces.ChessPiece;

public interface ShortestPathResolverStrategy {
    Integer apply(ChessBoard chess, ChessPiece piece, Square targetPosition);
}
