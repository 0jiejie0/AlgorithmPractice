package main.subject_20200104;

public class Mask {
    /**
     * 每出门采购一次口罩，消耗家里库存1只。每次限买3只。买到了，多2只；买不到，亏1只。
     * 老张家里原有库存10只，出门10次之后，家里现有12只。
     * 请问，他有几次出门是买到口罩的？
     * <p>
     * 解题思路一：
     * 假设出门全部买到口罩，则现有数量应该为（ori + goOut * 2）,设为virtual
     * 若now < virtual说明不是每次出门都买到了，（virtual-now）/3 为
     * 没有买到口罩的次数(3为每次最多买到的口罩数量)，与出门次数作差可得结果
     * 特别地：
     * 当ori < 1 ，不能出门，无解
     * 若now > virtual，在每次出门都能买到口罩的情况下依然达不到now，无解
     * 若now与virtual差值不是3的倍数，无解
     *
     * @param ori   原库存
     * @param goOut 出门次数
     * @param now   现有口罩数量
     * @return 返回>=0表示买到口罩次数，返回-1表示无解
     */
    public static final int buyMask(int ori, int goOut, int now) {
        if (ori < 1) //不能出门
            return -1;
        int res = goOut;//假设每次出门都能买到口罩
        int virtual = ori + (goOut << 1);
        if (((virtual - now) % 3) != 0) {
            return -1;
        }
        if (now < virtual) {//有出门没买到的情况
            res -= ((virtual - now) / 3);
        } else if (now > virtual) {//不可能达到指定数量
            return -1;
        }
        return res;
    }
}
