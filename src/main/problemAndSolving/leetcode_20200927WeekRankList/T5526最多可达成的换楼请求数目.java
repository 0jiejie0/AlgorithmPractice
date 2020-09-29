package main.problemAndSolving.leetcode_20200927WeekRankList;

//我们有 n 栋楼，编号从 0 到 n - 1 。每栋楼有若干员工。由于现在是换楼的季节，部分员工想要换一栋楼居住。
//
//给你一个数组 requests ，其中 requests[i] = [fromi, toi] ，表示一个员工请求从编号为 fromi 的楼搬到编号为 toi 的楼。
//
//一开始 所有楼都是满的，所以从请求列表中选出的若干个请求是可行的需要满足 每栋楼员工净变化为 0 。意思是每栋楼 离开 的员工数目 等于 该楼 搬入 的员工数数目。
// 比方说 n = 3 且两个员工要离开楼 0 ，一个员工要离开楼 1 ，一个员工要离开楼 2 ，如果该请求列表可行，应该要有两个员工搬入楼 0 ，一个员工搬入楼 1 ，一个员工搬入楼 2 。
//
//请你从原请求列表中选出若干个请求，使得它们是一个可行的请求列表，并返回所有可行列表中最大请求数目。
//
// 
//
//示例 1：
//
//
//
//输入：n = 5, requests = [[0,1],[1,0],[0,1],[1,2],[2,0],[3,4]]
//输出：5
//解释：请求列表如下：
//从楼 0 离开的员工为 x 和 y ，且他们都想要搬到楼 1 。
//从楼 1 离开的员工为 a 和 b ，且他们分别想要搬到楼 2 和 0 。
//从楼 2 离开的员工为 z ，且他想要搬到楼 0 。
//从楼 3 离开的员工为 c ，且他想要搬到楼 4 。
//没有员工从楼 4 离开。
//我们可以让 x 和 b 交换他们的楼，以满足他们的请求。
//我们可以让 y，a 和 z 三人在三栋楼间交换位置，满足他们的要求。
//所以最多可以满足 5 个请求。
//示例 2：
//
//
//
//输入：n = 3, requests = [[0,0],[1,2],[2,1]]
//输出：3
//解释：请求列表如下：
//从楼 0 离开的员工为 x ，且他想要回到原来的楼 0 。
//从楼 1 离开的员工为 y ，且他想要搬到楼 2 。
//从楼 2 离开的员工为 z ，且他想要搬到楼 1 。
//我们可以满足所有的请求。
//示例 3：
//
//输入：n = 4, requests = [[0,3],[3,1],[1,2],[2,0]]
//输出：4
// 
//
//提示：
//
//1 <= n <= 20
//1 <= requests.length <= 16
//requests[i].length == 2
//0 <= fromi, toi < n

//本题目并未通过
public class T5526最多可达成的换楼请求数目 {
    //在有向图中找最大的问题规模不大
    //等效有向图节点出入度相等的最大边数
//    public int maximumRequests(int n, int[][] requests) {
//        int tempLength = requests.length + 1;//收缩的长度反映可满足的请求数(并不完全等于，有一部分是两个请求的一半，另行计算)
//        Queue<List<Integer>> simply = new LinkedList<>();
//        List<Integer> tempLine;
//        for (int[] request : requests) {//深拷贝
//            tempLine = new LinkedList<>();
//            tempLine.add(request[0]);
//            tempLine.add(request[1]);
//            simply.add(tempLine);
//        }
//        //从收缩队列依次遍历，直到无边可以收缩（1->2,2->5===>1->5）为止
//        while (0 < tempLength) {//剩余待收缩（可能不能收缩）边数为0时退出循环
//            //挑出一个边
//            List<Integer> selectedEdge = simply.poll();
//            //自反的情况，该边出度入度在同一个点
//            if (selectedEdge != null && selectedEdge.get(0).equals(selectedEdge.get(1))) {//请求搬入搬出的是同一栋楼，直接移除可满足请求
//                selectedEdge = null;
//            } else {
//                //查找出度为该边入度的其他边
//                for (List<Integer> findedEdge : simply) {
//                    //收缩
//                    if (selectedEdge != null && selectedEdge.get(1).equals(findedEdge.get(0))) {
//                        //由于前面已经去除了自反的情况，所以找到的边和选定的边一定不同
//                        findedEdge.set(0, selectedEdge.get(0));//收缩，将出度靠到入度上(由于选定的边已经出队，所以不是反向靠拢)
//                        selectedEdge = null;
//                    }
//                }
//            }
//            if (selectedEdge != null) {//没有收缩的情况下
//                simply.offer(selectedEdge);
//                tempLength--;//控制剩余收缩边数（所有边都已经不能收缩时退出）
//            } else {//每次收缩后，对齐待收缩边数到全边数
//                tempLength = simply.size();
//            }
//        }
//        //计算可满足请求数
//        tempLength = requests.length - simply.size();
//        //对照原数组，去除本就不可满足的原请求
//        for (int i = 0; i < simply.size(); i++) {
//            tempLine = simply.poll();
//            for (int[] request : requests) {
//                if (tempLine != null && tempLine.get(0).equals(request[0]) && tempLine.get(1).equals(request[1])) {
//                    tempLine = null;
//                    i--;//simply.size()实时更新，i对应改变
//                }
//            }
//            if (tempLine != null) {
//                simply.offer(tempLine);
//            }
//        }
//        //收缩并去除本就不可满足请求后，剩余的每一条不可满足请求，代表原来的两条不可满足请求
//        //可满足请求=收缩部分长度-收缩后不可满足请求
//        return tempLength - simply.size();
//    }
}
