package com.itheo.knights.path;

import com.itheo.knights.chess.board.ChessBoard;
import com.itheo.knights.chess.board.Square;

public class PiecePathContext {

    private ChessBoard chess;
    private Square startPosition;
    private Square targetPosition;
    private int totalMoves;
//    private PieceType type;

    //TODO Builder???
    public PiecePathContext(ChessBoard chess, Square startPosition, Square targetPosition, int totalMoves) {
        this.chess = chess;
        this.startPosition = startPosition;
        this.targetPosition = targetPosition;
        this.totalMoves = totalMoves;
    }

    public ChessBoard getChess() {
        return chess;
    }

    public void setChess(ChessBoard chess) {
        this.chess = chess;
    }

    public Square getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Square startPosition) {
        this.startPosition = startPosition;
    }

    public Square getTargetPosition() {
        return targetPosition;
    }

    public void setTargetPosition(Square targetPosition) {
        this.targetPosition = targetPosition;
    }

    public int getTotalMoves() {
        return totalMoves;
    }

    public void setTotalMoves(int totalMoves) {
        this.totalMoves = totalMoves;
    }
}
