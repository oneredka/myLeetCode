package problems;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @className: T3_LongestSubstringWithoutRepeatingCharacters
 * @description: Given a string s, find the length of the longest substring without repeating characters.
 *  给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *  输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 *
 * @tag
 * @author: louis
 * @date: 2023/2/9
 **/
public class T_3_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(solution2("pwwkew"));
    }

    public static int solution(String s){
        //  记录窗口中的字符串。右指针继续移动的条件是：窗口中无重复字符，如果有重复字符，就需要移动左指针。
        Map<Character, Integer> chars = new HashMap();
        // 左指针
        int leftIndex = 0;
        // 右指针
        int rightIndex = 0;
        // 最大字串长度
        int maxLen = 0;
        // 从最左边开始移动右指针
        while (rightIndex < s.length()) {
            char rightChar = s.charAt(rightIndex);
            // 记录右指针对应字符在 map 中，及其出现的次数
            chars.put(rightChar, chars.getOrDefault(rightChar, 0) + 1);
            // 如果右指针字符出现次数大于1，将当前左指针对应字符出现次数在 map 中减一，相当于移除一次，左指针右移。直到右边元素在 map 中的记录次数是1.
            // abcabcbb -> abcb -> cb
            // 这里取巧的解法就是，abcb 时，不一个个左指针移动，直接跳到上一个重复字符b的下一个位置c,省去了三次左指针滑动。能想出这种解法的，大概是真正理解了滑动窗口。
            while (chars.get(rightChar) > 1) {
                char leftChar = s.charAt(leftIndex);
                chars.put(leftChar, chars.get(leftChar) - 1);
                leftIndex++;
            }
            // 每次对比拿到最大字串长度
            maxLen = Math.max(maxLen, rightIndex - leftIndex + 1);
            rightIndex++;
        }
        return maxLen;
    }

    public static int solution2(String s){
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            while (map.get(rightChar) > 1) {
                map.put(s.charAt(left) , map.get(s.charAt(left)) - 1);
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }



















    public static int solution3(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            while (map.get(s.charAt(right)) > 1) {
                map.put(s.charAt(left), s.charAt(left) - 1);
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }

}
