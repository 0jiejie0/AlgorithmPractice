package main.pre;

import java.util.ArrayList;

public class SetOfStacks {
    public ArrayList<ArrayList<Integer>> setStacks(int [][]ope, int size){
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        ArrayList<Integer> currentStack=new ArrayList<>();
        result.add(currentStack);
        for (int []opeAndValue:ope) {
            if(opeAndValue[0]==1){
                if (currentStack.size()==size){
                    currentStack=new ArrayList<>();
                    result.add(currentStack);
                }
                currentStack.add(opeAndValue[1]);
            }else{
                if (currentStack.size()!=0)
                    currentStack.remove(currentStack.size()-1);
                if(currentStack.size()==0&&result.size()!=1){
                    result.remove(result.size()-1);
                    currentStack=result.get(result.size()-1);
                }
            }
        }
        return result;
    }
    public String string(ArrayList<ArrayList<Integer>> result){
        StringBuffer stringBuffer=new StringBuffer("[");
        StringBuffer buffer;
        ArrayList<Integer> inres;
        for (int i = 0; i< result.size(); i++) {
            buffer=new StringBuffer("[");
            inres=result.get(i);
            if(i!=0)
                stringBuffer.append(" , ");
            for (int j = 0; j < inres.size(); j++) {
                if(j!=0)
                    buffer.append(" , ");
                buffer.append(inres.get(j));
            }
            buffer.append("]");
            stringBuffer.append(buffer.toString());
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}