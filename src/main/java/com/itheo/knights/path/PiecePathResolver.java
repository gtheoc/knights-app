package com.itheo.knights.path;

import com.itheo.knights.chess.board.Square;
import com.itheo.knights.chess.pieces.ChessPiece;
import com.itheo.knights.path.possible.PathResolverStrategy;
import com.itheo.knights.path.shortest.BFShortestPathResolverStrategy;
import com.itheo.knights.path.shortest.ShortestPathResolverStrategy;

import java.util.List;

public class PiecePathResolver<P extends ChessPiece> {

    private final PiecePathContext context;
    private final Class<P> clazz;

    public PiecePathResolver(PiecePathContext context, Class<P> pClass) {
        this.context = context;
        this.clazz = pClass;
    }

    public void resolvePaths(PathResolverStrategy strategy) {
        // TODO Log duration ...
        List<List<Square>> paths = resolve(strategy);
        if (paths.size() > 0) {
            showPaths(paths);
        } else {
            System.out.println("No solution available for maximum steps: " + context.getTotalMoves());
            int requiredSteps = resolveShortestPath(new BFShortestPathResolverStrategy());
            System.out.println("Shortest Path Steps: " + requiredSteps);
            context.setTotalMoves(requiredSteps);
            List<List<Square>> shortestPaths = resolve(strategy);
            if (shortestPaths.size() > 0) {
                showPaths(shortestPaths);
            }
        }
    }

    private void showPaths(List<List<Square>> paths) {
        paths.forEach(path -> {
            System.out.print("[ ");
            path.forEach(square -> {
                System.out.print(context.getChess().getBoard()[square.getX()][square.getY()] + " ");
            });
            System.out.print("]\n");
        });
    }

    private P createPiece(Square position) {
        try {
            P piece = clazz.newInstance();
            piece.setPosition(position);
            return piece;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<List<Square>> resolve(PathResolverStrategy strategy) {
        P piece = createPiece(new Square(context.getStartPosition().getX(), context.getStartPosition().getY()));
        return strategy.apply(
                context.getChess(),
                piece,
                context.getTargetPosition(),
                context.getTotalMoves());
    }

    private int resolveShortestPath(ShortestPathResolverStrategy strategy) {
        P piece = createPiece(new Square(context.getStartPosition().getX(), context.getStartPosition().getY()));
        return strategy.apply(context.getChess(), piece, context.getTargetPosition());
    }

}
