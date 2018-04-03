import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CustomArrayList<T> implements List<T> {

    private T[] customArrayList;
    private int capacity;
    private int size;

    CustomArrayList(){
        capacity = 2;
        customArrayList = (T[]) new Object[capacity];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return customArrayList.clone();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        if (size < capacity){
            customArrayList[size] = t;
        }
        else{
            capacity*=2;
            T[] temp = customArrayList.clone();
            customArrayList = (T[]) new Object[capacity];
            customArrayList[size] = t;
            for (int i=0; i<size; i++){
                customArrayList[i] = temp[i];
            }
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int k = -1;
        for (int i=0; i<size; i++){
            if (customArrayList[i].equals(o)){
                k = i;
                break;
            }
        }
        System.arraycopy(customArrayList, k+1, customArrayList, k, size - k);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T element: c){
            add(element);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        for (T element: c){
            add(index++, element);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for (int i=0; i<size; i++){
            customArrayList[i] = null;
        }
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index < size){
            return customArrayList[index];
        }
        else{
            throw new ArrayIndexOutOfBoundsException("lol");
        }
    }

    @Override
    public T set(int index, T element) {
        customArrayList[index] = element;
        return element;
    }

    @Override
    public void add(int index, T element) {
        for (int i=index+1; i<capacity; i++){

        }
    }

    @Override
    public T remove(int index) {
        if (index > size - 1){
            throw new IndexOutOfBoundsException();
        }
        T element = customArrayList[index];
        for (int i=index+1; i<capacity; i++){
            customArrayList[i] = customArrayList[i+1];
        }
        return element;
    }

    @Override
    public int indexOf(Object o) {
        for (int i=0; i<size; i++){
            if (customArrayList.equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
