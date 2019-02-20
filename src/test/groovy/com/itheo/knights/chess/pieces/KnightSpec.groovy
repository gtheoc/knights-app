package com.itheo.knights.chess.pieces

import com.itheo.knights.chess.board.Square
import spock.lang.Specification

class KnightSpec extends Specification {

    def "GetPossibleMoves"() {
        given:
            Knight knight = new Knight(new Square(0, 0), PieceColour.BLACK)
        when:
            def possibleMoves = knight.getPossibleMoves()
        then:
            possibleMoves == [
                new Square(-1, -2), new Square(1, -2), new Square(-1, 2), new Square(1, 2),
                new Square(-2, -1), new Square(2, -1), new Square(-2, 1), new Square(2, 1)
           ]

    }

    def "Move"() {
        given:
            Knight knight = new Knight(new Square(0, 0), PieceColour.BLACK)
        when:
            knight.move(new Square(1, 2))
        then:
            knight.position.x == 1
            knight.position.y == 2
    }
}
