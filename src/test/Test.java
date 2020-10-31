package test;

public class Test {
    public static void main(String[] args) {
//        System.out.println(new HashMap<Integer, Integer>().get(2));

//        //测试foreach中list改变对遍历内容的影响
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        linkedList.add(23);
//        linkedList.add(2563);
//        linkedList.add(2);
//        for (Integer i : linkedList) {//列表改动之后，此处会报ConcurrentModificationException
//            if (linkedList.size() == 3) {
//                linkedList.remove(1);
//            }
//            System.out.println(i);
//        }

        //测试boolean数组的默认值（应该是false）
        boolean[]booleans=new boolean[2];
        for (int i = 0; i < booleans.length; i++) {
            System.out.println(booleans[i]);//false
        }
    }
}
