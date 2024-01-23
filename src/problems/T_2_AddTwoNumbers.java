package problems;

import java.util.List;

/**
 * @className: T2_Add_Two_Numbers
 * @description: You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * <p>
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * @tag
 * @author: louis
 * @date: 2023/2/3
 **/
public class T_2_AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode solution(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        int carry = 0;
        while (node1 != null || node2 != null || carry > 0) {
            int sum = 0;
            if (node1 != null) {
                sum += node1.val;
                node1 = node1.next;
            }
            if (node2 != null) {
                sum += node2.val;
                node2 = node2.next;
            }
            if (carry != 0) {
                sum += carry;
            }
            // 是否有进位
            carry = sum / 10;
            ListNode re = new ListNode(sum % 10);
            temp.next = re;
            temp = temp.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // l1 = [2,4,3], l2 = [5,6,4]
        ListNode l1 = new ListNode(2, null);
        l1.next = new ListNode(4, new ListNode(3, null));

        ListNode l2 = new ListNode(5, null);
        l2.next = new ListNode(6, new ListNode(4, null));
        ListNode result = solution3(l1, l2);
        System.out.println(result);
    }

    public static ListNode solution2(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int addN = 0;
        while (l1 != null || l2 != null) {
            int n1 =  null == l1 ? 0 : l1.val;
            int n2 = null == l2 ? 0: l2.val;
            int sum = n1 + n2 + addN;
            if (sum > 9) {
                addN = 1;
                sum = sum - 10;
            } else {
                addN = 0;
            }
            if (null != l1) {
                l1 = l1.next;
            }
            if (null != l2) {
                l2 = l2.next;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
        }

        if (addN == 1) {
            cur.next = new ListNode(addN);
        }
        return pre.next;
    }

    public static ListNode solution3 (ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int addN = 0;
        int sum = 0;
        while (null != l1 || null != l2) {
            int x = null == l1 ? 0 : l1.val;
            int y = null == l2 ? 0 : l2.val;
            sum = x + y + addN;
            addN = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;

            if (null != l1) {
                l1 = l1.next;
            }

            if (null != l2) {
                l2 = l2.next;
            }
        }
        if  (addN == 1) {
            cur.next = new ListNode(addN);
        }
        return  pre.next;
    }

    public static ListNode solution4 (ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int addN = 0;
        int sum = 0;
        while (null != l1 || null != l2 || addN != 0) {
            int x = null == l1 ? 0 : l1.val;
            int y = null == l2 ? 0 : l2.val;
            sum = x + y + addN;
            addN = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;

            if (null != l1) {
                l1 = l1.next;
            }

            if (null != l2) {
                l2 = l2.next;
            }
        }
        return  pre.next;
    }


}
