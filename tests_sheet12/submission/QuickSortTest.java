package submission;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void sort_simple() {
        short[] samples = {1, 1, 5, 5, 3, 3, -2, -2};

        short[] sortedSamples = {-2, -2, 1, 1, 3, 3, 5, 5};

        QuickSort.sort(samples, 0, samples.length / 2 - 1, true);

        assertArrayEquals(sortedSamples, samples);
    }

    @Test
    void sort_simple2() {
        short[] samples = {1, 1, 5, 5, 3, 3, -2, -2, 5, 5, 100, 100, -101, -101, -99, -99};

        short[] sortedSamples = {-101, -101, -99, -99, -2, -2, 1, 1, 3, 3, 5, 5, 5, 5, 100, 100};

        QuickSort.sort(samples, 0, (samples.length / 2) - 1, true);

        assertArrayEquals(sortedSamples, samples);
    }
}