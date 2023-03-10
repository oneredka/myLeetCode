package problems;

/**
 * @className: T_704_BinarySearch
 * @description: TODO description
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
