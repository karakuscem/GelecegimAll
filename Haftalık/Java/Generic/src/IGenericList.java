public interface IGenericList<T> {
    int size();

    int getCapacity();

    void add(T data);

    T get(int index);

    Integer remove(int index);

    Integer set(int index, T data);

    String toString();

    int indexOf(T data);

    int lastIndexOf(T data);

    boolean isEmpty();

    T[] toArray();

    void clear();

    GenericList<T> sublist(int start, int finish);

    boolean contains(T data);
}
