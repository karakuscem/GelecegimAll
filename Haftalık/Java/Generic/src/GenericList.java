import java.lang.reflect.Array;
import java.util.Arrays;

public class GenericList<T> implements IGenericList<T> {
    T[] arr;

    private int size;

    private int capacity;

    public GenericList(){
        this.capacity = 10;
        this.arr = (T[]) new Object[capacity];
    }

    public GenericList(int capacity) {
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public void add(T data) {
        if (size == capacity) {
            capacity *= 2;
            T[] newArr = (T[]) new Object[capacity];
            System.arraycopy(newArr, 0, arr, 0, arr.length);
            arr = newArr;
        }
        arr[size++] = data;
    }

    @Override
    public T get(int index) {
        return index < 0 || index >= size ? null : arr[index];
    }

    @Override
    public Integer remove(int index) {
        if (index < 0 || index >= size)
            return null;
        else
        {
            int i = index + 1;
            arr[index] = null;
            while (arr[i] != null)
            {
                arr[i - 1] = arr[i];
                arr[i] = null;
            }
            size -= 1;
            if (capacity / 2 > size)
            {
                capacity /= 2;
                T[] newArr = (T[]) new Object[capacity];
                System.arraycopy(arr, 0, newArr, 0, size);
                arr = newArr;
            }
        }
        return 0;
    }

    @Override
    public Integer set(int index, T data) {
        if (index < 0 || index >= size)
            return null;
        else
            arr[index] = data;
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++)
        {
            sb.append(arr[i]);
            if (i != size - 1)
                sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int indexOf(T data) {
        for (int i = 0; i < size; i++)
            if (data.equals(arr[i]))
                return i;
        return -1;
    }

    @Override
    public int lastIndexOf(T data) {
        int lastIndex = -1;
        for (int i = 0; i < size; i++)
            if (data.equals(arr[i]))
                lastIndex = i;
        return lastIndex;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T[] toArray() {
        return (T[])Arrays.copyOf(arr, size);
    }

    @Override
    public void clear() {
        capacity = 10;
        size = 0;
        arr = (T[]) new Object[capacity];
    }

    @Override
    public GenericList<T> sublist(int start, int finish) {
        if (start < 0 || finish >= size || start > finish)
            return null;
        else
        {
            GenericList<T> sub = new GenericList<>(finish - start + 1);
            for (int i = start; i <= finish; i++)
                sub.add(arr[i]);
            return sub;
        }
    }

    @Override
    public boolean contains(T data) {
        for (T val : arr)
            if (data.equals(val))
                return true;
        return false;
    }
}
