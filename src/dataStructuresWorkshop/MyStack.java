package dataStructuresWorkshop;

import java.util.Iterator;

public class MyStack<E> implements Iterable<E> {

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = top;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E element = current.element;
                current = current.prev;
                return element;
            }
        };
    }

    private static class Node<T> {
        private T element;
        private Node<T> prev;

        public Node(T element, Node prev) {
            this.element = element;
            this.prev = prev;
        }
    }

    private Node<E> top;
    private int size;

    public MyStack() {
    }

    public void push(E element) {
        Node<E> newNode = new Node<>(element, this.top);
        this.top = newNode;
        this.size++;
    }

    public E pop() {
        ensureNotEmpty();
        E element = this.top.element;
        this.top = this.top.prev;
        this.size--;
        return element;
    }

    public E peek() {
        ensureNotEmpty();
        return this.top.element;
    }

    public int size() {
        return this.size;
    }

    private void ensureNotEmpty() {
        if (this.top == null) {
            throw new IllegalStateException("Cannot execute on empty stack.");
        }
    }
}
