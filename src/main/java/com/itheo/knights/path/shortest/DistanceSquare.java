package com.itheo.knights.path.shortest;

import com.itheo.knights.chess.board.Square;

public class DistanceSquare extends Square {

    private Integer distance;

    public DistanceSquare(int x, int y, int distance) {
        super(x, y);
        this.distance = distance;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Boolean reached(Square targetSquare) {
        return this.getX() == targetSquare.getX()
                && this.getY() == targetSquare.getY();

    }

}
