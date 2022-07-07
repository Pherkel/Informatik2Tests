package submission;

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
}