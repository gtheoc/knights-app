package com.itheo.knights.app;

import com.itheo.knights.chess.board.ChessBoard;

public class KnightsChessBoard extends ChessBoard {

    public KnightsChessBoard() {
        super();
    }

    public KnightsChessBoard(int x, int y) {
        super(x, y);
    }

    protected void initialize() {
        board = new String[getX()][getY()];
        for (int i = 0; i < getX(); i++) {
            for (int j = 0; j < getY(); j++) {
                board[i][j] = ((char) ('A' + i)) + Integer.toString(j);
            }
        }
    }

    public void print() {
        //TODO
    }

}
