package graph;

import graph.MinimumKnightMoves;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MinimumKnightMovesTest {

    MinimumKnightMoves mkm;

    @BeforeEach
    void setUp() {
        mkm = new MinimumKnightMoves();
    }

    @Test
    @DisplayName("(2,1) should take 1 move, [0, 0] → [2, 1]")
    void test21move() {
        assertEquals(1, mkm.minKnightMoves(2, 1),
                "(2,1) should take 1 move, [0, 0] → [2, 1]");
    }

    @Test
    @DisplayName("(5,5) should take 4 moves, [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]")
    void test55move() {
        assertEquals(4, mkm.minKnightMoves(5, 5),
                "(5,5) should take 4 moves, [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]");
    }
}
