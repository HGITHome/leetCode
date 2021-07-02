package com.leetcode;

/**
 * @author Tom
 * @Description:
 * @Company
 * @date 2021/5/14 15:55
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode37 {

    public static void main(String[] args) {
//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
//        for (int i = 0; i < 10; i++) {
//            final int index = i;
//            fixedThreadPool.execute(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        System.out.println(index);
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }
        int[] array = {5,2,3,1,4};
        MySort(array);
        Stack stack = new Stack();
    }
    public static int[] MySort (int[] arr) {
        // write code here
        for(int i = 0 ; i < arr.length ; i ++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
//    public int[][] merge(int[][] intervals) {
//        int[][] merge = new int[][]{};
//        int index = 0;
//        for (int i = 0 ; i < intervals.length - 1; i ++ ) {
//            int left = intervals[i][0];
//            int right = intervals[i][1];
//            int minl = intervals[i][0];
//            int maxr = intervals[i][1];
//            for (int j = i + 1 ; j < intervals.length ; j ++ ) {
//                int l = intervals[j][0];
//                int r = intervals[j][1];
//                if (right >= l && left <= r) {
//                    minl = Math.max(left,l);
//                    maxr = Math.max(right,r);
//                }
//            }
//        }
//        return null;
//    }
}
