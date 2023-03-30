package problems;

/**
 * @className: s
 * @description:
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 *
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1：
 * 输入：x = 121
 * 输出：true
 *
 * 示例 2：
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3：
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 *

 * @tag
 * @author: louis
 * @date: 2023/3/30
 **/
public class T_9_PalindromeNumber {
    /**
     * 举个例子：1221 这个数字。
     *
     * 通过计算 1221 / 1000， 得首位1
     * 通过计算 1221 % 10， 可得末位 1
     * 进行比较
     * 再将 22 取出来继续比较
     * @param x
     * @return
     */
    public static boolean solution(int x) {
        if (x < 0) {
            return false;
        }
        // 求取数字位数
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }
        while (x > 0) {
            int right = x / div;
            int left = x % 10;
            if (right != left && x > 9) {
                return false;
            }
            x = x % div / 10;
            // 去掉第一位和最后一位，相当于去掉两位
            div = div / 100;
        }

        return true;
    }
}
