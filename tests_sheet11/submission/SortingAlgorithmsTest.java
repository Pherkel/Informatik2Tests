package submission;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

class SortingAlgorithmsTest {

    @Test
    @DisplayName("bubbleSort - sheet example")
    void bubbleSort_sheet() {
        double[] dummyCoords = {0, 0};

        Person person1 = new Person(1, dummyCoords, 0);
        person1.priority = 0.755;

        Person person2 = new Person(2, dummyCoords, 0);
        person1.priority = 0.785;

        Person person3 = new Person(3, dummyCoords, 0);
        person1.priority = 0.490;

        Person person4 = new Person(4, dummyCoords, 0);
        person1.priority = 0.405;

        Person person5 = new Person(5, dummyCoords, 0);
        person1.priority = 0.557;


        List<Person> personList = Arrays.asList(person1, person2, person3, person4, person5);

        List<Long> res = Arrays.asList(2L, 1L, 5L, 3L);

        SortingAlgorithms sorter = new SortingAlgorithms();

        assertEquals(sorter.bubbleSort(personList, 3), res);
    }

    @Test
    void insertionSort() {
    }

    @Test
    void selectionSort() {
    }

    @Test
    void shakerSort() {
    }
}