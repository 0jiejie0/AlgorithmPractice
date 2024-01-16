package main.problemAndSolving.cskaoyan.com.verify_20210809;

public class SequenceList {

    public boolean delST(SqList sqList, int s, int t) {
        int times = 0;
        int i, k = 0;
        if (sqList.length == 0 || s >= t) {
            return false;
        }
        for (i = 0; i < sqList.length; i++) {
            if (sqList.data[i] >= s && sqList.data[i] <= t)
                k++;
            else {
                sqList.data[i - k] = sqList.data[i];
                times++;
            }
        }
        sqList.length -= k;
        System.out.println("st" + times);
        return true;
    }

    public boolean deleteBetween(SqList sqList, int s, int t) {
        int times = 0;
        int k = 0;
        if (sqList.length == 0 || s >= t)
            return false;
        for (int i = 0; i < sqList.length; i++) {
            if (sqList.data[i] < s || sqList.data[i] > t) {
                sqList.data[k++] = sqList.data[i];
                times++;
            }
        }
        sqList.length = k;
        System.out.println("bt" + times);
        return true;
    }
}
