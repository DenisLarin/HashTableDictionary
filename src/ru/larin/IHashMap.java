package ru.larin;

/**
 * Created by denis__larin on 13.04.17.
 */
public interface IHashMap<K,V> {
    public boolean put(K key, V value);
    public V get(K key);
    public int size();
    public boolean remove(K key);
}
