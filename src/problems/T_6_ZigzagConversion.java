package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: T_6_ZigzagConversion
 * @description: The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows
 * like this: (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string s, int numRows);
 * <p>
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * <p>
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * @tag
 * @author: louis
 * @date: 2023/3/28
 **/
public class T_6_ZigzagConversion {

    /**
     * 解题思路
     * 从第一行到最后一行，再从最后一行到第一行，这个过程是重复的。
     * 我们可以理解为，每一行的字符是单独存储的，那么我们可以通过行数来存储对应的字符。
     *
     */

    public String solution(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }

        // 建立一个数组，index 对应行数，记录每一行的字符
        List<StringBuilder> list = new ArrayList<>(numRows - 1);
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        StringBuilder res = new StringBuilder();

        // 定义 i, 表示行数。
        // 定义 flag, 当碰到第一行和最后一行的时候，就表示需要折回（从第一行到最后一行，或者从最后一行到第一行的循环动作）
        // 所以 flag 可以理解为当前是从第一行到最后一行还是从最后一行到第一行的方向
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            list.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                // 是第一行或最后一行，折返
                flag = -flag;
            }
            // 1 是增加，从第一行到最后一行； -1 是从最后一行到第一行
            i += flag;
        }

        for (StringBuilder sb : list) {
            res.append(sb.toString());
        }
        return res.toString();
    }
}
