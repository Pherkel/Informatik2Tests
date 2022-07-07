package submission;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DirectedGraphTest {

    @Test
    void adjacentNodes() {
    }

    @Test
    void pathExistsBetween() {
    }

    @Test
    @DisplayName("shortestPathBetween - sheet example")
    void shortestPathBetween() {
        DirectedGraph graph = new DirectedGraph(4);
        graph.connect(0, 2, 9);
        graph.connect(0, 3, 1);
        graph.connect(3, 1, 2);
        graph.connect(1, 2, 3);

        ArrayList<Integer> actualArray = graph.shortestPathBetween(0, 2);
        ArrayList<Integer> expectedArray = new ArrayList<>(Arrays.asList(0, 3, 1, 2));

        assertEquals(expectedArray, actualArray);
    }

    @Test
    @DisplayName("costOfPath - sheet example")
    void costOfPath_sheet_example() {
        DirectedGraph graph = new DirectedGraph(4);
        graph.connect(0, 2, 9);
        graph.connect(0, 3, 1);
        graph.connect(3, 1, 2);
        graph.connect(1, 2, 3);

        ArrayList<Integer> testArray = new ArrayList<>(Arrays.asList(0, 3, 1, 2));
        assertEquals(6.0, graph.costOfPath(testArray));
    }

    @Test
    @DisplayName("costOfPath - path not connected")
    void costOfPath() {
        DirectedGraph graph = new DirectedGraph(4);
        graph.connect(0, 2, 9);
        graph.connect(0, 3, 1);
        graph.connect(3, 1, 2);
        graph.connect(1, 2, 3);

        ArrayList<Integer> testArray = new ArrayList<>(Arrays.asList(0, 1, 2));

        assertEquals(Double.POSITIVE_INFINITY, graph.costOfPath(testArray));
    }
}