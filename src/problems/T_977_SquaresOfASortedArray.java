package problems;

/**
 * @className: T_977_SquaresOfASortedArray
 * @description:
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 *
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * 示例 1：
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 *
 * @tag
 * @author: louis
 * @date: 2023/3/10
 **/
public class T_977_SquaresOfASortedArray {

    public static int[] solution(int[] nums) {
        int[] result = new int[nums.length];
        int leftIndex = 0, rightIndex = nums.length - 1, resultIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
            if (nums[leftIndex] * nums[leftIndex] < nums[rightIndex] * nums[rightIndex]) {
                result[resultIndex--] = nums[rightIndex] * nums[rightIndex];
                rightIndex--;
            } else {
                result[resultIndex--] = nums[leftIndex] * nums[leftIndex];
                leftIndex++;
            }
        }
        return result;
    }

}
