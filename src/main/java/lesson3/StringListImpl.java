package lesson3;

import java.util.Arrays;
import java.util.Iterator;

public class StringListImpl implements StringList {
    private String[] stringArray = new String[0];

    @Override
    public int size() {
        return this.stringArray.length;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(String str) {
        return Arrays.stream(stringArray).toList().contains(str);
    }

    @Override
    public void add(String str) {
        String[] oldArray = stringArray.clone();
        stringArray = new String[this.size() + 1];
        System.arraycopy(oldArray, 0, stringArray, 0, oldArray.length);
        stringArray[oldArray.length] = str;
    }

    @Override
    public boolean containsAll(StringList stringList) {
        for (String s : stringList) {
            if (!this.contains(s)) return false;
        }
        return true;
    }

    @Override
    public void addAll(StringList stringList) {
        for (String s : stringList) {
            this.add(s);
        }
    }

    @Override
    public String get(int index) {
        return index >= size() ? null : this.stringArray[index];
    }

    @Override
    public void set(int index, String element) {
        if (index >= size() || element == null) {
            return;
        }

        this.stringArray[index] = element;
    }

    @Override
    public void add(int index, String element) {
//        var list = new ArrayList<String>(Arrays.asList(this.stringArray));
//        list.add(index, element);
//        this.stringArray = list.toArray(this.stringArray);

        int offset = 0;

        String[] oldArray = stringArray.clone();
        stringArray = new String[this.size() + 1];

        for (int i = 0; i < stringArray.length; i++) {
            if (i == index) {
                stringArray[i] = element;
                offset = 1;
            } else {
                stringArray[i] = oldArray[i - offset];
            }
        }
    }

    @Override
    public int indexOf(String str) {
        return Arrays.stream(stringArray).toList().indexOf(str);
    }


    @Override
    public int lastIndexOf(String str) {
        return Arrays.stream(stringArray).toList().lastIndexOf(str);
    }

    @Override
    public Iterator<String> iterator() {
        //return Arrays.asList(this.stringArray).iterator();
        return new StringListIterator(this);
    }
}

