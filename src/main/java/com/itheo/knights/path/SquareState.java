package com.itheo.knights.path;

import com.itheo.knights.chess.board.ChessBoard;
import com.itheo.knights.chess.board.Square;
import com.itheo.knights.chess.pieces.Piece;
import com.itheo.knights.chess.pieces.PieceFactory;
import com.itheo.knights.traverse.PathNode;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SquareState<P extends Piece> implements PathNode {

    private ChessBoard board;
    private Square currentSquare;
    private List<Square> path;
    private Class<P> pClass;

    public SquareState(ChessBoard board, Square square, Class<P> clazz) {
        this.board = board;
        this.currentSquare = square;
        this.path = new LinkedList<>();
        this.pClass = clazz;
    }

    @Override
    public Square getCurrent() {
        return this.currentSquare;
    }

    @Override
    public List<PathNode> getSuccessors() {
        Function<Square, SquareState> toSquareState = square -> {
            Piece aPiece = PieceFactory.create(pClass);
            aPiece.setPosition(square);
            board.performMove(aPiece, square);
            SquareState state = new SquareState(board, aPiece.getPosition(), pClass);
            state.addAllToPath(this.path);
            state.path.add(this.currentSquare);
            return state;
        };
        Piece piece = PieceFactory.create(pClass);
        piece.setPosition(this.currentSquare);
        return board.getAvailableMoves(piece)
                .stream()
                .map(toSquareState)
                .collect(Collectors.toList());
    }

    public List<Square> getFullPath() {
        List fullPath = new LinkedList<>();
        fullPath.addAll(path);
        fullPath.add(currentSquare);
        return fullPath;
    }

    public List<Square> getPath() {
        return path;
    }

    public void addToPath(Square square) {
        path.add(square);
    }

    public void addAllToPath(List<Square> oldPath) {
        path.addAll(oldPath);
    }

}
