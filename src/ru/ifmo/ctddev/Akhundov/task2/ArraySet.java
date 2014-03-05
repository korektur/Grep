package ru.ifmo.ctddev.Akhundov.task2;

import java.util.*;

public class ArraySet<E> implements NavigableSet<E> {
    private final Comparator<? super E> comparator;
    private final ArrayList<E> array;
    private boolean defaultComparator;

    public ArraySet() {
        comparator = null;
        array = new ArrayList<>();
    }

    public ArraySet(Collection<E> collection, Comparator<? super E> comparator) {
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

    private ArraySet(Collection<E> collection, Comparator<? super E> comparator, boolean defaultComparator) {
        this.array = new ArrayList<>(collection);
        this.comparator = comparator;
        this.defaultComparator = defaultComparator;
    }

    @SuppressWarnings("unchecked")
    public ArraySet(Collection<E> c) {
        this(c, new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                return ((Comparable<? super E>) o1).compareTo(o2);
            }
        });
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

    @SuppressWarnings("unchecked")
    @Override
    public Iterator<E> iterator() {
        return new IteratorImpl();
    }

    @Override
    public NavigableSet<E> descendingSet() {
        return new ArraySet<>(array, Collections.reverseOrder(comparator), defaultComparator);
    }

    @Override
    public Iterator<E> descendingIterator() {
        return descendingSet().iterator();
    }

    @Override
    public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
        return tailSet(fromElement, fromInclusive).headSet(toElement, toInclusive);
    }

    @SuppressWarnings("unchecked")
    @Override
    public NavigableSet<E> headSet(E toElement, boolean inclusive) {
        int index = Collections.binarySearch(array, toElement, comparator);
        if (inclusive && index >= 0) {
            ++index;
        }
        if (index < 0) {
            index = -index - 1;
        }
        return (NavigableSet)new ArraySet<E>(array.subList(0, index), comparator, defaultComparator);
    }

    @SuppressWarnings("unchecked")
    @Override
    public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
        int index = Collections.binarySearch(array, fromElement, comparator);
        if (!inclusive && index >= 0) {
            ++index;
        }
        if (index < 0) {
            index = -index - 1;
        }
        return (NavigableSet)new ArraySet<E>(array.subList(index, array.size()), comparator, defaultComparator);
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

    @SuppressWarnings("unchecked")
    @Override
    public SortedSet<E> headSet(E toElement) {
        return headSet(toElement, false);
    }

    @SuppressWarnings("unchecked")
    @Override
    public SortedSet<E> tailSet(E fromElement) {
        return (SortedSet)tailSet(fromElement, true);
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
