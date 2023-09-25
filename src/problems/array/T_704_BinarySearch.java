package problems.array;

/**
 * @className: T_704_BinarySearch
 * @description:
 * Given an array of integers nums which is sorted in ascending order, and an integer target,
 * write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * Example 1:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * @tag
 * @author: louis
 * @date: 2023/3/9
 **/
public class T_704_BinarySearch {

    public static int solution1(int[] nums, int target) {
        if (target < nums[0] || nums[nums.length - 1] < target) {
            return -1;
        }
        // 使用 左闭右闭
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] > target) {
                // target 比中间值小， 在左区间
                right = middle - 1;
            } else if (nums[middle] < target) {
                // target 比中间值大， 在右区间
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static int solution2(int[] nums, int target) {
        if (target < nums[0] || nums[nums.length - 1] < target) {
            return -1;
        }
        // 使用 左闭右开
        int left = 0, right = nums.length;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] > target) {
                // target 比中间值小， 在左区间
                right = middle;
            } else if (nums[middle] < target) {
                // target 比中间值大， 在右区间
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
