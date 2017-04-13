package ru.larin;
import java.util.ArrayList;

/**
 * Created by denis__larin on 13.04.17.
 */
public class HashMap<K,V> extends HashGenerate<K> implements IHashMap<K,V> {

    public static final int NUMBER = 10000000;
    private ArrayList<Node<K,V>>[] arrayList;
    /*количество элементов*/
    private int size;

    public HashMap() {
        arrayList = new ArrayList[NUMBER];
        this.size = 0;
    }



    /*Добавить элемент по ключу и занчению*/
    @Override
    public boolean put(K key, V value) {
        if(key instanceof String){
            key = (K) ((String) key).toLowerCase();
        }
        int hashCode = getHashCode(key);
        int hashPosition;
        try{
            hashPosition = arrayList[hashCode].size();
        }
        catch (Exception e){
            arrayList[hashCode] = new ArrayList<Node<K,V>>();
            hashPosition = 0;
        }
        for (int i = 0; i < hashPosition; i++) {
            if(arrayList[hashCode].get(i).getKey() == key){
                arrayList[hashCode].set(i,new Node<K, V>(key,value));
                return false;
            }
        }
        arrayList[hashCode].add(new Node<K, V>(key,value));
        size++;
        return true;
    }

    /*Взять элемент с определенным ключем*/
    @Override
    public V get(K key) {
        if(key instanceof String){
            key = (K) ((String) key).toLowerCase();
        }
        int hashCode = getHashCode(key);
        int hashPosition;
        try{
            hashPosition = arrayList[hashCode].size();
        }
        catch (Exception e){
            return null;
        }
        for (int i = 0; i < hashPosition; i++) {
            if(arrayList[hashCode].get(i).getKey().equals(key)){
                return arrayList[hashCode].get(i).getValue();
            }
        }
        return null;
    }


    /*Взять количество элементов в Хэш таблице*/
    @Override
    public int size() {
        return size;
    }


    /*удалить элемент возвращает 1 если успешно, 0 если неудачно*/
    @Override
    public boolean remove(K key) {
        int hashcode = getHashCode(key);
        int hashPosition;
        try {
            hashPosition = arrayList[hashcode].size();
        }
        catch (Exception e){
            return false;
        }
        for (int i = 0; i < hashPosition; i++) {
            if(arrayList[hashcode].get(i).getKey().equals(key)){
                arrayList[hashcode].remove(i);
                size--;
                return true;
            }
        }
        return false;
    }
}



class Node<K,V>{
    private final K key;
    private final V value;
    private boolean deleted;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.deleted = false;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public boolean isDeleted(){
        return this.deleted;
    }

    public boolean deliteNode(){
        if(!this.deleted){
            this.deleted = true;
            return true;
        }
        return false;
    }
}

class HashGenerate<K>{
    public int getHashCode(K object){
        return object.hashCode()/100;
    }
}