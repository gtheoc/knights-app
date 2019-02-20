package com.itheo.knights.chess.board;

import com.itheo.knights.chess.pieces.ChessPiece;
import com.itheo.knights.chess.pieces.Piece;

import java.util.List;
import java.util.stream.Collectors;

public abstract class ChessBoard implements Board {

    private final static int DEFAULT_X = 8;
    private final static int DEFAULT_Y = 8;

    protected Object[][] board;
    private int x;
    private int y;
    private ChessBoardValidator boardValidator;

    public ChessBoard() {
        this.x = DEFAULT_X;
        this.y = DEFAULT_Y;
        this.boardValidator = new ChessBoardValidator(this.x, this.y);
        initialize();
    }

    public ChessBoard(int x, int y) {
        this.x = x;
        this.y = y;
        this.boardValidator = new ChessBoardValidator(this.x, this.y);
        this.initialize();
    }

    protected abstract void initialize();

    public abstract void print();

    public List<Square> getAvailableMoves(Piece piece) {
        return piece.getPossibleMoves()
                .stream()
                .filter(move -> boardValidator.isWithinBounds(move))
                .collect(Collectors.toList());
    }

    public void performMove(Piece piece, Square targetSquare) {
        piece.move(targetSquare);
    }

    public Object[][] getBoard() {
        return board;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
