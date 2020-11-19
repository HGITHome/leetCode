package com.leetcode;

/**
 * @author snail
 * @Title:
 * @Package
 * @Description:
 * @Company
 * @date 2020/9/21 17:24
 */

/**
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 *  
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode25 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public static void main(String[] args) {

    }
    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

    public TreeNode convertBST(TreeNode root) {
        return null;
    }

    private Integer getSum(TreeNode t) {
        TreeNode head = t;
        TreeNode l = t.left;
        TreeNode r = t.right;
        Integer sum = t.val;
        do {
            if (l != null) {
                sum = l.val + sum;
            }
            if (r != null) {
                sum = r.val + sum;
            }
            l = l.left;
            r = l.right;
        } while (l != null || r != null);
        return 0;
    }

}
