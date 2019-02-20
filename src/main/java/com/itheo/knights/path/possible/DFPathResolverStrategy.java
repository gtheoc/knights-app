package com.itheo.knights.path.possible;

import com.itheo.knights.chess.board.ChessBoard;
import com.itheo.knights.chess.board.Square;
import com.itheo.knights.chess.pieces.ChessPiece;

import java.util.*;

public class DFPathResolverStrategy implements PathResolverStrategy {

    public List<List<Square>> apply(ChessBoard chess, ChessPiece piece, Square targetPosition, int totalMoves) {
        List<List<Square>> paths = new LinkedList<>();

        Queue<List<Square>> q = new LinkedList<>();
        q.add(new LinkedList<>(Collections.singletonList(new Square(piece.getPosition().getX(), piece.getPosition().getY()))));

        while (!q.isEmpty()) {

            List<Square> path = q.poll();

            if (path.size() <= totalMoves) {
                chess.performMove(piece, path.get(path.size() - 1));
                chess.getAvailableMoves(piece)
                    .forEach(move -> {
                        chess.performMove(piece, move);
                        List<Square> nextPath = new LinkedList<>(path);
                        nextPath.add(new Square(piece.getPosition().getX(), piece.getPosition().getY()));
                        q.add(nextPath);

                        if (piece.getPosition().equals(targetPosition)) {
                            paths.add(nextPath);
                        }
                    });
            }
        }
        return paths;
    }

}
