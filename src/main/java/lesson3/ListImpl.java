package lesson3;

import java.util.Arrays;
import java.util.Iterator;

public class ListImpl <ElemType> implements List<ElemType> {
    private Object[] container = new Object[0];

    @Override
    public int size() {
        return this.container.length;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(ElemType element) {
        return Arrays.stream(container).toList().contains(element);
    }

    @Override
    public void add(ElemType element) {
        Object[] oldContainer = container.clone();
        container = new Object[this.size() + 1];
        System.arraycopy(oldContainer, 0, container, 0, oldContainer.length);
        container[oldContainer.length] = element;
    }

    @Override
    public boolean containsAll(List<ElemType> list) {
        for (ElemType e : list) {
            if (!this.contains(e)) return false;
        }
        return true;
    }

    @Override
    public void addAll(List<ElemType> list) {
        for (ElemType e : list) {
            this.add(e);
        }
    }

    @Override
    public ElemType get(int index) {
        if (index >= size()) {
            throw new InvalidIndexException("index out of range");
        }
        return (ElemType) this.container[index];
    }

    @Override
    public void set(int index, ElemType element) throws InvalidIndexException {
        if (index >= size() || element == null) {
            throw new InvalidIndexException("index out of range");
        }
        this.container[index] = element;
    }

    @Override
    public void add(int index, ElemType element) throws InvalidIndexException {
        int offset = 0;

        if ((index > this.size()) || (index < 0)) {
            throw new InvalidIndexException("index value '" + index + "' out of range");
        }

        Object[] oldArray = container.clone();
        container = new String[this.size() + 1];

        for (int i = 0; i < container.length; i++) {
            if (i == index) {
                container[i] = element;
                offset = 1;
            } else {
                container[i] = oldArray[i - offset];
            }
        }
    }

    @Override
    public int indexOf(ElemType element) {
        return Arrays.stream(container).toList().indexOf(element);
    }

    @Override
    public int lastIndexOf(ElemType element) {
        return Arrays.stream(container).toList().lastIndexOf(element);
    }

    @Override
    public Iterator<ElemType> iterator() {
        //return Arrays.asList(this.stringArray).iterator();
        return new ListIterator<>(this);
    }
}


