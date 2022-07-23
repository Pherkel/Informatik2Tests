package submission;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortingThreadTest {


    @Test
    void SortingThread_test() {
        short[] samples = {1, 1, 5, 5, 3, 3, -2, -2};

        short[] sortedSamples = {-2, -2, 1, 1, 3, 3, 5, 5};

        SortingThread sorter = new SortingThread(samples, true);

        System.out.println(Arrays.toString(sorter.getSortedSamples()));

        assertArrayEquals(sortedSamples, sorter.getSortedSamples());

    }
}