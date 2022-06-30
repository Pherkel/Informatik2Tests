package submission;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BucketLookup2DTest {

    @Test
    @DisplayName("Max Count In Array - Case1 (Simple)")
    void prefixSumMaxCountTester1() {
        BucketLookup2D klasse = new BucketLookup2D();
        int[] test_arr = {0, 3, 2, 4, 5, 7, 1, 0};
        assertEquals(7, klasse.prefixSumMaxCountTester(test_arr));
    }

    @Test
    @DisplayName("PrefixSum of Array - Case1 (Simple)")
    void prefixSumArrTester1() {
        BucketLookup2D klasse = new BucketLookup2D();
        int[] test_arr = {0, 3, 2, 4, 5, 7, 1, 0};
        int[] out_arr = {0, 0, 3, 5, 9, 14, 21, 22};
        assertArrayEquals(out_arr, klasse.prefixSumArrTester(test_arr));
    }

    @Test
    @DisplayName("PrefixSum of Array - Case2 (Empty Array)")
    void prefixSumArrTester2() {
        BucketLookup2D klasse = new BucketLookup2D();
        int[] test_arr = new int[0];
        int[] out_arr = new int[0];
        assertArrayEquals(out_arr, klasse.prefixSumArrTester(test_arr));
    }

    @Test
    @DisplayName("Max Count In Array - Case2 (Empty Array)")
    void prefixSumMaxCountTester2() {
        BucketLookup2D klasse = new BucketLookup2D();
        int[] test_arr = new int[0];
        assertEquals(0, klasse.prefixSumMaxCountTester(test_arr));
    }


    @Test
    @DisplayName("Object Indices - Example 1")
    void computeOITest() {
        BucketLookup2D klasse = new BucketLookup2D();

        int[] bucketAssignment = {0, 2, 0, 2, 0, 0, 0, 3, 2, 0, 1, 1};
        int[] bucketOffset = {0, 0, 1, 1, 2, 3, 4, 0, 2, 5, 0, 1};
        int[] bucketOffsets = {0, 6, 8, 11, 12};

        int[] res = {0, 2, 4, 5, 6, 9, 10, 11, 1, 3, 8, 7};
        assertArrayEquals(res, klasse.computeOITest(bucketAssignment, bucketOffset, bucketOffsets));
    }
    @Test
    @DisplayName("Object Indices - Empty")
    void computeOITest2() {
        BucketLookup2D klasse = new BucketLookup2D();

        int[] bucketAssignment = new int[0];
        int[] bucketOffset = new int[0];
        int[] bucketOffsets = new int[0];

        int[] res = new int[0];
        assertArrayEquals(res, klasse.computeOITest(bucketAssignment, bucketOffset, bucketOffsets));
    }
}