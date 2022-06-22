package lesson3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringListImplTest {

    public static final String RANDOM_STRING_1 = "randomString1";
    public static final String RANDOM_STRING_2 = "randomString2";
    public static final String RANDOM_STRING_3 = "randomString3";
    public static final String RANDOM_STRING_4 = "randomString4";

    @Test
    void addAndGet() {
        StringList stringList = new StringListImpl();

        stringList.add(RANDOM_STRING_1);
        stringList.add(RANDOM_STRING_1);
        stringList.add(RANDOM_STRING_2);

        assertEquals(RANDOM_STRING_1, stringList.get(0));
        assertEquals(RANDOM_STRING_1, stringList.get(1));
        assertEquals(RANDOM_STRING_2, stringList.get(2));
    }


    @Test
    void size() {
        StringList stringList = new StringListImpl();

        assertEquals(0, stringList.size());

        stringList.add(RANDOM_STRING_1);
        stringList.add(RANDOM_STRING_1);

        assertEquals(2, stringList.size());

        stringList.add(RANDOM_STRING_2);

        assertEquals(3, stringList.size());
    }

    @Test
    void isEmpty() {
        StringList stringList = new StringListImpl();

        assertTrue(stringList.isEmpty());
    }

    @Test
    void contains() {
        StringList stringList = new StringListImpl();

        assertFalse(stringList.contains(RANDOM_STRING_1));

        stringList.add(RANDOM_STRING_1);
        stringList.add(RANDOM_STRING_2);

        assertTrue(stringList.contains(RANDOM_STRING_1));
        assertTrue(stringList.contains(RANDOM_STRING_2));
        assertFalse(stringList.contains(RANDOM_STRING_3));
    }

    @Test
    void containsAll() {
        StringList stringList = new StringListImpl();

        stringList.add(RANDOM_STRING_1);
        stringList.add(RANDOM_STRING_2);
        stringList.add(RANDOM_STRING_3);

        StringList stringListToBeCompared1 = new StringListImpl();
        stringListToBeCompared1.add(RANDOM_STRING_1);
        stringListToBeCompared1.add(RANDOM_STRING_2);

        assertTrue(stringList.containsAll(stringListToBeCompared1));

        StringList stringListToBeCompared2 = new StringListImpl();
        stringListToBeCompared2.add(RANDOM_STRING_3);
        stringListToBeCompared2.add(RANDOM_STRING_4);

        assertFalse(stringList.containsAll(stringListToBeCompared2));
    }

    @Test
    void addAll() {
        StringList stringList = new StringListImpl();

        StringList stringListToBeAdded1 = new StringListImpl();
        stringListToBeAdded1.add(RANDOM_STRING_1);

        stringList.addAll(stringListToBeAdded1);

        assertEquals(1, stringList.size());
        assertEquals(RANDOM_STRING_1, stringList.get(0));

        StringList stringListToBeAdded2 = new StringListImpl();
        stringListToBeAdded2.add(RANDOM_STRING_3);
        stringListToBeAdded2.add(RANDOM_STRING_4);

        stringList.addAll(stringListToBeAdded2);

        assertEquals(3, stringList.size());
        assertEquals(RANDOM_STRING_1, stringList.get(0));
        assertEquals(RANDOM_STRING_3, stringList.get(1));
        assertEquals(RANDOM_STRING_4, stringList.get(2));
    }

    @Test
    void set() {
        StringList stringList = new StringListImpl();

        //this does nothing
        stringList.set(0, RANDOM_STRING_4);

        stringList.add(RANDOM_STRING_1);
        stringList.add(RANDOM_STRING_2);

        stringList.set(1, RANDOM_STRING_3);

        assertEquals(2, stringList.size());
        assertEquals(RANDOM_STRING_1, stringList.get(0));
        assertEquals(RANDOM_STRING_3, stringList.get(1));
    }

    @Test
    void indexOf() {
        StringList stringList = new StringListImpl();
        stringList.add(RANDOM_STRING_1);
        stringList.add(RANDOM_STRING_1);
        stringList.add(RANDOM_STRING_2);

        assertEquals(0, stringList.indexOf(RANDOM_STRING_1));
        assertEquals(2, stringList.indexOf(RANDOM_STRING_2));
        assertEquals(-1, stringList.indexOf(RANDOM_STRING_3));
    }

    @Test
    void lastIndexOf() {
        StringList stringList = new StringListImpl();
        stringList.add(RANDOM_STRING_1);
        stringList.add(RANDOM_STRING_2);
        stringList.add(RANDOM_STRING_2);

        assertEquals(0, stringList.lastIndexOf(RANDOM_STRING_1));
        assertEquals(2, stringList.lastIndexOf(RANDOM_STRING_2));
        assertEquals(-1, stringList.lastIndexOf(RANDOM_STRING_3));
    }

    @Test
    void iterator() {
        StringList stringList = new StringListImpl();
        stringList.add(RANDOM_STRING_1);
        stringList.add(RANDOM_STRING_2);
        stringList.add(RANDOM_STRING_2);
        stringList.add(RANDOM_STRING_4);
        stringList.add(RANDOM_STRING_4);

        int currentIteration = 0;
        for (String string : stringList) {
            assertEquals(stringList.get(currentIteration), string);
            currentIteration++;
        }
    }

    @Test
    void get() {
        StringList stringList = new StringListImpl();
        stringList.add(RANDOM_STRING_1);
        stringList.add(RANDOM_STRING_2);
        stringList.add(RANDOM_STRING_3);

        assertEquals(0, stringList.indexOf(RANDOM_STRING_1));
        assertEquals(1, stringList.indexOf(RANDOM_STRING_2));
        assertEquals(2,stringList.indexOf(RANDOM_STRING_3));

    }

    @Test
    void add() {
        StringList stringList = new StringListImpl();
        stringList.add(RANDOM_STRING_1);
        stringList.add(RANDOM_STRING_2);
        stringList.add(RANDOM_STRING_3);

        stringList.add(1, RANDOM_STRING_3);
        assertEquals(RANDOM_STRING_3, stringList.get(1));
        assertEquals(RANDOM_STRING_2, stringList.get(2));
        assertEquals(RANDOM_STRING_3, stringList.get(3));
    }
}
