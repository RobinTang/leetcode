package leetcode.editor.cn;
// [42]接雨水

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 
// 👍 3140 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

// 核心思想: 凸形，只能有3种形态: 极值在中间、极值在单侧
class Solution42 {
    public int trap(int[] height) {
        int sum = 0;
        int begin = 0;
        int end = height.length - 1;

        if (height.length <= 2) {
            return sum;
        }

        while (begin != end) {
            for (int i = begin; i < end; i++) {
                if (height[i+1] >= height[i]) {
                    begin = begin + 1;
                } else {
                    if (height[i] <= height[end]) {
                        sum = sum + height[i] - height[i+1];
                        height[i+1] = height[i];
                        begin = begin + 1;
                    } else {
                        break;
                    }
                }
            }
            for (int i = end; i > begin; i--) {
                if (height[i-1] >= height[i]) {
                    end = end - 1;
                } else {
                    if (height[i] <= height[begin]) {
                        sum = sum + height[i] - height[i-1];
                        height[i-1] = height[i];
                        end = end - 1;
                    } else {
                        break;
                    }
                }
            }
        }
        return sum;
    }

//    public static void main(String[] args) {
//        Solution42 solution = new Solution42();
//        int res = solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
//        System.out.println(res);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
