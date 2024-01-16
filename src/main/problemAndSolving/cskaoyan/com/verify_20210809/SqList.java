package main.problemAndSolving.cskaoyan.com.verify_20210809;

public class SqList {
    public int[] data;
    public int length;
    private static int MaxLength = 10;

    public SqList() {
        data = new int[MaxLength];
    }

    public SqList(int[] data) {
        this.data = data;
        this.length = data.length;
    }

    public void add(int a) {
        this.data[this.length++] = a;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.length);
        for (int i = 0; i < this.length; i++) {
            stringBuilder.append(", " + this.data[i]);
        }
        return stringBuilder.toString();
    }
}
