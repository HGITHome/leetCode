package com.leetcode;

/**
 * @author Tom
 * @Description:
 * @Company
 * @date 2021/5/14 14:13
 */

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 *
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 *
 * 输入：nums = [-100000]
 * 输出：-100000
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode36 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,-2};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        for (int i = 0 ; i < nums.length ; i ++) {
            int sum = nums[i];
            max = Math.max(sum,max);
            for (int j = i + 1 ; j < nums.length ; j ++) {
                sum = sum + nums[j];
                max = Math.max(sum,max);
            }
        }
        return max;
    }
}
