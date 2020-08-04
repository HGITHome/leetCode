package com.leetcode;

/**
 * @author snail
 * @Title:
 * @Package
 * @Description:
 * @Company
 * @date 2020/8/4 17:20
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 测试用例:
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class LeetCode20 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l3;
        ListNode l4 = new ListNode(3);
        l3.next = l4;
        ListNode l2 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        l2.next = l5;
        ListNode l6 = new ListNode(4);
        l5.next = l6;
        ListNode listNode = addTwoNumbers(l1,l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            if (listNode != null) {
                listNode = listNode.next;
            }
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead  = new ListNode(0);
        ListNode curre = dummyHead;
        int temp = 0;
        StringBuffer sb = new StringBuffer();
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                int result = l1.val + l2.val + temp;
                sb.append((result % 10));
                curre.next = new ListNode((result % 10));
                curre = curre.next;
                temp = result / 10;
            }
            if (l1 != null && l2 == null) {
                int result = l1.val + temp;
                sb.append((result % 10));
                curre.next = new ListNode((result % 10));
                curre = curre.next;
                temp = result / 10;
            }
            if (l1 == null && l2 != null) {
                int result = l2.val + temp;
                sb.append((result % 10));
                curre.next = new ListNode((result % 10));
                curre = curre.next;
                temp = result / 10;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (temp > 0) {
            sb.append(temp);
            curre.next = new ListNode(temp);
            curre = curre.next;
        }
        List<ListNode> listNodeList = new ArrayList<>();
        Stream.of(sb.toString().split("")).mapToInt(s -> Integer.parseInt(s)).forEach(d -> {
            listNodeList.add(new ListNode(d));
        });
        for (int i = 0 ; i < listNodeList.size() - 1 ; i ++) {
            listNodeList.get(i).next = listNodeList.get(i + 1);
        }
        return listNodeList.get(0);
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x;
      }
  }
}
