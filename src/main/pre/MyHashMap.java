package main.pre;

import java.util.Iterator;

public class MyHashMap<K,V> implements IMap<K,V> {
    private int length=16;
    private Node[] buckets=new Node[length];
    private int size=0;
    @Override
    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i]=null;
        }
        size=0;
    }

    @Override
    public boolean containsKey(K key) {
        int index=hash(key);
        if (buckets[index]!=null){
            Node<K,V> p=buckets[index];
            while (p!=null){
                K k=p.key;
                if (k==key||k.hashCode()==key.hashCode()&&key.equals(k)){
                    return true;
                }
                p=p.next;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i]!=null){//桶不为空
                Node<K,V> p=buckets[i];
                while (p!=null){
                    if (p.value==value)//从桶中寻找到匹配的value
                        return true;
                    p=p.next;
                }
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        int index=hash(key);
        if (buckets[index]!=null) {//桶不为空
            Node<K,V> p=buckets[index];
            while (p!=null){
                K k=p.key;
                if (k==key||k.hashCode()==key.hashCode()&&key.equals(k))//找到key相同的元素
                {
                    return p.value;
                }
                p=p.next;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
    private class MapIterator implements Iterator<Node>{
        Node<K,V> p=buckets[0];
        int index=0;
        @Override
        public boolean hasNext() {
            while (index<buckets.length&&p==null){
                index++;
                if (index!=buckets.length)
                    p=buckets[index];
            }
            return p!=null;
        }

        @Override
        public Node next() {
            Node<K,V> node=p;
            p=p.next;
            return node;
        }
    }
    @Override
    public Iterator<MyHashMap.Node> iterator(){
        return (Iterator) new MapIterator();
    }
    @Override
    public MyHashSet<K> keySet() {
        MyHashSet<K> set=new MyHashSet<>();
        Iterator<MyHashMap.Node> iter=iterator();
        Node<K,K> p;
        while (iter.hasNext()){
            p=iter.next();
            set.add(p.key);
        }
        return set;
    }

    @Override
    public V[] values() {
        return null;
    }

    @Override
    public void put(K key, V value) {
        Node<K,V> node=new Node<>(key, value);
        int index=hash(key);//算出在桶中的位置
        if (buckets[index]==null){//桶为空
            buckets[index]=node;
            size++;
        }else {
            Node<K,V> p=buckets[index];//链表表头
            while (p!=null){
                K k=p.key;
                if (k==key||k.hashCode()==key.hashCode()&&k.equals(key)){
                    p.value=value;//存在相同key，更新value
                    break;
                }else if (p.next==null){
                    p.next=node;
                    size++;
                    break;
                }
                p=p.next;
            }
        }
    }

    private int hash(K key){
        return key.hashCode()%length;
    }

    @Override
    public void putAll(IMap<? extends K, ? extends V> map) {
    }

    @Override
    public V remove(K key) {
        int index=hash(key);
        if (buckets[index]!=null){//桶不为空，则进入桶中查找
            Node<K,V> p=buckets[index];
            Node<K,V> pre=p;
            while (p!=null){
                K k=p.key;
                if (k==key||k.hashCode()==key.hashCode()&&key.equals(k)){
                    if (p==pre){
                        buckets[index]=p.next;
                    }else {
                        pre.next=p.next;
                    }
                    size--;
                    return p.value;
                }
                pre=p;
                p=p.next;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder("[");
        Node<K,V> p;
        for (int i = 0; i < buckets.length; i++) {//遍历每个桶
            if (buckets[i]!=null){//跳过空桶
                p=buckets[i];
                while (p!=null){
                    stringBuilder.append("("+p.key+","+p.value+"),");
                    p=p.next;
                }
            }
        }
        if (stringBuilder.length()>1)
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public class Node<K,V>{
        public K key;
        public V value;
        private Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
