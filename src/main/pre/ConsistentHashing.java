package main.pre;

import java.util.*;

public class ConsistentHashing {
    //hash算法，将关键字映射到2^32的环状空间
    static long hash(String key){
        return Math.abs(HashFunctions.bernstein(key, 0b1111111111111111111111111111111)*
                ((long)(key.hashCode())))%(1000000);
    }
    static class Node implements HashNode{
        String name;
        String ip;

        public Node(String name, String ip) {
            this.name = name;
            this.ip = ip;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name + "-"+ ip;
        }
    }
    interface HashNode{
        String getName();
    }

    List<Node> nodes;
    TreeMap<Long,Node> hashAndNode=new TreeMap<>();
    TreeMap<Long,Node> keyAndNode=new TreeMap<>();
    public ConsistentHashing(List<Node> nodes) {
        this.nodes = nodes;
        init();
    }
    private void init(){
        for (int i = 0; i < nodes.size(); i++) {
            Node node=nodes.get(i);
            long hash=hash(node.ip);
            hashAndNode.put(hash,node);
        }
    }
    public void add(String key){
        long hash=hash(key);
        SortedMap<Long,Node> map=hashAndNode.tailMap(hash);//map的key中所有比key大的键值对集合为一个子map
        Node node;
        if (map.isEmpty()) {
            node = hashAndNode.firstEntry().getValue();
        }else {
            node=map.get(map.firstKey());//key归属第一个结点
        }
        keyAndNode.put(hash,node);
    }
    /*增加机器节点*/
    public void add(Node newNode){
        long hash=hash(newNode.ip);
        hashAndNode.put(hash,newNode);
        //数据迁移
        SortedMap<Long,Node> pre=hashAndNode.subMap(0L,hash);
        long to=hash;
        long from;
        if (pre.isEmpty()){
            SortedMap<Long,Node> between;
            between = keyAndNode.headMap(to);
            for (Map.Entry<Long, Node> entry : between.entrySet()) {
                entry.setValue(newNode);
            }
            between = keyAndNode.tailMap(hashAndNode.lastKey());
            for (Map.Entry<Long, Node> entry : between.entrySet()) {
                entry.setValue(newNode);
            }
        }else {
            from = pre.firstKey();
            SortedMap<Long,Node> between=keyAndNode.subMap(from,to);
            for (Map.Entry<Long, Node> entry : between.entrySet()) {
                entry.setValue(newNode);
            }
        }
    }
    public static void main(String[] args) {
        List<Node> nodes=new ArrayList<>();
        nodes.add(new Node("n1","192.168.1.100"));
        nodes.add(new Node("n2","192.168.1.101"));
        nodes.add(new Node("n3","192.168.1.102"));
        nodes.add(new Node("n4","192.168.1.103"));
        nodes.add(new Node("n5","192.168.1.104"));
        ConsistentHashing obj = new ConsistentHashing(nodes);
        for (Map.Entry<Long,Node> entry: obj.hashAndNode.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue().getName());
        }
        obj.add("data1");
        obj.add("data2");
        obj.add("data3");
        obj.add("data4");
        obj.add("data5");
        obj.add("data6");
        obj.add("data7");
        obj.add("data8");
        obj.add("data9");
        obj.add("data10");
        for (Map.Entry<Long, Node> entry :obj.keyAndNode.entrySet()) {
            System.out.println(entry.getKey()+"-in-"+entry.getValue().name);
        }
        obj.add(new Node("n6","192.168.1.105"));
        obj.add(new Node("n7","192.168.1.106"));
        obj.add(new Node("n8","192.168.1.107"));
        obj.add(new Node("n9","192.168.1.108"));
        obj.add(new Node("n10","192.168.1.109"));
        obj.add(new Node("n11","192.168.1.110"));
        for (Map.Entry<Long,Node> entry: obj.hashAndNode.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue().getName());
        }
        for (Map.Entry<Long, Node> entry :obj.keyAndNode.entrySet()) {
            System.out.println(entry.getKey()+"-in-"+entry.getValue().name);
        }
    }
}
