package com.leetcode;

/**
 * @author Tom
 * @Description:
 * @Company
 * @date 2021/4/13 10:58
 */


import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x21ib6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LeetCode35 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1};
//        System.out.println(singleNumber(nums));
//        int i= 2;
//        Integer integer = 2;
//        System.out.println(integer.equals(i));
        int a = 2;
        int b = 3;
        int c = a<<1 | a^b;
        System.out.println(c);
        int q = 1000;
        Integer g = 1000;
//        System.out.println(q == g);
        System.out.println(1 << 30);
    }

    public static int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i ++) {
            if (null != map.get(nums[i])) {
                Integer sum = map.get(nums[i]);
                map.put(nums[i],sum + 1);
            } else {
                map.put(nums[i],1);
            }
        }
        for (Integer i : map.keySet()){
            if (map.get(i) == 1) {
                return i;
            }
        }
        return 0;
    }
}
