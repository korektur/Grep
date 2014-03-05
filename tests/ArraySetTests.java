import org.junit.Before;
import org.junit.Test;
import ru.ifmo.ctddev.Akhundov.task2.ArraySet;

import java.lang.reflect.Array;
import java.util.*;

import static junit.framework.Assert.assertEquals;

public class ArraySetTests {
    NavigableSet<Integer> set;

    @Before
    public void start() {
        Integer[] a = {5, 4, 1, 2, 3, 9, 6, 7, 8, 8, 8, 2};
        Collection<Integer> collection = Arrays.asList(a);
        set = new ArraySet<>(collection);
    }

    @Test
    public void testSize() {
        assertEquals(9, set.size());
    }

    @Test
    public void containsTest() {
        assertEquals(true, set.contains(1));
        assertEquals(false, set.contains(0));
        try {
            assertEquals(true, set.contains(new ArrayList<>()));
            assertEquals(false, true);
        } catch (ClassCastException e) {
        }
    }

    @Test
    public void containsAllTest() {
        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertEquals(true, set.containsAll(Arrays.asList(a)));
        List<Integer> c = new ArrayList<>(Arrays.asList(a));
        c.add(10);
        assertEquals(false, set.containsAll(c));
    }

    @Test
    public void equalsTest() {
        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArraySet<Integer> set1 = new ArraySet<>(Arrays.asList(a));
        assertEquals(true, set.equals(set1));
    }

    @Test
    public void headSetTest() {
        SortedSet<Integer> a = set.headSet(7);
        Integer[] x = {1, 2, 3, 4, 5, 6};
        NavigableSet<Integer> set1 = new ArraySet<>(Arrays.asList(x));
        assertEquals(true, a.equals(set1));
    }

    @Test
    public void tailSet() {
        SortedSet<Integer> a = set.tailSet(5);
        Integer[] x = {5, 6, 7, 8, 9};
        NavigableSet<Integer> set1 = new ArraySet<>(Arrays.asList(x));
        assertEquals(true, a.equals(set1));
    }

    @Test
    public void subSetTest() {
        SortedSet<Integer> a = set.subSet(5, 5);
        assertEquals(true, a.isEmpty());
        a = set.subSet(2, 8);
        Integer[] x = {2, 3, 4, 5, 6, 7};
        ArraySet<Integer> set1 = new ArraySet<>(Arrays.asList(x));
        assertEquals(true, a.equals(set1));
        a = set.subSet(-1, 10);
        assertEquals(true, a.equals(set));
        a = set.subSet(1, 10);
        assertEquals(true, a.equals(set));
    }

    @Test
    public void lowerTest() {
        Integer a = set.lower(1);
        assertEquals(true, a == null);
        int b = set.lower(5);
        assertEquals(4, b);
        b = set.lower(10);
        assertEquals(9, b);
        NavigableSet<Integer> s = new ArraySet<>(new ArrayList<Integer>());
        a = s.lower(10);
        assertEquals(null, a);
    }

    @Test
    public void floorTest() {
        Integer a = set.floor(0);
        assertEquals(true, a == null);
        int b = set.floor(5);
        assertEquals(5, b);
        b = set.floor(10);
        assertEquals(9, b);
        NavigableSet<Integer> s = new ArraySet<>(new ArrayList<Integer>());
        a = s.floor(10);
        assertEquals(null, a);
    }

    @Test
    public void ceilingTest() {
        Integer a = set.ceiling(10);
        assertEquals(true, a == null);
        int b = set.ceiling(5);
        assertEquals(5, b);
        b = set.ceiling(0);
        assertEquals(1, b);
        NavigableSet<Integer> s = new ArraySet<>(new ArrayList<Integer>());
        a = s.ceiling(10);
        assertEquals(null, a);
    }

    @Test
    public void higherTest() {
        Integer a = set.higher(9);
        assertEquals(true, a == null);
        int b = set.higher(5);
        assertEquals(6, b);
        b = set.higher(0);
        assertEquals(1, b);
        NavigableSet<Integer> s = new ArraySet<>(new ArrayList<Integer>());
        a = s.lower(10);
        assertEquals(null, a);
    }

    @Test
    public void descendingSetTest() {
        NavigableSet<Integer> a = set.descendingSet();
        Iterator<Integer> it = a.iterator();
        it.next();
        it.next();
        assertEquals(7, (int)it.next());
    }

    public void descendingIteratorTest() {
        Iterator<Integer> it = set.descendingIterator();
        it.next();
        it.next();
        assertEquals(7, (int)it.next());
    }
}
