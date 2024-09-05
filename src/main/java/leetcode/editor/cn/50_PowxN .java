package leetcode.editor.cn;
// [50]Pow(x, n)

//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn ）。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100
// 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xn <= 104 
// 
// Related Topics 递归 数学 
// 👍 882 👎 0

// 如果递归时没有存临时变量，会报 Time Limit Exceeded

//leetcode submit region begin(Prohibit modification and deletion)
class Solution50 {

    public double pow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double child = pow(x, n/2);

        if (n %2 == 0) {
            return child * child;
        } else {
            return x * child * child;
        }
    }

    public double myPow(double x, int n) {
        long tmpN = n;
        if (n >= 0) {
            return pow(x, n);
        } else {
            return 1 / pow(x, -n);
        }
    }

//    public static void main(String[] args) {
//        Solution50 solution = new Solution50();
//        double res = solution.myPow(0.001, 2147483647);
//        System.out.println(res);
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
