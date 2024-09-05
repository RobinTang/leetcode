package leetcode.editor.cn;
// [10]正则表达式匹配

//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// 
// '.' 匹配任意单个字符 
// '*' 匹配零个或多个前面的那一个元素 
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
// 
//
// 示例 1： 
//
// 
//输入：s = "aa", p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 
//输入：s = "aa", p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3： 
//
// 
//输入：s = "ab", p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// 1 <= p.length <= 30 
// s 只包含从 a-z 的小写字母。 
// p 只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 保证每次出现字符 * 时，前面都匹配到有效的字符 
// 
// Related Topics 递归 字符串 动态规划 
// 👍 2742 👎 0

// 核心:  1. 动态规划的子结构: 分为 * 、 非 * 两种情况
// * 的情况比较复杂，需要和前一个绑定成字符对，这字符对有发挥作用、抛弃 两种情况

//leetcode submit region begin(Prohibit modification and deletion)
class Solution10 {
    public boolean match(String s, String p, int i, int j) {
      if (i == 0) {
        return false;
      }
      if (p.charAt(j-1) == '.') {
        return true;
      }
      if (s.charAt(i-1) == p.charAt(j-1)) {
        return true;
      }
      return false;
    }

    public boolean isMatch(String s, String p) {
      Boolean[][] matchArr = new Boolean[s.length()+1][p.length()+1];

      for (int i = 0; i <= s.length(); i++) {
        matchArr[i][0] = false;
      }
      matchArr[0][0] = true;

      for (int i = 0; i <= s.length(); i++) {
        for (int j = 1; j <= p.length(); j++) {
          if (p.charAt(j-1) == '*') {
            if (match(s, p, i, j-1)) {
              matchArr[i][j] = matchArr[i-1][j] || matchArr[i][j-2];
            } else {
              matchArr[i][j] = matchArr[i][j-2];
            }
          } else {
              if (match(s, p, i, j)) {
                matchArr[i][j] = matchArr[i-1][j-1];
              } else {
                matchArr[i][j] = false;
              }
          }
//          System.out.println(i + " | " + j + " | " + matchArr[i][j]);
        }
      }
      return matchArr[s.length()][p.length()];
    }

//    public static void main(String[] args) {
//        Solution10 solution = new Solution10();
//        boolean res = solution.isMatch("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s");
//        System.out.println(res);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
