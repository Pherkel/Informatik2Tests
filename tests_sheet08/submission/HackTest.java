package submission;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HackTest {

    @Test
    @DisplayName("valid - Invalid (contains zero)")
    void invalid_contains_zero() {
        Hack hack = new Hack(9, 3);
        int[] dat = {0, 2, 7};
        assertFalse(hack.valid(dat));
    }


    @Test
    @DisplayName("valid - Invalid (not divisible")
    void invalid_case2() {
        Hack hack = new Hack(9, 9);
        int[] dat = {1, 2, 3, 2, 5, 2, 5, 6, 2};
        assertFalse(hack.valid(dat));
    }

    @Test
    @DisplayName("valid - Valid")
    void valid_case3() {
        Hack hack = new Hack(9, 9);
        int[] dat = {1, 2, 3, 2, 5, 2, 5, 6, 1};
        assertTrue(hack.valid(dat));
    }

    @Test
    @DisplayName("valid - Invalid (contains zero)")
    void valid_invalid1() {
        Hack hack = new Hack(9, 9);
        int[] dat = {0, 2, 7, 0, 0, 0, 0, 0, 0};
        assertFalse(hack.valid(dat));
    }

    @Test
    @DisplayName("valid - Valid (zeros after valid solution")
    void valid_case4() {
        Hack hack = new Hack(9, 9);
        int[] dat = {1, 2, 3, 0, 0, 0, 0, 0, 0};
        assertTrue(hack.valid(dat));
    }

    @Test
    @DisplayName("valid - Invalid (not divisible)")
    void invalid_case4() {
        Hack hack = new Hack(9, 9);
        int[] dat = {1, 2, 3, 2, 7, 0, 0};
        assertFalse(hack.valid(dat));
    }

    @Test
    @DisplayName("Valid - Case 6 - Valid")
    void valid_case6() {
        Hack hack = new Hack(9, 9);
        int[] dat = {1, 2, 3, 2, 5, 2, 5};
        assertTrue(hack.valid(dat));
    }

    @Test
    @DisplayName("valid  - Invalid (zero in between)")
    void invalid_case6() {
        Hack hack = new Hack(9, 9);
        int[] dat = {1, 2, 0, 2, 5, 2, 5};
        assertFalse(hack.valid(dat));
    }


    @Test
    @DisplayName("Unlock - 9 digits")
    void unlock_9() {
        Hack hack = new Hack(9, 9);
        int[] res = {1, 2, 3, 2, 5, 2, 5, 6, 1};
        hack.unlock(9);
        assertArrayEquals(res, hack.solution);
    }

    @Test
    @DisplayName("Unlock - 8 digits")
    void unlock_8() {
        Hack hack = new Hack(9, 8);
        int[] res = {1, 2, 3, 2, 5, 2, 5, 6};
        hack.unlock(8);
        assertArrayEquals(res, hack.solution);
    }

    @Test
    @DisplayName("Unlock - 7 digits")
    void unlock_7() {
        Hack hack = new Hack(9, 7);
        int[] res = {1, 2, 3, 2, 5, 2, 5};
        hack.unlock(7);
        assertArrayEquals(res, hack.solution);
    }

    @Test
    @DisplayName("Unlock - 4 digits (max digit 4)")
    void unlock_4_4() {
        Hack hack = new Hack(4, 4);
        int[] res = {1, 2, 3, 2};
        hack.unlock(4);
        assertArrayEquals(res, hack.solution);
    }

}