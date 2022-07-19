package submission;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    @DisplayName("recursiveBinarySearch - sheet example")
    void recursiveBinarySearch_sheet() {
        double[] array = {0.9936663283720449, 0.9714835319278629, 0.5921970175311418, 0.17129161673684445,
                0.010987932438898618};
        double key = 0.9714835319278629;

        BinarySearch ob = new BinarySearch();

        assertEquals(1, ob.recursiveBinarySearch(array, 0, array.length, key));
        assertEquals(2, ob.counter);

    }

    @Test
    @DisplayName("iterativeBinarySearch")
    void iterativeBinarySearch_sheet() {
        int[] array = {55, 55, 55, 50, 4, 3, 1, 0, -1, -1, -2};

        // call the iterative binary search
        BinarySearch ob = new BinarySearch();
        List<Integer> indices_55 = ob.IterativeBinarySearch(array, 55);
        List<Integer> res_55 = Arrays.asList(0, 1, 2);

        assertEquals(res_55, indices_55);

        List<Integer> indices_1 = ob.IterativeBinarySearch(array, -1);
        List<Integer> res_1 = Arrays.asList(8, 9);

        assertEquals(res_1, indices_1);
    }

    @Test
    @DisplayName("recursiveBinarySearch - no key found")
    void recursiveBinarySearch_no_key() {
        double[] array = {0.9936663283720449, 0.9714835319278629, 0.5921970175311418, 0.17129161673684445,
                0.010987932438898618};
        double key = 0.914835319278629;

        BinarySearch ob = new BinarySearch();

        assertEquals(-1, ob.recursiveBinarySearch(array, 0, array.length, key));
        assertEquals(2, ob.counter);

    }

    @Test
    @DisplayName("iterativeBinarySearch - no key found ")
    void iterativeBinarySearch_no_key() {
        int[] array = {55, 55, 55, 50, 4, 3, 1, 0, -1, -1, -2};

        // call the iterative binary search
        BinarySearch ob = new BinarySearch();
        List<Integer> indices_not_found = ob.IterativeBinarySearch(array, 70);
        List<Integer> res_not_found = Arrays.asList(0, 1, 2);

        assertEquals(res_not_found, indices_not_found);


    }
}
