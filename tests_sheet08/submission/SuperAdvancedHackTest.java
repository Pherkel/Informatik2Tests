package submission;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuperAdvancedHackTest {

    @Test
    @DisplayName("valid - Invalid (contains zero)")
    void invalid_contains_zero() {
        SuperAdvancedHack hack = new SuperAdvancedHack(9, 3);
        int[] dat = {0, 2, 7};
        assertFalse(hack.valid(dat));
    }


    @Test
    @DisplayName("valid - Invalid (not divisible + contains duplicate)")
    void invalid_case2() {
        SuperAdvancedHack hack = new SuperAdvancedHack(9, 9);
        int[] dat = {1, 2, 3, 2, 5, 2, 5, 6, 2};
        assertFalse(hack.valid(dat));
    }

    @Test
    @DisplayName("valid - Invalid (contains duplicate)")
    void valid_case3() {
        SuperAdvancedHack hack = new SuperAdvancedHack(9, 9);
        int[] dat = {1, 2, 3, 2, 5, 2, 5, 6, 1};
        assertFalse(hack.valid(dat));
    }

    @Test
    @DisplayName("valid - Invalid (contains zero)")
    void valid_invalid1() {
        SuperAdvancedHack hack = new SuperAdvancedHack(9, 9);
        int[] dat = {0, 2, 7, 0, 0, 0, 0, 0, 0};
        assertFalse(hack.valid(dat));
    }

    @Test
    @DisplayName("valid - Invalid (contains duplicate)")
    void valid_case4() {
        SuperAdvancedHack hack = new SuperAdvancedHack(9, 9);
        int[] dat = {1, 2, 3, 0, 0, 0, 0, 0, 0};
        assertFalse(hack.valid(dat));
    }

    @Test
    @DisplayName("valid - Invalid (not divisible + contains duplicates)")
    void invalid_case4() {
        SuperAdvancedHack hack = new SuperAdvancedHack(9, 9);
        int[] dat = {1, 2, 3, 2, 7, 0, 0};
        assertFalse(hack.valid(dat));
    }

    @Test
    @DisplayName("Valid - Invalid (contains duplicates)")
    void valid_case6() {
        SuperAdvancedHack hack = new SuperAdvancedHack(9, 9);
        int[] dat = {1, 2, 3, 2, 5, 2, 5};
        assertFalse(hack.valid(dat));
    }

    @Test
    @DisplayName("valid  - Invalid (zero in between)")
    void invalid_case6() {
        SuperAdvancedHack hack = new SuperAdvancedHack(9, 9);
        int[] dat = {1, 2, 0, 2, 5, 2, 5};
        assertFalse(hack.valid(dat));
    }


    @Test
    @DisplayName("contains_duplicate - Does not contain duplicate")
    void contains_duplicate() {
        SuperAdvancedHack hack = new SuperAdvancedHack(9, 9);
        int[] test_arr = {0, 1, 2, 3, 4, 5, 10, 34};
        assertFalse(hack.contains_duplicate(test_arr));
    }

    @Test
    @DisplayName("contains_duplicate - contains duplicate")
    void contains_duplicate2() {
        SuperAdvancedHack hack = new SuperAdvancedHack(9, 9);
        int[] test_arr = {0, 1, 2, 3, 4, 5, 1, 34};
        assertTrue(hack.contains_duplicate(test_arr));
    }

    @Test
    @DisplayName("unlock - length 9")
    void unlock_length_9() {
        SuperAdvancedHack hack = new SuperAdvancedHack(9, 9);
        hack.unlock(9);
        assertEquals(1, hack.solutions.length);
    }

    @Test
    @DisplayName("unlock - length 8")
    void unlock_length_8() {
        SuperAdvancedHack hack = new SuperAdvancedHack(9, 8);
        hack.unlock(8);
        assertEquals(1, hack.solutions.length);
    }

    @Test
    @DisplayName("unlock - length 4")
    void unlock_length_4() {
        SuperAdvancedHack hack = new SuperAdvancedHack(9, 4);
        hack.unlock(4);
        assertEquals(1, hack.solutions.length);
    }

    @Test
    @DisplayName("unlock - length 3")
    void unlock_length_3() {
        SuperAdvancedHack hack = new SuperAdvancedHack(9, 3);
        hack.unlock(3);
        assertEquals(80, hack.solutions.length);
    }

    @Test
    @DisplayName("unlock - length 2")
    void unlock_length_2() {
        SuperAdvancedHack hack = new SuperAdvancedHack(9, 2);
        hack.unlock(2);
        assertEquals(32, hack.solutions.length);
    }

    @Test
    @DisplayName("unlock - length 1")
    void unlock_length_1() {
        SuperAdvancedHack hack = new SuperAdvancedHack(9, 1);
        hack.unlock(1);
        assertEquals(9, hack.solutions.length);
    }

}