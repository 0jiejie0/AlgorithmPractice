package main;

import java.util.ArrayList;
import java.util.Stack;

public class TwoStacksSort {
    public ArrayList<Integer> twoStacksSort(int []numbers){
        Stack<Integer> source=new Stack<>();
        for (int i = numbers.length; i >0 ; i--) {
            source.push(numbers[i-1]);
        }
        Stack<Integer> target=twoStacksSort(source);
        ArrayList<Integer> list=new ArrayList<>();
        while (!target.empty())
            list.add(target.pop());
        return list;
    }
    public Stack<Integer> twoStacksSort(Stack<Integer> source){
        Stack<Integer> target=new Stack<>();
        while (!source.empty()){
            int vs=source.pop();
            if (target.empty()){
                target.push(vs);
            }else {
                if (vs>=target.peek()){
                    target.push(vs);
                }else {
                    source.push(target.pop());
                    while (vs<target.peek()&&!target.empty())
                        source.push(target.pop());
                    target.push(vs);
                }
            }
        }
        return target;
    }

    public static void main(String[] args) {
        TwoStacksSort sort=new TwoStacksSort();
        Stack<Integer> stack=new Stack<>();
        ArrayList<Integer> list=new ArrayList<>();
        int[]arr=new int[]{2,3,6,5,74,6,6,2,7,4,65,65,3,654237,23,6,4};
        list=sort.twoStacksSort(arr);
        System.out.println(list);
    }
}
