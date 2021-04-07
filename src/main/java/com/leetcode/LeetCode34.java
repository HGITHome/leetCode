package com.leetcode;

import java.util.StringJoiner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Tom
 * @Description:
 * @Company
 * @date 2021/3/16 17:59
 */

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 *  
 *
 * 进阶：
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *= 2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LeetCode34 {

    public static void main(String[] args) {
//        alternateTask();
//        String a = "111";
//        String b = a;
//        System.out.println(b == a);
        int[] nums = new int[]{-1,-100,3,99};
        rotate(nums,2);
    }


    public static void rotate(int[] nums, int k) {
        for (int i = 0 ; i < k ; i ++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1 ; j > 0; j --) {
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
        StringJoiner sj = new StringJoiner(",","[","]");
        for (int i : nums) {
            sj.add(String.valueOf(i));
        }
        System.out.println(sj.toString());
    }

    public static void alternateTask() {
        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Thread thread1 = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 65; i < 91; i++) {
                    System.out.println("----------thread1------- " + (char) i);
                    // 提前发送信号，通知await线程唤醒
                    condition2.signal();
                    // 将当前的线程加入到当前的condition的条件队列末尾，进行阻塞，调用await方法，释放锁进入等待状态
                    condition1.await();
                }
                condition2.signal();
            } catch (Exception e) {
            } finally {
                lock.unlock();
            }
        });
        Thread thread2 = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 26; i++) {
                    System.out.println("----------thread2------- " + i);
                    // 提前发送信号，通知await线程唤醒
                    condition1.signal();
                    // 将当前的线程加入到条件队列末尾进行阻塞，调用await,释放锁进入等待状态
                    condition2.await();
                }
                condition1.signal();
            } catch (Exception e) {
            } finally {
                lock.unlock();
            }
        });
        thread1.start();
        thread2.start();
    }

}
