package problems;

/**
 * @className: T_5_LongestPalindromicSubstring
 * @description:
 * Given a string s, return the longest palindromic substring in s.
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * @tag
 * @author: louis
 * @date: 2023/3/21
 **/
public class T_5_LongestPalindromicSubstring {

    public String solution(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLength = 1;
        String res = s.substring(0, 1);
        for (int i = 0; i < len; i++) {
            String oddStr = spareString(s, i, i);
            String even = spareString(s, i, i + 1);
            String maxLengthStr = oddStr.length() > even.length() ? oddStr : even;
            if (maxLengthStr.length() > maxLength) {
                maxLength = maxLengthStr.length();
                res = maxLengthStr;
            }
        }
        return  res;
    }

    /**
     * 中心扩散
     * 如果字符串长度是奇数，那么中心扩散点是中间的字符，
     * 如果字符串长度是偶数，那么中心扩散点是中间两个数的间隙
     *
     * left = right. 这个时候是奇数（中心点就是 left 对应的字符）;
     * left = right + 1 这个时候是偶数（中心点是 left 和 right 的间隙）
    */
    private String spareString(String s, int left, int right) {
        int i = left, j = right;
        while (i >=0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                // 遍历每一个索引，以这个索引为中心，利用“回文串”中心对称的特点，往两边扩散，看最多能扩散多远
                i--;
                j++;
            }else {
                break;
            }
        }
        // 跳出循环时，左右刚好对等，所以不能取改变之后的 i, j
        return s.substring(i + 1, j);
    }

    // Manacher 算法 “马拉车”算法
    public String solution2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLength = 1, start = 0;
        String divideStr = addDivide(s, "#");
        int dLen = divideStr.length();
        for (int i = 0; i < dLen; i++) {
            int step = centerStep(divideStr, i);
            if (step > maxLength) {
                maxLength = step;
                start = (i + maxLength) / 2;
            }
        }
        return  s.substring(start, start + maxLength);
    }

    public int centerStep(String s, int center) {
        int len = s.length(), left = center - 1, right = center + 1, step = 0;
        while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            step++;
        }
        return step;
    }

    /**
     * 预处理字符串，使用分隔符分割，前后都加分隔符
     * @param s 原字符串
     * @param divide 分隔符
     * @return
     */
    public String addDivide(String s, String divide) {
        int len = s.length();
        if (len == 0) {
            return "";
        }

        if (s.indexOf(divide) != -1) {
            throw new IllegalArgumentException("参数错误，分隔符在传递的字符串中存在。");
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(divide).append(s.charAt(i));
        }
        // 最后也要加上分隔符
        sb.append(divide);
        return sb.toString();
    }
}
