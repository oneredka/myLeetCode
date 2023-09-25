package problems.array;

/**
 * @className: T_209_MinimumSizeSubarraySum
 * @description:
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * @tag  Sliding Window 滑动窗口 双指针
 * @author: louis
 * @date: 2023/3/14
 **/
public class T_209_MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE, left = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // 当窗口中的值满足条件时，开始滑动窗口，这里窗口右边是不动的，左边 index 向右缩小窗口，直至窗口中的值不满足条件，就开始移动右边边界
            while (sum >= target) {
                result = Math.min(result, i - left + 1);
                sum = sum - nums[left++];
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
