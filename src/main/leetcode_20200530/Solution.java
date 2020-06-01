package main.leetcode_20200530;
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
//
//
// 示例:
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
//
// Related Topics 数组 哈希表


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        return solutionHashMap(nums, target);
    }

    public int[] solutionHashMap(int[] nums, int target) {
//        用hashmap后，操作过程就简单了很多
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return solutionHashMap(nums, target);
    }
//
//    public int[] solutionSort(int[] nums, int target) {
////        这里不能区分加数为0的情况
////        本来不想用那么多变量的，测试数据里果然有0，看来只能再加变量了
////        好吧可以用hashmap，放弃该快排了
//        int left = 0, right = nums.length - 1, sum = 0;
//        int[] copy = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {//复制原数组，用以找到目标元素原下标（排序前的下标）
//            copy[i] = nums[i];
//        }
//        sort(nums, left, right);
//        while (left < right) {//无重复元素，所以两个元素下标一定不同
//            sum = nums[left] + nums[right];
//            if (sum == target) {//找到符合条件的两个元素
//                break;
//            } else if (sum < target) {//首尾逼近，向目标靠拢（这个操作好像有个名字？）
//                left++;
//            } else {
//                right--;
//            }
//        }
//        //找原下标
//        char flag = 0;//有了这个标志，下边就不用那么多判定条件了,并且能够轻松应对各种加数相等、为负、为零的情况
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[left] == copy[i] && (flag & 2) == 0) {
////            if (nums[left] == copy[i] && (sum >> 1) != nums[left]) {
//                //target为两相同元素和时，先匹配right，防止两次都匹配left
//                sum -= nums[left];
//                left = i;
//                flag |= 2;
//            } else if (nums[right] == copy[i] && (flag & 1) == 0) {
////            } else if (nums[right] == copy[i] && (nums[right] == sum ^ sum == target)) {
//                //匹配right时的两种情况：
//                //1、left已经匹配，此时sum与nums[right]相对，而与target总和相异
//                //2、left未匹配，此时sum与target一定相等，而大于nums[right]
//                sum -= nums[right];
//                right = i;
//                flag |= 1;
//            }
//        }
//        return left < right ? new int[]{left, right} : new int[]{right, left};
//    }
//
//    /**
//     * 快排
//     *
//     * @param arr
//     * @param start 起始下标
//     * @param end   终止下标【闭区间】
//     */
//    public void sort(int[] arr, int start, int end) {
//        boolean sorted = true;
//        if (start + 8 < end) {
////            判定原始数组是否有序（长度大于8）
//            for (int i = start; i < end; i++) {
//                sorted &= arr[i] <= arr[i + 1];
//            }
//        } else {
//            sorted = false;
//        }
//        if (sorted || start >= end) {
//            return;
//        }
////        正式排序
//        int left = start, right = end;
//        int flag = (arr[left] >> 1) + (arr[right] >> 1);//取首尾两元素均值代表数组元素平均大小
//        while (left <= right) {
//            if (arr[left] <= flag) {
//                left++;
//                continue;
//            }
//            if (arr[right] > flag) {
//                right--;
//                continue;
//            }
//            arr[left] ^= arr[right];
//            arr[right] ^= arr[left];
//            arr[left] ^= arr[right];
//            left++;
//            right--;
//        }
//        //防止越界，限定在【start，end】
//        if (left > end) {
//            left--;
//            right--;
//        } else if (right < start) {
//            left++;
//            right++;
//        }
//        sort(arr, start, right);
//        sort(arr, left, end);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
