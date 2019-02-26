package com.itheo.knights.path.possible;

import com.itheo.knights.chess.board.ChessBoard;
import com.itheo.knights.chess.board.Square;
import com.itheo.knights.chess.pieces.ChessPiece;
import com.itheo.knights.path.SquareState;
import com.itheo.knights.traverse.DepthFirstSearch;

import java.util.List;
import java.util.stream.Collectors;

public class DepthFirstPathResolverStrategy implements PathResolverStrategy  {

    @Override
    public List<List<Square>> apply(ChessBoard chess, ChessPiece piece, Square targetPosition, int totalMoves) {
        SquareState startingState = new SquareState(chess, piece.getPosition(), piece.getClass());
        SquareState reachingState = new SquareState(chess, targetPosition, piece.getClass());
        List text = new DepthFirstSearch<SquareState>().getNDepthReachingPaths(startingState, reachingState, totalMoves).stream()
            .map(state -> state.getFullPath())
            .collect(Collectors.toList());
        return text;
    }
}
