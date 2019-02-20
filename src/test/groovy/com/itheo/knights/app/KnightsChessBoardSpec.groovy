package com.itheo.knights.app

import com.itheo.knights.chess.board.ChessBoard
import com.itheo.knights.chess.board.Square
import com.itheo.knights.chess.pieces.Piece
import spock.lang.Specification

class KnightsChessBoardSpec extends Specification {

    def "initialize creates a valid board"() {
        given:
            ChessBoard board = new KnightsChessBoard(2, 2)
        when:
            board.initialize()
        then:
            board.getBoard() instanceof String[][]
            board.getBoard()[0][0] == "A0"
            board.getBoard()[1][0] == "B0"
            board.getBoard()[0][1] == "A1"
            board.getBoard()[1][1] == "B1"
        //TODO implement/test cases like AA0...
    }

    def "Get available moves works as expected"() {
        given:
            ChessBoard board = new KnightsChessBoard(2, 2)
            Piece piece = Mock(Piece)
        when:
            def availableMoves = board.getAvailableMoves(piece)
        then:
            1 * piece.getPossibleMoves() >> {
                [new Square(-1, -1), new Square(1, 0), new Square(3, 3)]
            }
            availableMoves.size() == 1
            availableMoves.get(0).getX() == 1
            availableMoves.get(0).getY() == 0
    }

    def "performMove calls the piece move"() {
        given:
            ChessBoard board = new KnightsChessBoard()
            Piece piece = Mock(Piece)
            Square targetSquare = new Square(0, 0)
        when:
            board.performMove(piece, targetSquare)
        then:
            1 * piece.move(targetSquare)
            0 * _
            // TODO implement/test: reflect move on the board
    }
}
