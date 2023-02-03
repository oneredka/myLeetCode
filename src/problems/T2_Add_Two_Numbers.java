package problems;

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
public class T2_Add_Two_Numbers {
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

    public static ListNode soultion(ListNode node1, ListNode node2) {
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
        ListNode result = soultion(l1, l2);
        System.out.println(result);
    }

}
