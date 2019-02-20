package com.itheo.knights.path.shortest;

import com.itheo.knights.chess.board.ChessBoard;
import com.itheo.knights.chess.board.Square;
import com.itheo.knights.chess.pieces.ChessPiece;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class BFShortestPathResolverStrategy implements ShortestPathResolverStrategy {

    @Override
    public Integer apply(ChessBoard chess, ChessPiece piece, Square targetPosition) {
        Map<DistanceSquare, Boolean> visited = new HashMap<>();

        Queue<DistanceSquare> q = new ArrayDeque<>();
        q.add(new DistanceSquare(piece.getPosition().getX(), piece.getPosition().getY(), 0));

        while (!q.isEmpty()) {

            DistanceSquare square = q.poll();

            if (square.reached(targetPosition)) {
                return square.getDistance();
            }

            if (visited.get(square) == null) {
                visited.put(square, true);
                ChessPiece tmpPiece;
                try {
                    tmpPiece = piece.getClass().newInstance();
                    tmpPiece.setPosition(square);

                    chess.getAvailableMoves(tmpPiece)
                        .forEach(move -> {
                            chess.performMove(tmpPiece, move);
                            q.add(new DistanceSquare(tmpPiece.getPosition().getX(),
                                    tmpPiece.getPosition().getY(),
                                    square.getDistance() + 1));
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    return -1;
                }
            }
        }
        return -1;
    }
}
