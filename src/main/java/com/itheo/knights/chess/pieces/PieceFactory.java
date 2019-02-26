package com.itheo.knights.chess.pieces;

public final class PieceFactory {

    public static <P extends Piece> Piece create(Class<P> p) {
        try {
            return p.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
