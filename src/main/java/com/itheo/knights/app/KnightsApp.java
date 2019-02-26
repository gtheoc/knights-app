package com.itheo.knights.app;

import com.itheo.knights.chess.board.Square;
import com.itheo.knights.chess.pieces.Knight;
import com.itheo.knights.path.PiecePathContext;
import com.itheo.knights.path.PiecePathResolver;
import com.itheo.knights.path.possible.DepthFirstPathResolverStrategy;
import com.itheo.knights.path.possible.QPathResolverStrategy;

public class KnightsApp {

    private static final int BOARD_X = 8;
    private static final int BOARD_Y = 8;

    private static final int TOTAL_STEPS = 3;


    public static void main(String[] args) {

        KnightsChessBoard chess = new KnightsChessBoard(BOARD_X, BOARD_Y);

        Square startingPosition = new Square(0, 0);
        Square targetPosition = new Square(6, 3);

        PiecePathContext context = new PiecePathContext(chess, startingPosition, targetPosition, TOTAL_STEPS);
        PiecePathResolver<Knight> knightsPathResolver = new PiecePathResolver<>(context, Knight.class);
        knightsPathResolver.resolvePaths(new QPathResolverStrategy());

        knightsPathResolver.resolvePaths(new DepthFirstPathResolverStrategy());

    }
}
