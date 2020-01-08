package main.pre;

import java.util.Iterator;

interface IMap <K,V>{
    //清除所有键值对
    void clear();
    //key是否已经存在
    boolean containsKey(K key);
    //value是否存在
    boolean containsValue(V value);
    //根据key获得value
    V get(K key);
    //map是否为空
    boolean isEmpty();
    //所有key组成的数组
    MyHashSet<K> keySet();
    //所有value组成的数组
    V[] values();
    //存入键值对
    void put(K key,V value);
    //将另外一个map中的所有键值对，存到当前的map中
    void putAll(IMap<?extends K,?extends V> map);
    //根据key删除一个键值对
    V remove(K key);
    //键值对个数
    int size();
    Iterator<MyHashMap.Node> iterator();
}
