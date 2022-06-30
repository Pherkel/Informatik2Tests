package submission;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatternFinderTest {


    @Test
    @DisplayName("passRules - skipping row")
    void passRules_skipping_row() {
        PatternFinder finder = new PatternFinder(3, 3);
        int[][] test_pattern = {
                {0, 0},
                {0, 0}

        };

        assertFalse(finder.passRules(3, 1, test_pattern, 1));
    }

    @Test
    @DisplayName("passRules - not skipping row")
    void passRules_not_skipping_row() {
        PatternFinder finder = new PatternFinder(3, 3);
        int[][] test_pattern = {
                {0, 0},
                {0, 0}

        };

        assertTrue(finder.passRules(1, 1, test_pattern, 1));
    }

    @Test
    @DisplayName("passRules - skipping column in same row")
    void passRules_skipping_column_in_same_row() {
        PatternFinder finder = new PatternFinder(3, 3);
        int[][] test_pattern = {
                {3, 2},
                {0, 0}

        };

        assertFalse(finder.passRules(3, 0, test_pattern, 1));
    }

    @Test
    @DisplayName("passRules - skipping row and column")
    void passRules_skipping_row_and_column() {
        PatternFinder finder = new PatternFinder(3, 3);
        int[][] test_pattern = {
                {0, 0},
                {0, 0}

        };

        assertFalse(finder.passRules(2, 2, test_pattern, 1));
    }

    @Test
    @DisplayName("passRules - not skipping column in same row")
    void passRules_not_skipping_column_in_same_row() {
        PatternFinder finder = new PatternFinder(3, 3);
        int[][] test_pattern = {
                {3, 0},
                {0, 0}

        };

        assertTrue(finder.passRules(2, 2, test_pattern, 1));
    }

    @Test
    @DisplayName("passRules - selecting node twice")
    void passRules_select_node_twice() {
        PatternFinder finder = new PatternFinder(3, 3);
        int[][] test_pattern = {
                {3, 2},
                {0, 0}

        };

        assertFalse(finder.passRules(3, 2, test_pattern, 1));
    }

    @Test
    @DisplayName("solver - 2x2, length 2")
    void solver_2_2() {
        int patternLength = 2;
        int triangleDepth = 2;

        PatternFinder finder = new PatternFinder(triangleDepth, patternLength);
        finder.solver(patternLength);
        assertEquals(6, finder.counter);
    }

    @Test
    @DisplayName("solver - 3x3, length 2")
    void solver_3_2() {
        int triangleDepth = 3;
        int patternLength = 2;

        PatternFinder finder = new PatternFinder(triangleDepth, patternLength);
        finder.solver(patternLength);
        assertEquals(22, finder.counter);
    }

    @Test
    @DisplayName("solver - 3x3, length 1")
    void solver_3_1() {
        int triangleDepth = 3;
        int patternLength = 1;

        PatternFinder finder = new PatternFinder(triangleDepth, patternLength);
        finder.solver(patternLength);
        assertEquals(6, finder.counter);
    }

    @Test
    @DisplayName("solver - 3x3, length 3")
    void solver_3_3() {
        int triangleDepth = 3;
        int patternLength = 3;

        PatternFinder finder = new PatternFinder(triangleDepth, patternLength);
        finder.solver(patternLength);
        assertEquals(66, finder.counter);
    }

    @Test
    @DisplayName("solver - 10x10, length 3")
    void solver_10_3() {
        int triangleDepth = 10;
        int patternLength = 3;

        PatternFinder finder = new PatternFinder(triangleDepth, patternLength);
        finder.solver(patternLength);
        assertEquals(10566, finder.counter);
    }

}