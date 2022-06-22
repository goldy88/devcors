package lesson3;

public interface StringList extends Iterable<String> {

    /**
     * @return size of list.
     */
    int size();

    /**
     * @return true if list is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * @return true in list contains string, false otherwise
     */
    boolean contains(String str);


    /**
     * Adds new string to list
     */
    void add(String str);

    /**
     * @return true in case this list contains all strings contained in stringList
     */
    boolean containsAll(StringList stringList);

    /**
     * Adds all strings from stringList to this list
     */
    void addAll(StringList stringList);

    /**
     * @return string from given index, throws exception if index is out of bounds.
     */
    String get(int index);

    /**
     * Sets string to given index.
     * <p>In case index does not exist yet (for example nothing was added to list), does nothing
     */
    void set(int index, String element);

    /**
     * Adds string to given index. All consecutive indexes are moved to index + 1 position.
     * <p>In case index does not exist yet (for example nothing was added to list), does nothing
     */
    void add(int index, String element);

    /**
     * @return first index of given string or -1 if this string is not in this list
     */
    int indexOf(String str);

    /**
     * @return last index of given string or -1 if this string is not in this list
     */
    int lastIndexOf(String str);

}
