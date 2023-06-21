package problems;

/**
 * @className: T_19_RemoveNthNodeFromEndOfList
 * @description:
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * @tag
 * @author: louis
 * @date: 2023/5/19
 **/
public class T_19_RemoveNthNodeFromEndOfList {

    public static ListNode test(ListNode node, int n) {
        ListNode pre = new ListNode(0);
        pre.next = node;
        ListNode fast = pre;
        ListNode slow = pre;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return pre.next;
    }
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode re = test(node, 3);
        System.out.println(re);
    }
}
