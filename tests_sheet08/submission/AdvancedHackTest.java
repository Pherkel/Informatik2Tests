package submission;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AdvancedHackTest {

    @Test
    @DisplayName("valid - Invalid (contains zero)")
    void invalid_contains_zero() {
        AdvancedHack hack = new AdvancedHack(9, 3);
        int[] dat = {0, 2, 7};
        assertFalse(hack.valid(dat));
    }


    @Test
    @DisplayName("valid - Invalid (not divisible")
    void invalid_case2() {
        AdvancedHack hack = new AdvancedHack(9, 9);
        int[] dat = {1, 2, 3, 2, 5, 2, 5, 6, 2};
        assertFalse(hack.valid(dat));
    }

    @Test
    @DisplayName("valid - Valid")
    void valid_case3() {
        AdvancedHack hack = new AdvancedHack(9, 9);
        int[] dat = {1, 2, 3, 2, 5, 2, 5, 6, 1};
        assertTrue(hack.valid(dat));
    }

    @Test
    @DisplayName("valid - Invalid (contains zero)")
    void valid_invalid1() {
        AdvancedHack hack = new AdvancedHack(9, 9);
        int[] dat = {0, 2, 7, 0, 0, 0, 0, 0, 0};
        assertFalse(hack.valid(dat));
    }

    @Test
    @DisplayName("valid - Valid (zeros after valid solution")
    void valid_case4() {
        AdvancedHack hack = new AdvancedHack(9, 9);
        int[] dat = {1, 2, 3, 0, 0, 0, 0, 0, 0};
        assertTrue(hack.valid(dat));
    }

    @Test
    @DisplayName("valid - Invalid (not divisible)")
    void invalid_case4() {
        AdvancedHack hack = new AdvancedHack(9, 9);
        int[] dat = {1, 2, 3, 2, 7, 0, 0};
        assertFalse(hack.valid(dat));
    }

    @Test
    @DisplayName("Valid - Case 6 - Valid")
    void valid_case6() {
        AdvancedHack hack = new AdvancedHack(9, 9);
        int[] dat = {1, 2, 3, 2, 5, 2, 5};
        assertTrue(hack.valid(dat));
    }

    @Test
    @DisplayName("valid  - Invalid (zero in between)")
    void invalid_case6() {
        AdvancedHack hack = new AdvancedHack(9, 9);
        int[] dat = {1, 2, 0, 2, 5, 2, 5};
        assertFalse(hack.valid(dat));
    }

    @Test
    @DisplayName("Unlock - 9 digits")
    void unlock_case1() {
        AdvancedHack hack = new AdvancedHack(9, 9);
        hack.unlock(9);
        assertEquals(416, hack.solutions.length);
    }

    @Test
    @DisplayName("Unlock - 8 digits")
    void unlock_case2() {
        AdvancedHack hack = new AdvancedHack(9, 8);
        hack.unlock(8);
        assertEquals(416, hack.solutions.length);
    }

    @Test
    @DisplayName("Unlock - 7 digits")
    void unlock_case3() {
        AdvancedHack hack = new AdvancedHack(9, 7);
        hack.unlock(7);
        assertEquals(416, hack.solutions.length);
    }


    @Test
    @DisplayName("Unlock - 6 digits")
    void unlock_case4() {
        AdvancedHack hack = new AdvancedHack(9, 6);
        hack.unlock(6);
        assertEquals(324, hack.solutions.length);
    }

    @Test
    @DisplayName("Unlock - 5 digits")
    void unlock_case5() {
        AdvancedHack hack = new AdvancedHack(9, 5);
        hack.unlock(5);
        assertEquals(216, hack.solutions.length);
    }

    @Test
    @DisplayName("Unlock - 4 digits")
    void unlock_case6() {
        AdvancedHack hack = new AdvancedHack(9, 4);
        hack.unlock(4);
        assertEquals(216, hack.solutions.length);
    }

    @Test
    @DisplayName("Unlock - 3 digits")
    void unlock_case7() {
        AdvancedHack hack = new AdvancedHack(9, 3);
        hack.unlock(3);
        assertEquals(108, hack.solutions.length);
    }

    @Test
    @DisplayName("Unlock - 2 digits")
    void unlock_case8() {
        AdvancedHack hack = new AdvancedHack(9, 2);
        hack.unlock(2);
        assertEquals(36, hack.solutions.length);
    }

    @Test
    @DisplayName("Unlock - 1 digits")
    void unlock_case9() {
        AdvancedHack hack = new AdvancedHack(9, 1);
        hack.unlock(1);
        assertEquals(9, hack.solutions.length);
    }

    @Test
    @DisplayName("Unlock - 3 digits (max digit 4")
    void unlock_case3_4() {
        AdvancedHack hack = new AdvancedHack(4, 3);
        hack.unlock(3);
        assertEquals(11, hack.solutions.length);
    }

    @Test
    @DisplayName("Unlock - 7 digits (max digit 6)")
    void unlock_case12_4() {
        AdvancedHack hack = new AdvancedHack(6, 7);
        hack.unlock(7);
        assertEquals(46, hack.solutions.length);
    }
}