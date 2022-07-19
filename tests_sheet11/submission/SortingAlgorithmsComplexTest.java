package submission;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortingAlgorithmsComplexTest {

    @Test
    void bubbleSort_comp1() {
        Person person1 = new Person(1, null, 0);
        person1.priority = 29;

        Person person2 = new Person(2, null, 0);
        person2.priority = 10;

        Person person3 = new Person(3, null, 0);
        person3.priority = 14;

        Person person4 = new Person(4, null, 0);
        person4.priority = 37;

        Person person5 = new Person(5, null, 0);
        person5.priority = 14;

        Person person6 = new Person(6, null, 0);
        person6.priority = 38;

        Person person7 = new Person(7, null, 0);
        person7.priority = 1;

        Person person8 = new Person(8, null, 0);
        person8.priority = 50;

        List<Person> personList = Arrays.asList(person1, person2, person3, person4, person5, person6, person7, person8);

        List<Long> res_bubble = Arrays.asList(8L, 6L, 4L, 1L, 3L, 5L, 2L, 17L);

        SortingAlgorithms sorter = new SortingAlgorithms();

        assertEquals(res_bubble, sorter.bubbleSort(personList, 7));

    }

    @Test
    void insertionSort() {
        Person person1 = new Person(1, null, 0);
        person1.priority = 29;

        Person person2 = new Person(2, null, 0);
        person2.priority = 10;

        Person person3 = new Person(3, null, 0);
        person3.priority = 14;

        Person person4 = new Person(4, null, 0);
        person4.priority = 37;

        Person person5 = new Person(5, null, 0);
        person5.priority = 14;

        Person person6 = new Person(6, null, 0);
        person6.priority = 38;

        Person person7 = new Person(7, null, 0);
        person7.priority = 1;

        Person person8 = new Person(8, null, 0);
        person8.priority = 50;

        List<Person> personList = Arrays.asList(person1, person2, person3, person4, person5, person6, person7, person8);

        SortingAlgorithms sorter = new SortingAlgorithms();

        List<Long> res_insertion = Arrays.asList(8L, 6L, 4L, 1L, 3L, 5L, 2L, 17L);

        assertEquals(res_insertion, sorter.insertionSort(personList, 7));
    }


    @Test
    void selectionSort() {
        Person person1 = new Person(1, null, 0);
        person1.priority = 29;

        Person person2 = new Person(2, null, 0);
        person2.priority = 10;

        Person person3 = new Person(3, null, 0);
        person3.priority = 14;

        Person person4 = new Person(4, null, 0);
        person4.priority = 37;

        Person person5 = new Person(5, null, 0);
        person5.priority = 14;

        Person person6 = new Person(6, null, 0);
        person6.priority = 38;

        Person person7 = new Person(7, null, 0);
        person7.priority = 1;

        Person person8 = new Person(8, null, 0);
        person8.priority = 50;

        List<Person> personList = Arrays.asList(person1, person2, person3, person4, person5, person6, person7, person8);

        SortingAlgorithms sorter = new SortingAlgorithms();

        List<Long> res_insertion = Arrays.asList(8L, 6L, 4L, 1L, 5L, 3L, 2L, 6L);

        assertEquals(res_insertion, sorter.selectionSort(personList, 7));
    }

    @Test
    void shakerSort() {
        Person person1 = new Person(1, null, 0);
        person1.priority = 29;

        Person person2 = new Person(2, null, 0);
        person2.priority = 10;

        Person person3 = new Person(3, null, 0);
        person3.priority = 14;

        Person person4 = new Person(4, null, 0);
        person4.priority = 37;

        Person person5 = new Person(5, null, 0);
        person5.priority = 14;

        Person person6 = new Person(6, null, 0);
        person6.priority = 38;

        Person person7 = new Person(7, null, 0);
        person7.priority = 1;

        Person person8 = new Person(8, null, 0);
        person8.priority = 50;

        List<Person> personList = Arrays.asList(person1, person2, person3, person4, person5, person6, person7, person8);

        SortingAlgorithms sorter = new SortingAlgorithms();

        List<Long> res_insertion = Arrays.asList(8L, 6L, 4L, 1L, 3L, 5L, 2L, 17L);

        assertEquals(res_insertion, sorter.shakerSort(personList, 7));
    }
}