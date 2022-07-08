package submission;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DirectedGraphTest {

    @Test
    @DisplayName("adjacentNodes - sheet example")
    void adjacentNodes_sheet() {
        DirectedGraph graph = new DirectedGraph(4);
        graph.connect(0, 2, 0);
        graph.connect(0, 3, 0);
        graph.connect(1, 3, 0);

        assertEquals(Arrays.asList(2, 3), graph.adjacentNodes(0));
        assertEquals(Arrays.asList(3), graph.adjacentNodes(1));
        assertEquals(Arrays.asList(), graph.adjacentNodes(2));
    }

    @Test
    @DisplayName("pathExistsBetween - sheet example")
    void pathExistsBetween_sheet() {
        DirectedGraph graph = new DirectedGraph(4);
        graph.connect(0, 2, 0);
        graph.connect(0, 3, 0);
        graph.connect(3, 1, 0);

        assertFalse(graph.pathExistsBetween(2, 0));
        assertTrue(graph.pathExistsBetween(0, 1));
    }

    @Test
    @DisplayName("pathExistsBetween - complex example 1")
        // Image of the Graph: https://nextcloud.pherkel.de/index.php/s/9mJk7cqi4kqnrZg
    void pathExistsBetween_complex_1() {
        DirectedGraph graph = new DirectedGraph(10);
        graph.connect(4, 0, 7);
        graph.connect(0, 6, 7);
        graph.connect(6, 0, 7);
        graph.connect(6, 4, 1);
        graph.connect(6, 9, 3);
        graph.connect(9, 7, 42);
        graph.connect(9, 2, 3);
        graph.connect(2, 6, 3);
        graph.connect(2, 5, 3);
        graph.connect(5, 1, 3);
        graph.connect(1, 8, 3);
        graph.connect(8, 5, 3);
        graph.connect(5, 3, 3);
        graph.connect(3, 8, 3);

        assertFalse(graph.pathExistsBetween(7, 3));
        assertTrue(graph.pathExistsBetween(6, 1));
    }

    @Test
    @DisplayName("shortestPathBetween - sheet example")
    void shortestPathBetween_sheet_example() {
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
    @DisplayName("shortestPathBetween - complex example")
        // Image of the Graph: https://nextcloud.pherkel.de/index.php/s/9mJk7cqi4kqnrZg
    void shortestPathBetween_complex() {
        DirectedGraph graph = new DirectedGraph(10);
        graph.connect(4, 0, 7);
        graph.connect(0, 6, 7);
        graph.connect(6, 0, 7);
        graph.connect(6, 4, 1);
        graph.connect(6, 9, 3);
        graph.connect(9, 7, 42);
        graph.connect(9, 2, 3);
        graph.connect(2, 6, 3);
        graph.connect(2, 5, 3);
        graph.connect(5, 1, 3);
        graph.connect(1, 8, 3);
        graph.connect(8, 5, 3);
        graph.connect(5, 3, 3);
        graph.connect(3, 8, 3);

        ArrayList<Integer> actualPath_4_1 = graph.shortestPathBetween(4, 1);
        ArrayList<Integer> expectedPath_4_1 = new ArrayList<>(Arrays.asList(4, 0, 6, 9, 2, 5, 1));

        assertEquals(expectedPath_4_1, actualPath_4_1);
        assertEquals(26.0, graph.costOfPath(actualPath_4_1));

        ArrayList<Integer> actualPath_9_8 = graph.shortestPathBetween(9, 8);
        ArrayList<Integer> expectedPath_9_8 = new ArrayList<>(Arrays.asList(9, 2, 5, 1, 8));

        assertEquals(expectedPath_9_8, actualPath_9_8);
        assertEquals(12.0, graph.costOfPath(actualPath_9_8));
    }

    @Test
    @DisplayName("shortestPathBetween - complex example")
        // Image of the graph: https://nextcloud.pherkel.de/index.php/s/r2GZZAw3FJHKd6k
    void shortestPathBetween_complex_2() {
        DirectedGraph graph = new DirectedGraph(10);
        graph.connect(4, 0, 7.354);
        graph.connect(0, 6, 1.5);
        graph.connect(6, 0, 1.5);
        graph.connect(6, 4, 0.001);
        graph.connect(6, 9, 3.4);
        graph.connect(9, 7, 42);
        graph.connect(9, 2, 3);
        graph.connect(2, 6, 20.3);
        graph.connect(2, 5, 200.34);
        graph.connect(5, 1, 3);
        graph.connect(1, 8, 3);
        graph.connect(8, 5, 4.004);
        graph.connect(5, 3, 50.3224);
        graph.connect(3, 8, 3);
        graph.connect(0, 1, 26.5);

        ArrayList<Integer> actualPath_4_1 = graph.shortestPathBetween(4, 1);
        ArrayList<Integer> expectedPath_4_1 = new ArrayList<>(Arrays.asList(4, 0, 1));

        assertEquals(expectedPath_4_1, actualPath_4_1);
        assertEquals(33.854, graph.costOfPath(actualPath_4_1));

        ArrayList<Integer> actualPath_9_8 = graph.shortestPathBetween(9, 8);
        ArrayList<Integer> expectedPath_9_8 = new ArrayList<>(Arrays.asList(9, 2, 6, 0, 1, 8));

        assertEquals(expectedPath_9_8, actualPath_9_8);
        assertEquals(54.3, graph.costOfPath(actualPath_9_8));
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