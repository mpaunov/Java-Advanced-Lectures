package dataStructuresWorkshop;

import java.util.Iterator;

public class SmartArray<E> implements Iterable<E> {
    private Object[] data;
    private int size;

    public SmartArray() {
        this.data = new Object[4];
        this.size = 0;
    }

    private class SmartArrayIterator implements Iterator<E> {
        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public E next() {
            E element = get(i);
            i++;
            return element;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new SmartArrayIterator();
    }

    public void add(E element) {
        if (this.size == this.data.length) {
            this.data = grow();
        }

        this.data[size] = element;
        this.size++;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        validateIndex(index);

        return (E)this.data[index];
    }

    public int size() {
        return this.size;
    }

    public E remove(int index) {
        validateIndex(index);
        this.size--;
        E element = get(index);

        if (this.size - index >= 0) {
            System.arraycopy(this.data, index + 1, this.data, index, this.size - index);
        }

        this.data[this.size] = 0;

        if (this.data.length / 4 >= this.size || this.data.length / 4 == 4) {
            this.data = shrink();
        }

        return element;
    }

    public boolean contains(int element) {

        for (int i = 0; i < this.size; i++) {
            if (this.data[i].equals(element)) {
                return true;
            }
        }

        return false;
    }

    public void add(int index, E element) {
        validateIndex(index);

        int lastIndex = this.size - 1;
        E lastElement = get(lastIndex);

        if (lastIndex - index >= 0) {
            System.arraycopy(this.data, index, this.data, index + 1, lastIndex - index);
        }

        this.data[index] = element;

        add(lastElement);
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }
    }

    private Object[] grow() {
        Object[] newData = new Object[this.data.length * 2];

        System.arraycopy(this.data, 0, newData, 0, this.data.length);

        return newData;
    }

    private Object[] shrink() {
        Object[] newData = new Object[this.data.length / 2];

        System.arraycopy(this.data, 0, newData, 0, this.size);

        return newData;
    }

}
