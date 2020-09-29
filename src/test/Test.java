package test;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
//        System.out.println(new HashMap<Integer, Integer>().get(2));
        //测试foreach中list改变对遍历内容的影响
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(23);
        linkedList.add(2563);
        linkedList.add(2);
        for (Integer i : linkedList) {//列表改动之后，此处会报ConcurrentModificationException
            if (linkedList.size() == 3) {
                linkedList.remove(1);
            }
            System.out.println(i);
        }
    }
}
