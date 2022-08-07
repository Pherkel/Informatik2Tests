package submission;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NWayMergeTest {

    @Test
    @DisplayName("proposeNextPartition - simple")
    void proposeNextPart_test_simple() {

        short[][] individuallySortedArrays = {{1, 1, 5, 5, 6, 6, 200, 200}, {-2, -2, 0, 0, 1, 1}, {128, 128}};

        short[] res = {-2, -2, 0, 0, 1, 1, 1, 1, 5, 5, 6, 6, 128, 128, 200, 200};

        NWayMerge merger = new NWayMerge(individuallySortedArrays, true);
        short[] simpleMerge = merger.simpleMerge();

        assertArrayEquals(res, simpleMerge);
    }

    @Test
    @DisplayName("proposeNextPartition - heap")
    void proposeNextPart_test_heap() {

        short[][] individuallySortedArrays = {
                {1, 1, 5, 5, 6, 6, 200, 200},  // 0
                {-2, -2, 0, 0, 1, 1},          // 1
                {128, 128}};                   // 2

        //   1
        // 0   2

        //  0  1  2
        // [1, 3, 0]

        // [-2, -2, 0 ,0, 1,1, 1, 1
        short[] res = {-2, -2, 0, 0, 1, 1, 1, 1, 5, 5, 6, 6, 128, 128, 200, 200};

        NWayMerge merger = new NWayMerge(individuallySortedArrays, true);
        short[] heapMerge = merger.heapMerge();

        assertArrayEquals(res, heapMerge);
    }

    @Test
    @DisplayName("percolate Heap test")
    void percolateHeap_test() {

        short[][] individuallySortedArrays = {
                {1, 1, 5, 5, 6, 6, 200, 200},       // 0
                {-2, -2, 0, 0, 1, 1},               // 1
                {128, 128},                         // 2
                {-200, -200, 50, 50, 78, 78, 2, 2}, // 3
                {33, 33, -10, -10}                  // 4 // 3 1 0 4 2
        };

        short[] res = {-2, -2, 0, 0, 1, 1, 1, 1, 5, 5, 6, 6, 128, 128, 200, 200};

        NWayMerge merger = new NWayMerge(individuallySortedArrays, true);
        short[] heapMerge = merger.heapMerge();

        assertArrayEquals(res, heapMerge);
    }

}