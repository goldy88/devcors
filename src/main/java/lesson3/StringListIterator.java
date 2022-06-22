package lesson3;

import java.util.Iterator;

public class StringListIterator implements Iterator<String> {

    private StringList stringList = null;
    private int currentIndex = 0;

    StringListIterator(StringList list) {
        this.stringList = list;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < stringList.size();
    }

    @Override
    public String next() {
        String element = stringList.get(currentIndex);
        currentIndex += 1;
        return element;
    }
}
