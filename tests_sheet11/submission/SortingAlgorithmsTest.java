Person person1 = new Person(1, null, 0);
        person1.priority = 0.755;

        Person person2 = new Person(2, null, 0);
        person2.priority = 0.785;

        Person person3 = new Person(3, null, 0);
        person3.priority = 0.490;

        Person person4 = new Person(4, null, 0);
        person4.priority = 0.405;

        Person person5 = new Person(5, null, 0);
        person5.priority = 0.557;

        List<Person> personList = Arrays.asList(person1, person2, person3, person4, person5);

        List<Long> res = Arrays.asList(2L, 1L, 5L, 3L);

        SortingAlgorithms sorter = new SortingAlgorithms();

        assertEquals(res, sorter.bubbleSort(personList, 3));
    }

    @Test
    @DisplayName("insertionSort - sheet example")
    void insertionSort_sheet() {
        Person person1 = new Person(1, null, 0);
        person1.priority = 0.755;

        Person person2 = new Person(2, null, 0);
        person2.priority = 0.785;

        Person person3 = new Person(3, null, 0);
        person3.priority = 0.490;

        Person person4 = new Person(4, null, 0);
        person4.priority = 0.405;

        Person person5 = new Person(5, null, 0);
        person5.priority = 0.557;

        List<Person> personList = Arrays.asList(person1, person2, person3, person4, person5);

        List<Long> res = Arrays.asList(2L, 1L, 5L, 3L);

        SortingAlgorithms sorter = new SortingAlgorithms();

        assertEquals(res, sorter.insertionSort(personList, 3));
    }

    @Test
    @DisplayName("selectionSort - sheet example")
    void selectionSort_sheet() {
        Person person1 = new Person(1, null, 0);
        person1.priority = 0.755;

        Person person2 = new Person(2, null, 0);
        person2.priority = 0.785;

        Person person3 = new Person(3, null, 0);
        person3.priority = 0.490;

        Person person4 = new Person(4, null, 0);
        person4.priority = 0.405;

        Person person5 = new Person(5, null, 0);
        person5.priority = 0.557;

        List<Person> personList = Arrays.asList(person1, person2, person3, person4, person5);

        List<Long> res = Arrays.asList(2L, 1L, 5L, 3L);

        SortingAlgorithms sorter = new SortingAlgorithms();

        assertEquals(res, sorter.selectionSort(personList, 3));
    }

    @Test
    @DisplayName("shakerSort - sheet example")
    void shakerSort_sheet() {
        Person person1 = new Person(1, null, 0);
        person1.priority = 0.755;

        Person person2 = new Person(2, null, 0);
        person2.priority = 0.785;

        Person person3 = new Person(3, null, 0);
        person3.priority = 0.490;

        Person person4 = new Person(4, null, 0);
        person4.priority = 0.405;

        Person person5 = new Person(5, null, 0);
        person5.priority = 0.557;

        List<Person> personList = Arrays.asList(person1, person2, person3, person4, person5);

        List<Long> res = Arrays.asList(2L, 1L, 5L, 3L);

        SortingAlgorithms sorter = new SortingAlgorithms();

        assertEquals(res, sorter.shakerSort(personList, 3));
    }



}
