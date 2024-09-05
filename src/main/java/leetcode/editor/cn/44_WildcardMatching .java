package leetcode.editor.cn;
// [44]通配符匹配

//给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。 
//
// '?' 可以匹配任何单个字符。
//'*' 可以匹配任意字符串（包括空字符串）。
// 
//
// 两个字符串完全匹配才算匹配成功。 
//
// 说明: 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。 
// 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "*"
//输出: true
//解释: '*' 可以匹配任意字符串。
// 
//
// 示例 3: 
//
// 输入:
//s = "cb"
//p = "?a"
//输出: false
//解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
// 
//
// 示例 4: 
//
// 输入:
//s = "adceb"
//p = "*a*b"
//输出: true
//解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
// 
//
// 示例 5: 
//
// 输入:
//s = "acdcb"
//p = "a*c?b"
//输出: false 
// Related Topics 贪心 递归 字符串 动态规划 
// 👍 827 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution44 {

    public boolean match(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1)) {
            return true;
        }
        return false;
    }

    public boolean isMatch(String s, String p) {
        boolean[][] matchArr = new boolean[s.length()+1][p.length()+1];

        matchArr[0][0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j-1) == '*') {
                    if (i == 0) {
                        matchArr[i][j] = matchArr[i][j-1];
                    } else {
                        matchArr[i][j] = matchArr[i - 1][j] || matchArr[i][j-1];
                    }
                } else {
                    if (match(s, p, i, j)) {
                        matchArr[i][j] = matchArr[i-1][j-1];
                    } else {
                        matchArr[i][j] = false;
                    }
                }
            }
        }

        return matchArr[s.length()][p.length()];
    }


//    public static void main(String[] args) {
//        Solution44 solution = new Solution44();
//        boolean res = solution.isMatch("acdcb", "a*c?b");
//        System.out.println(res);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
