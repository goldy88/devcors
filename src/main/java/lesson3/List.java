package lesson3;

public interface List<ElemType> extends Iterable<ElemType> {

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
    boolean contains(ElemType element);

    /**
     * Adds new string to list
     */
    void add(ElemType element);

    /**
     * @return true in case this list contains all strings contained in stringList
     */
    boolean containsAll(List<ElemType> list);

    /**
     * Adds all strings from stringList to this list
     */
    void addAll(List<ElemType>  list);

    /**
     * @return string from given index, throws exception if index is out of bounds.
     */
    ElemType get(int index);

    /**
     * Sets string to given index.
     * <p>In case index does not exist yet (for example nothing was added to list), does nothing
     */
    void set(int index, ElemType element);

    /**
     * Adds string to given index. All consecutive indexes are moved to index + 1 position.
     * <p>In case index does not exist yet (for example nothing was added to list), does nothing
     */
    void add(int index, ElemType element);

    /**
     * @return first index of given string or -1 if this string is not in this list
     */
    int indexOf(ElemType element);

    /**
     * @return last index of given string or -1 if this string is not in this list
     */
    int lastIndexOf(ElemType element);

}
