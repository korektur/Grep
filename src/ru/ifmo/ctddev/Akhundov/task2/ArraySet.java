package ru.ifmo.ctddev.Akhundov.task2;

import java.util.*;

public class ArraySet<E> implements NavigableSet<E> {
    private final Comparator<? super E> comparator;
    private final ArrayList<E> array;
    private boolean defaultComparator;

    public ArraySet(Comparator<? super E> comparator, Collection<E> collection) {
        ArrayList<E> tmp = new ArrayList<>(collection);
        this.comparator = comparator;
        Collections.sort(tmp, comparator);
        ArrayList<E> uniqueSet = new ArrayList<>();
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

    public ArraySet(Collection<E> c) {
        this(new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                return ((Comparable<? super E>) o1).compareTo(o2);
            }
        }, c);
        defaultComparator = true;
    }

    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException("add is not supported");
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("addAll is not supported");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("clear is not supported");
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean contains(Object o) {
        return Collections.binarySearch(array, (E) o, comparator) >= 0;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator<?> it = c.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    private class IteratorImpl implements Iterator {
        private int index;

        public IteratorImpl() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < array.size();
        }

        @Override
        public E next() {
            if (hasNext()) {
                ++index;
                return array.get(index - 1);
            }
            throw new NoSuchElementException("iteration has no more elements");
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove is not supported");
        }

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
        if (index < 0) {
            index = -index - 1;
        }
        if (isEmpty() || (index == 0 && comparator.compare(array.get(0), e) != 0)) {
            return null;
        }
        if (index < array.size() && comparator.compare(array.get(index), e) <= 0) {
            return array.get(index);
        }
        return array.get(index - 1);
    }

    @Override
    public E ceiling(E e) {
        int index = Collections.binarySearch(array, e, comparator);
        if (index < 0) {
            index = -index - 1;
        }
        if (isEmpty() || index == array.size() ||
                (index == array.size() - 1 && comparator.compare(e, array.get(index)) != 0)) {
            return null;
        }
        if (index < array.size() && comparator.compare(e, array.get(index)) <= 0) {
            return array.get(index);
        }
        return array.get(index + 1);
    }

    @Override
    public E higher(E e) {
        int index = Collections.binarySearch(array, e, comparator);
        if (index < 0) {
            index = -index - 1;
        }
        if (index == array.size() || (index == array.size() - 1 && comparator.compare(e, array.get(index)) >= 0)) {
            return null;
        }
        if (comparator.compare(e, array.get(index)) < 0) {
            return array.get(index);
        }
        return array.get(index + 1);
    }

    @Override
    public E pollFirst() {
        throw new UnsupportedOperationException("pollFirst is not supported");
    }

    @Override
    public E pollLast() {
        throw new UnsupportedOperationException("pollLast is not supported");
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterator<E> iterator() {
        return new IteratorImpl();
    }

    @Override
    public NavigableSet<E> descendingSet() {
        return new ArraySet<>(Collections.reverseOrder(comparator), array);
    }

    @Override
    public Iterator<E> descendingIterator() {
        return descendingSet().iterator();
    }

    @Override
    public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
        return null;
    }

    @Override
    public NavigableSet<E> headSet(E toElement, boolean inclusive) {
        return null;
    }

    @Override
    public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ArraySet) {
            ArraySet set = (ArraySet) o;
            if (set.size() != size()) {
                return false;
            }
            Iterator it1 = set.iterator();
            Iterator it2 = iterator();
            while (it1.hasNext()) {
                if (!it1.next().equals(it2.next())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        for (E e : array) {
            hashCode += e.hashCode();
        }
        return hashCode;
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("remove is not supported");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("removeAll is not supported");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("retainAll is not supported");
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public Object[] toArray() {
        return array.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return array.toArray(a);
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
        int index = Collections.binarySearch(array, toElement, comparator);
        if (index < 0) {
            index = -index - 1;
        }
        return new ArraySet<>(comparator, array.subList(0, index));
    }

    @Override
    public SortedSet<E> tailSet(E fromElement) {
        int index = Collections.binarySearch(array, fromElement, comparator);
        if (index >= size()) {
            return new ArraySet<>(comparator, new ArrayList<E>());
        }
        if (index < 0) {
            index = -index - 1;
        }
        index = Math.max(index, 0);
        return new ArraySet<>(comparator, array.subList(index, size()));
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
