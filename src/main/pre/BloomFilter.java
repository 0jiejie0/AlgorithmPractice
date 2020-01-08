package main.pre;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BloomFilter {
    public static final int NUM_SLOTS=1024*1024*8;//位图长度
    public static final int NUM_HASH=8;//hash函数个数，一个函数的结果用来标记一个位
    private BigInteger bitmap=new BigInteger("0");//位图

    public static void main(String[] args) {
        BloomFilter bloomFilter=new BloomFilter();
        bloomFilter.addElement("abde");
        bloomFilter.addElement("deab");
        bloomFilter.addElement("adbe");
        bloomFilter.addElement("aedb");
        System.out.println(bloomFilter.check("abcd"));
        System.out.println(bloomFilter.check("abde"));
        System.out.println(bloomFilter.check("adbe"));
        System.out.println(bloomFilter.check("abd"));
    }
    private int hash(String message,int n){
        message+=String.valueOf(n);
        try {
            MessageDigest md5=MessageDigest.getInstance("md5");
            byte[]bytes=message.getBytes();
            md5.update(bytes);
            byte[]digest=md5.digest();
            BigInteger big=new BigInteger(digest);
            return Math.abs(big.intValue()%NUM_SLOTS);
        }catch (NoSuchAlgorithmException e){
            Logger.getLogger(BloomFilter.class.getName()).log(Level.SEVERE,null,e);
        }
        return -1;
//        return main.pre.HashFunctions.bernstein(message,NUM_SLOTS);
    }
    /*处理原始数据
    * 一个hash标记一个位，值域0~NUM_SLOTS-1*/
    public void addElement(String message){
        for (int i = 0; i < NUM_HASH; i++) {
            int hashCode=hash(message,i);
            if (!bitmap.testBit(hashCode)){//如果位图的该位不为1，则标注为1
                bitmap=bitmap.or(new BigInteger("1").shiftLeft(hashCode));
            }
        }
    }
    public boolean check(String message){
        for (int i = 0; i < NUM_HASH; i++) {
            int hashCode=hash(message,i);
            if (!bitmap.testBit(hashCode))//位图某位为0，则message一定不在
                return false;
        }
        return true;
    }
}
