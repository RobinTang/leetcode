package leetcode.editor.cn;
// [7]整数反转

//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 3396 👎 0


//leetcode submit region begin(Prohibit modification and deletion)



class Solution7 {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int digit = x % 10;
            // 这里可以用parseInt  也可以用Math.trunc  也可以用~~ 都是为了实现把小数位后面的数字抹掉，达到取整的效果
            x = (x / 10);
            if (res < Math.pow(-2, 31)/10 || res > (Math.pow(2, 31) - 1)/10) {
                return 0;
            }

            res = res * 10 + digit;
            if (res < Math.pow(-2, 31) || res > Math.pow(2, 31) - 1) {
                return 0;
            }
        }
        return res;
    }

    public int reverse2(int x) {
        String num = "" + x;
        boolean negative = false;
        if (num.startsWith("-")){
            negative = true;
            num = num.split("-")[1];
        }
        StringBuilder sBuilder = new StringBuilder();
        for(int i=0; i<num.length(); i++) {
            sBuilder.append(num.charAt(num.length()-i-1));
        }

        try {
            if (negative) {
                return -Integer.parseInt(sBuilder.toString());
            }
            return Integer.parseInt(sBuilder.toString());
        } catch (NumberFormatException e) {
            return 0;
        }

    }

//        public static void main(String[] args) {
//        Solution7 solution = new Solution7();
//        double res = solution.reverse(1534236469);
//        System.out.println(res);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
