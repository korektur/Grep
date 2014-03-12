package ru.ifmo.ctddev.Akhundov.task2;

import java.util.*;

public class ArraySet<E> extends AbstractSet<E> implements NavigableSet<E> {
    protected final Comparator<? super E> comparator;
    protected final List<E> array;
    protected boolean defaultComparator;

    public ArraySet() {
        comparator = null;
        array = new ArrayList<>();
    }

    public ArraySet(Collection<E> collection, Comparator<? super E> comparator) {
        List<E> tmp = new ArrayList<>(collection);
        this.comparator = comparator;
        Collections.sort(tmp, comparator);
        List<E> uniqueSet = new ArrayList<>();
        if (tmp.size() > 0) {
            uniqueSet.add(tmp.get(0));
        }
        for (int i = 1; i < tmp.size(); ++i) {
            if (comparator.compare(uniqueSet.get(uniqueSet.size() - 1), tmp.get(i)) != 0) {
                uniqueSet.add(tmp.get(i));
            }
        }
        array = new ArrayList<>(uniqueSet);
        defaultComparator = false;
    }

    protected ArraySet(List<E> collection, Comparator<? super E> comparator, boolean defaultComparator) {
        this.array = collection;
        this.comparator = comparator;
        this.defaultComparator = defaultComparator;
    }

    public ArraySet(Collection<E> c) {
        this(c, new Comparator<E>() {
            @Override
            @SuppressWarnings("unchecked")
            public int compare(E o1, E o2) {
                return ((Comparable<? super E>) o1).compareTo(o2);
            }
        });
        defaultComparator = true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean contains(Object o) {
        return Collections.binarySearch(array, (E)o, comparator) >= 0;
    }


    @Override
    public E lower(E e) {
        int index = Collections.binarySearch(array, e, comparator);
        if (index < 0) {
            index = -index - 1;
        }
        return index == 0 ? null : array.get(index - 1);
    }

    @Override
    public E floor(E e) {
        int index = Collections.binarySearch(array, e, comparator);
        if (index >= 0) {
            return array.get(index);
        }
        index = -index - 1;
        return index == 0 ? null : array.get(index - 1);
    }

    @Override
    public E ceiling(E e) {
        int index = Collections.binarySearch(array, e, comparator);
        if (index >= 0) {
            return array.get(index);
        }
        index = -index - 1;
        return index == array.size() ? null : array.get(index);
    }

    @Override
    public E higher(E e) {
        int index = Collections.binarySearch(array, e, comparator);
        if (index >= 0) {
            return index == array.size() - 1 ? null : array.get(index + 1);
        }
        index = -index - 1;
        return index == array.size() ? null : array.get(index);
    }

    @Override
    public E pollFirst() {
        throw new UnsupportedOperationException("pollFirst is not supported");
    }

    @Override
    public E pollLast() {
        throw new UnsupportedOperationException("pollLast is not supported");
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Iterator<E> it = array.iterator();

            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public E next() {
                return it.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("remove is not supported");
            }
        };
    }

    @Override
    public NavigableSet<E> descendingSet() {
        return new ArraySet<>(array, Collections.reverseOrder(comparator));
    }

    @Override
    public Iterator<E> descendingIterator() {
        return descendingSet().iterator();
    }

    @Override
    public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
        return tailSet(fromElement, fromInclusive).headSet(toElement, toInclusive);
    }

    @Override
    public NavigableSet<E> headSet(E toElement, boolean inclusive) {
        int index = Collections.binarySearch(array, toElement, comparator);
        if (inclusive && index >= 0) {
            ++index;
        }
        if (index < 0) {
            index = -index - 1;
        }
        return new ArraySet<E>(array.subList(0, index), comparator, defaultComparator);
    }

    @Override
    public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
        int index = Collections.binarySearch(array, fromElement, comparator);
        if (!inclusive && index >= 0) {
            ++index;
        }
        if (index < 0) {
            index = -index - 1;
        }
        return new ArraySet<E>(array.subList(index, array.size()), comparator, defaultComparator);
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public Comparator<? super E> comparator() {
        return defaultComparator ? null : comparator;
    }

    @Override
    public SortedSet<E> subSet(E fromElement, E toElement) {
        return tailSet(fromElement).headSet(toElement);
    }

    @Override
    public SortedSet<E> headSet(E toElement) {
        return headSet(toElement, false);
    }

    @Override
    public SortedSet<E> tailSet(E fromElement) {
        return tailSet(fromElement, true);
    }

    @Override
    public E first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return array.get(0);
    }

    @Override
    public E last() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return array.get(size() - 1);
    }
}
