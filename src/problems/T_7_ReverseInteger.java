package problems;

/**
 * @className: T_7_ReverseInteger
 * @description:
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231− 1] ，就返回 0。
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 * @tag
 * @author: louis
 * @date: 2023/3/30
 **/
public class T_7_ReverseInteger {

    public int solution(int x) {
        int res = 0;
        while (x != 0) {
            // 超出限制. 为什么是这个
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            // res*10 每次加一位，变成 res10；x % 10 是 x 得最后一位 n，这样可以将 n 加到 res10 的个位数上，这样下一次的时候，再加一位（乘以10）,循环
            res = res * 10 + x % 10;
            // x 每次减少一位
            x = x / 10;
        }
        return res;
    }
}
