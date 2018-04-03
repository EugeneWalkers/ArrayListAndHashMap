import javafx.util.Pair;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class CustomHashMap<K, V> implements Map<K, V> {
    int size;
    private HashElement<K, V>[] elements;
    CustomHashMap<K, V> next;

    public CustomHashMap(){
        size = 10;
        elements = new HashElement[size];
        for (int i=0; i<size; i++){
            elements[i] = null;
        }
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
    public boolean containsKey(Object key) {
        for (int i=0; i<size; i++){
            if (elements[i].getKey().equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (int i=0; i<size; i++){
            if (elements[i].getValue().equals(value)){
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        if (key != null){
            for (int i=0; i<size; i++){
                if (key.equals(elements[i].getKey())){
                    return elements[i].getValue();
                }
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int index = key.hashCode()%size;
        while(index != size && elements[index] != null){
            index++;
        }
        if (index != size){
            elements[index] = new HashElement<>(key, value);
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        V value = null;
        for (int i=0; i<size; i++){
            if (elements[i].getKey().equals(key)){
                value = elements[i].getValue();
                elements[i] = null;
            }
        }
        return value;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {
        size = 0;
        elements = new HashElement[size];
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
