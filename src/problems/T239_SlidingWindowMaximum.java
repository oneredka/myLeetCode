package problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * - @className: T239_Sliding_Window_Maximum
 * - @description:
 * - You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * - You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * -
 * - Return the max sliding window.
 * -
 * - 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * -
 * - 返回 滑动窗口中的最大值 。
 * - Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * - Output: [3,3,5,5,6,7]
 * - Explanation:
 * - Window position Max
 * -
 * - [1 3 -1] -3 5 3 6 7 3
 * - 1 [3 -1 -3] 5 3 6 7 3
 * - 1 3 [-1 -3 5] 3 6 7 5
 * - 1 3 -1 [-3 5 3] 6 7 5
 * - 1 3 -1 -3 [5 3 6] 7 6
 * - 1 3 -1 -3 5 [3 6 7] 7
 * -
 * - @tag
 * - @author: louis
 * - @date: 2023/2/16
 **/
public class T239_SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = solution2(nums, k);
        // excepted result [3,3,5,5,6,7]
        //                 [0,-3,5,3,6,7]
        for (int re : res) {
            System.out.println(re);
        }
    }

    public static int[] solution(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // 维护一个队列，始终将最大值的 index 放在队列头部。这样窗口符合长度以后，每向右滑动一次，比较之后，队列的头部就是最大值
            while (!list.isEmpty() && nums[list.getLast()] < nums[i]) {
                // 队列的末尾小于当前 index 对应值，将队列的末尾删掉，以此形成一个单调递减的队列
                list.removeLast();
            }
            // 将当前 index 放入队尾
            list.addLast(i);
            // 窗口的长度如果大于 k, 移除最前面的 index
            if (list.getFirst() <= (i - k)) {
                list.removeFirst();
            }
            // i + 1 = k 是窗口的长度，当到窗口符合时，队列头部就是需要保存的最大值
            if (i + 1 >= k) {
                res[i + 1 - k] = nums[list.getFirst()];
            }
        }
        return res;
    }

    public static int[] solution2(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (deque.peek() <= (i - k)) {
                deque.poll();
            }
            if ((i + 1 >= k)) {
                res[i + 1 -k] = deque.peek();
            }
        }
        return res;
    }
}