package problems.array;

/**
 * @className: T_27_RemoveElement
 * @description:
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed.
 *
 * Since it is impossible to change the length of the array in some languages,
 * you must instead have the result be placed in the first part of the array nums. More formally,
 * if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result.
 * It does not matter what you leave beyond the first k elements.
 * Return k after placing the final result in the first k slots of nums.
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 *
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案
 *
 * @tag
 * @author: louis
 * @date: 2023/3/10
 **/
public class T_27_RemoveElement {

    public static int solution(int[] nums, int val){
        // 使用快慢指针
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {

           if (nums[fast] != val) {
               //如果快指针位置不与目标值相等，
               nums[slow++] = nums[fast];
           }
        }

        return slow;
    }

}
