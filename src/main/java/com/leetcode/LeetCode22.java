package com.leetcode;

/**
 * @author snail
 * @Title:
 * @Package
 * @Description:
 * @Company
 * @date 2020/8/11 15:53
 */

/**
 *
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 */
public class LeetCode22 {

    public static void main(String[] args) {

    }

    public void solve(char[][] board) {
        for (int i = 0 ; i < board.length ; i ++ ){
            for (int j = 0 ; j < board.length ; j ++) {
                if ("0".equals(board[i][j])) {
                    if (i != 0 || j != 0 || i != board.length - 1 || j != board.length - 1) {
                        boolean tr = true;
                        boolean tr1 = true;
                        for (int k = j - 1 ; k >= 0 ; k --) {
                            if ("0".equals(board[i][k])) {
                                tr = false;
                                break;
                            }
                        }
                        for (int k = j + 1 ; k < board.length ; k ++) {
                            if ("0".equals(board[i][k])) {
                                tr1 = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}
