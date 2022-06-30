package submission;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.Line;

import static org.junit.jupiter.api.Assertions.*;

class LineFinderTest {
    
    @Test
    @DisplayName("passRules - bending line")
    void passRules_bend() {
        LineFinder finder = new LineFinder(3, 3);
        int[][] test_pattern = {{0, 0}, {1, 1}

        };
        assertFalse(finder.passRules(2, 0, test_pattern, 1));
    }

    @Test
    @DisplayName("passRules - skip one node")
    void passRules_skip_node() {
        LineFinder finder = new LineFinder(5, 3);
        int[][] test_pattern = {{0, 0}, {1, 1}

        };
        assertFalse(finder.passRules(3, 3, test_pattern, 1));
    }

    @Test
    @DisplayName("solver - triangle 3, length 2")
    void solver_3_2() {
        LineFinder finder = new LineFinder(3, 2);
        finder.solver(2);
        assertEquals(20, finder.counter);
    }

    @Test
    @DisplayName("solver - triangle 5, length 5")
    void solver_5_5() {
        LineFinder finder = new LineFinder(5, 5);
        finder.solver(5);
        assertEquals(6, finder.counter);
    }

    @Test
    @DisplayName("solver - triangle 5, length 1")
    void solver_5_1() {
        LineFinder finder = new LineFinder(5, 1);
        finder.solver(1);
        assertEquals(15, finder.counter);
    }

    @Test
    @DisplayName("solver - triangle 10, length 3")
    void solver_10_3() {
        LineFinder finder = new LineFinder(10, 3);
        finder.solver(3);
        assertEquals(258, finder.counter);
    }
}