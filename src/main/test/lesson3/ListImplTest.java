package lesson3;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListImplTest {

    public static final String RANDOM_STRING_1 = "randomString1";
    public static final String RANDOM_STRING_2 = "randomString2";
    public static final String RANDOM_STRING_3 = "randomString3";
    public static final String RANDOM_STRING_4 = "randomString4";

    @Test
    void addAndGet() {
        var list = new ListImpl<String>();

        list.add(RANDOM_STRING_1);
        list.add(RANDOM_STRING_1);
        list.add(RANDOM_STRING_2);

        assertEquals(RANDOM_STRING_1, list.get(0));
        assertEquals(RANDOM_STRING_1, list.get(1));
        assertEquals(RANDOM_STRING_2, list.get(2));
    }

    @Test
    void size() {
        var list = new ListImpl<String>();

        assertEquals(0, list.size());

        list.add(RANDOM_STRING_1);
        list.add(RANDOM_STRING_1);

        assertEquals(2, list.size());

        list.add(RANDOM_STRING_2);

        assertEquals(3, list.size());
    }

    @Test
    void isEmpty() {
        var list = new ListImpl<String>();

        assertTrue(list.isEmpty());
    }

    @Test
    void contains() {
        var list = new ListImpl<String>();

        assertFalse(list.contains(RANDOM_STRING_1));

        list.add(RANDOM_STRING_1);
        list.add(RANDOM_STRING_2);

        assertTrue(list.contains(RANDOM_STRING_1));
        assertTrue(list.contains(RANDOM_STRING_2));
        assertFalse(list.contains(RANDOM_STRING_3));
    }

    @Test
    void containsAll() {
        var list = new ListImpl<String>();

        list.add(RANDOM_STRING_1);
        list.add(RANDOM_STRING_2);
        list.add(RANDOM_STRING_3);

        var listToBeCompared1 = new ListImpl<String>();
        listToBeCompared1.add(RANDOM_STRING_1);
        listToBeCompared1.add(RANDOM_STRING_2);

        assertTrue(list.containsAll(listToBeCompared1));

        var listToBeCompared2 = new ListImpl<String>();
        listToBeCompared2.add(RANDOM_STRING_3);
        listToBeCompared2.add(RANDOM_STRING_4);

        assertFalse(list.containsAll(listToBeCompared2));
    }

    @Test
    void addAll() {
        var list = new ListImpl<String>();

        var listToBeAdded1 = new ListImpl<String>();
        listToBeAdded1.add(RANDOM_STRING_1);

        list.addAll(listToBeAdded1);

        assertEquals(1, list.size());
        assertEquals(RANDOM_STRING_1, list.get(0));

        var listToBeAdded2 = new ListImpl<String>();
        listToBeAdded2.add(RANDOM_STRING_3);
        listToBeAdded2.add(RANDOM_STRING_4);

        list.addAll(listToBeAdded2);

        assertEquals(3, list.size());
        assertEquals(RANDOM_STRING_1, list.get(0));
        assertEquals(RANDOM_STRING_3, list.get(1));
        assertEquals(RANDOM_STRING_4, list.get(2));
    }

    @Test
    void set() {
        var list = new ListImpl<String>();

        //this does nothing

        list.add(RANDOM_STRING_1);
        list.add(RANDOM_STRING_2);

        list.set(1, RANDOM_STRING_3);

        assertEquals(2, list.size());
        assertEquals(RANDOM_STRING_1, list.get(0));
        assertEquals(RANDOM_STRING_3, list.get(1));
    }

    @Test
    void indexOf() {
        var list = new ListImpl<String>();
        list.add(RANDOM_STRING_1);
        list.add(RANDOM_STRING_1);
        list.add(RANDOM_STRING_2);

        assertEquals(0, list.indexOf(RANDOM_STRING_1));
        assertEquals(2, list.indexOf(RANDOM_STRING_2));
        assertEquals(-1, list.indexOf(RANDOM_STRING_3));
    }

    @Test
    void lastIndexOf() {
        var list = new ListImpl<String>();
        list.add(RANDOM_STRING_1);
        list.add(RANDOM_STRING_2);
        list.add(RANDOM_STRING_2);

        assertEquals(0, list.lastIndexOf(RANDOM_STRING_1));
        assertEquals(2, list.lastIndexOf(RANDOM_STRING_2));
        assertEquals(-1, list.lastIndexOf(RANDOM_STRING_3));
    }

    @Test
    void iterator() {
        var list = new ListImpl<String>();
        list.add(RANDOM_STRING_1);
        list.add(RANDOM_STRING_2);
        list.add(RANDOM_STRING_2);
        list.add(RANDOM_STRING_4);
        list.add(RANDOM_STRING_4);

        int currentIteration = 0;
        for (String string : list) {
            assertEquals(list.get(currentIteration), string);
            currentIteration++;
        }
    }

    @Test
    void get() {
        var list = new ListImpl<String>();
        list.add(RANDOM_STRING_1);
        list.add(RANDOM_STRING_2);
        list.add(RANDOM_STRING_3);

        assertEquals(0, list.indexOf(RANDOM_STRING_1));
        assertEquals(1, list.indexOf(RANDOM_STRING_2));
        assertEquals(2, list.indexOf(RANDOM_STRING_3));
    }

    @Test
    void add() {
        var list = new ListImpl<String>();
        list.add(RANDOM_STRING_1);
        list.add(RANDOM_STRING_2);
        list.add(RANDOM_STRING_3);

        list.add(1, RANDOM_STRING_3);
        assertEquals(RANDOM_STRING_3, list.get(1));
        assertEquals(RANDOM_STRING_2, list.get(2));
        assertEquals(RANDOM_STRING_3, list.get(3));
    }

    @Test
    void exceptionGetTest() {
        var list = new ListImpl<String>();
        list.add(RANDOM_STRING_1);
        list.add(RANDOM_STRING_2);
        list.add(RANDOM_STRING_3);

        assertThrows(InvalidIndexException.class, () -> list.get(4));

    }
}
