package main.pre;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.testng.reporters.jq.INavigatorPanel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DogCatShelter {
    static int timeLine=1;
    private class Animal{
        int type;
        int time;
        public Animal(int type) {
            this.type = type;
            time=timeLine++;
        }
    }
    public ArrayList<Integer> shelter(int [][]ope){
        ArrayList<Integer> list=new ArrayList<>();
        Queue<Animal> dogs=new LinkedList<>();
        Queue<Animal> cats=new LinkedList<>();
        for (int []row:ope) {
            int op=row[0];
            int type=row[1];
            if (op==1){
                if (type>0)
                    dogs.add(new Animal(type));
                else if (type<0)
                    cats.add(new Animal(type));
            }else if (op==2){
                if (type==0){
                    if (!dogs.isEmpty()&&(cats.isEmpty()||cats.peek().time>dogs.peek().time))
                        list.add(dogs.poll().type);
                    else if (!cats.isEmpty()&&(dogs.isEmpty()||dogs.peek().time>cats.peek().time))
                        list.add(cats.poll().type);
                }else if (type==1&&!dogs.isEmpty())
                    list.add(dogs.poll().type);
                else if (type==-1&&!cats.isEmpty())
                    list.add(cats.poll().type);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        DogCatShelter shelter=new DogCatShelter();
        int [][]data={{1,1},{1,-1},{1,0},{1,-5},{2,0},{2,-1},{2,0}};
//        System.out.println(shelter.shelter(data));
        Assertions.assertEquals(shelter.shelter(data).toString(),"[1, -1, -5]");
    }
}