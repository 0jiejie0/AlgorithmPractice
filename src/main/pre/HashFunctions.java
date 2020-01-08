package main.pre;

public class HashFunctions {
    /*取余法*/
    static int hashMod(Object object,int prime){
        return Math.abs(object.hashCode()%prime);
    }
    /*加法*/
    static int additiveHash(Object object,int prime){
        String string=object.toString();
        int hash=string.length();
        for (int i = 0; i < string.length(); i++) {
            hash+=string.charAt(i);
        }
        return Math.abs(hash%prime);
    }
    /*旋转哈希，利用位运算*/
    static int rotatingHash(Object object,int prime){
        String string=object.toString();
        int hash=string.length();
        for (int i = 0; i < string.length(); i++) {
            hash=(hash<<4)^(hash>>18)^string.charAt(i);
        }
        return Math.abs(hash%prime);
    }
    /*乘法*/
    static int bernstein(Object object,int prime){
        String string=object.toString();
        int hash=0,seed=31;
        for (int i = 0; i < string.length(); i++) {
            hash=seed*hash+string.charAt(i);
        }
        return Math.abs(hash%prime);
    }
}
