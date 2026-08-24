import java.lang.reflect.Array;
import java.util.NoSuchElementException;

class SimpleLinkedList<T> {
    private Element<T> root;

    class Element<T> {
        private T value;
        private Element<T> next;

        public Element(T element) {
            this.value = element;
        }

        public Element<T> next() {
            return this.next;
        }

        public void setNext(Element<T> next) {
            this.next = next;
        }
    }

    public SimpleLinkedList(T[] values) {
        Element currentElement = this.root = new Element<T>(values[0]);
        for (int i = 1; i < values.length; i++) {
            Element nextElement = new Element(values[i]);
            currentElement.setNext(nextElement);
            currentElement = nextElement;
        }
    }

    public SimpleLinkedList() {
    }

    public int size() {
        int counter = 0;
        Element currentElement = this.root;
        while (currentElement != null) {
            currentElement = currentElement.next();
            counter++;
        }
        return counter;
    }

    public T pop() {
        if (size() < 1) {
            throw new NoSuchElementException();
        }
        Element<T> currentElement = this.root;
        if (this.root.next() == null) {
            this.root = null;
            return currentElement.value;
        }
        Element<T> previousElement = null;
        while (currentElement != null) {
            if (currentElement.next() == null) {
                if (previousElement != null) {
                    previousElement.setNext(null);
                }
                return currentElement.value;
            } else {
                previousElement = currentElement;
                currentElement = currentElement.next();
            }
        }
        return null;
    }

    public void push(T element) {
        if (this.root == null) {
            this.root = new Element<>(element);
        } else {
            Element<T> currentElement = this.root;
            while (currentElement != null) {
                if (currentElement.next() == null) {
                    currentElement.setNext(new Element<>(element));
                    return;
                } else {
                    currentElement = currentElement.next();
                }
            }
        }
    }

    public void reverse() {
        if (size() <= 1) {
            return;
        }
        Element<T> previousElement = this.root;
        Element<T> currentElement = this.root.next();
        this.root.setNext(null);
        Element<T> nextElement;
        while (currentElement != null) {
            nextElement = currentElement.next();
            currentElement.setNext(previousElement);
            previousElement = currentElement;
            currentElement = nextElement;
        }
        this.root = previousElement;
    }

    public T[] asArray(Class<T> characterClass) {
        T[] objects = (T[]) Array.newInstance(characterClass, this.size());
        int index = 0;
        while(size() > 0) {
            objects[index] = pop();
            index++;
        }
        return objects;
    }

}
