package com.leetcode;

/**
 * @author
 * @Title:
 * @Package
 * @Description:
 * @Company
 * @date 2020/11/26 16:15
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *  [-1,0,1,2,-1,-4]
 * 0
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode30 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSumClosest(nums,0));
    }

    public static int threeSumClosest(int[] nums, int target) {
        List<Integer> sums = new ArrayList<>();
        for (int i = 0 ; i < nums.length - 2 ; i ++) {
            for (int j = i + 1 ; j < nums.length - 1 ; j ++) {
                for (int k = j + 1 ; k < nums.length ; k ++) {
                    sums.add((nums[i] + nums[j] + nums[k]));
                }
            }
        }
        // 当目标值为0情况
        if (0 == target) {
            int minSum = sums.get(0);
            int minLen = minSum >= 0 ? minSum : minSum * (-1);
            for (int i = 1 ; i < sums.size() ; i ++) {
                int tempSum = sums.get(i);
                int tempLen = tempSum >= 0 ? tempSum : tempSum * (-1);
                if (minLen >= tempLen) {
                    minSum = tempSum;
                    minLen = tempLen;
                }
            }
            return minSum;
        }
        // target小于0情况
        if (0 > target) {
            int minSum = sums.get(0);
            int minLen = 0;
            if (minSum >= 0) {
                minLen = minSum + (target * (-1));
            } else {
                minLen = (minSum - target) > 0 ? (minSum - target) : (minSum - target) * (-1);
            }
            for (int i = 1 ; i < sums.size() ; i ++) {
                int tempSum = sums.get(i);
                if (tempSum >= 0) {
                    if (minLen >= (tempSum + (target * (-1)))) {
                        minSum = tempSum;
                        minLen = (tempSum + (target * (-1)));
                    }
                } else {
                    int tempLen = tempSum - target > 0 ? tempSum - target : (tempSum - target) * (-1);
                    if (minLen >= tempLen) {
                        minSum = tempSum;
                        minLen = tempLen;
                    }
                }
            }
            return minSum;
        }
        // target 大于0情况
        if ( 0 < target) {
            int minSum = sums.get(0);
            int minLen = 0 ;
            if (minSum >= 0) {
                minLen = (minSum - target) > 0 ? (minSum - target) : (minSum - target) * (-1);
            } else {
                minLen = target + (minSum * (-1));
            }
            for (int i = 1 ; i < sums.size() ; i ++) {
                int tempSum = sums.get(i);
                if (tempSum >= 0) {
                    int tempLen = tempSum - target > 0 ? tempSum - target : (tempSum - target) * (-1);
                    if (minLen >= tempLen) {
                        minSum = tempSum;
                        minLen = tempLen;
                    }
                } else {
                    int tempLen  = target + (tempSum * (-1));
                    if (minLen >= tempLen) {
                        minSum = tempSum;
                        minLen = tempLen;
                    }
                }
            }
            return minSum;
        }
        return 0;
    }
}
