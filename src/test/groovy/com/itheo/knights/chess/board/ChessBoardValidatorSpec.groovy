package com.itheo.knights.chess.board

import spock.lang.Specification
import spock.lang.Unroll

class ChessBoardValidatorSpec extends Specification {

    @Unroll
    def "IsWithinBounds"() {
        given:
            ChessBoardValidator validator = new ChessBoardValidator(2, 2)
        when:
            boolean isValid = validator.isWithinBounds(position)
        then:
            isValid == shouldBeValid
        where:
            position                    | shouldBeValid
            new Square(-1, -1)  | false
            new Square(1, 1)    | true
            new Square(2, 0)    | false
    }
}
