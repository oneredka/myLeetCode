package problems;

/**
 * @className: T1208_GetEqualSubstringsWithinBudget
 * @description: You are given two strings s and t of the same length and an integer maxCost.
 *
 * You want to change s to t. Changing the ith character of s to ith character of t costs |s[i] - t[i]|
 * (i.e., the absolute difference between the ASCII values of the characters).
 *
 * Return the maximum length of a substring of s that can be changed to be the same as the corresponding substring of t with a cost less than or equal to maxCost.
 * If there is no substring from s that can be changed to its corresponding substring from t, return 0.
 *
 * 给你两个长度相同的字符串，s 和 t。
 *
 * 将 s中的第i个字符变到t中的第 i 个字符需要s[i] - t[i]的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 *
 * 用于变更字符串的最大预算是maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 *
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 *
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 * 输入：s = "abcd", t = "bcdf", maxCost = 3
 * 输出：3
 * 解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3
 * @tag
 * @author: louis
 * @date: 2023/2/10
 **/
public class T1208_GetEqualSubstringsWithinBudget {

    // todo 对这个题和解法不理解
    public static int solution(String s, String t, int maxCost) {
        int res = 0, sum = 0, right = 0, left = 0;
        while (right < s.length()) {
            sum += Math.abs(s.charAt(right) - t.charAt(right));
            if (sum > maxCost) {
                sum -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            right++;
            res = Math.max(res, sum);
        }
        return res;
    }
}
