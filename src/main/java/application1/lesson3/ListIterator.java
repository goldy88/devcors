package application1.lesson3;

import java.util.Iterator;

public class ListIterator<ElemType> implements Iterator<ElemType> {

    private final List<ElemType> list;
    private int currentIndex = 0;

    ListIterator(List<ElemType> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < list.size();
    }

    @Override
    public ElemType next() {
        ElemType element = list.get(currentIndex);
        currentIndex += 1;
        return element;
    }
}
