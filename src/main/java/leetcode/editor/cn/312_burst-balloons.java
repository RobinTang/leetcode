package leetcode.editor.cn;

//有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。 
//
// 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i -
// 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。 
//
// 求所能获得硬币的最大数量。 
//
// 
//示例 1：
//
// 
//输入：nums = [3,1,5,8]
//输出：167
//解释：
//nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
//coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167 
//
// 示例 2： 
//
// 
//输入：nums = [1,5]
//输出：10
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 500 
// 0 <= nums[i] <= 100 
// 
// Related Topics 分治算法 动态规划 
// 👍 737 👎 0


import java.util.Arrays;
import java.util.HashMap;

class BurstBalloons {
    public static void main(String[] args) {
        Solution solution = new BurstBalloons().new Solution();
        int[] arr = {7, 9, 8, 0, 7, 1, 3, 5, 5, 2, 3, 3};
        System.out.println(solution.maxCoins(arr));

        // 逆序思考模型，寻找状态转移公式
        // 核心在于建模
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxCoins(int[] nums) {
            return maxCoins_2(nums);
        }

        public int maxCoins_2(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int n = nums.length;
            int[] arr = new int[n + 2];
            for (int i = 1; i <= n; ++i) {
                arr[i] = nums[i - 1];
            }
            arr[0] = 1;
            arr[n + 1] = 1;

            //记忆化数组
            int[][] cache = new int[n + 2][n + 2];
            for (int i = 0; i <= n + 1; ++i) {
                Arrays.fill(cache[i], -1);
            }
            return dfs(cache, arr, 0, n + 1);
        }

        private int dfs(int[][] cache, int[] arr, int left, int right) {
            //处理的范围是(left,right)，不在这个区间内的就不用处理了
            if (left >= right - 1) {
                return 0;
            }
            if (cache[left][right] != -1) {
                return cache[left][right];
            }
            int res = 0;
            //遍历(left,right)区间，每得到一个临时积分，就会将区间分成两部分
            //再递归遍历区间(left,i)和(i,right)，在(left,right)内选择arr[i]的积分是total + (left,i)和(i,right)之和
            for (int i = left + 1; i < right; ++i) {
                int total = arr[left] * arr[i] * arr[right];
                total += dfs(cache, arr, left, i) + dfs(cache, arr, i, right);
                res = Math.max(res, total);
            }
            cache[left][right] = res;
            return res;
        }

    public HashMap<String, Integer> map = new HashMap();

    public int maxCoins_1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int[] tmp = new int[nums.length - 1];
            StringBuilder bd = new StringBuilder();
            for (int j = 0; j < nums.length; j++) {
                bd.append("-");
                if (j < i) {
                    tmp[j] = nums[j];
                    bd.append(tmp[j]);
                }
                if (j > i) {
                    tmp[j - 1] = nums[j];
                    bd.append(tmp[j - 1]);
                }
            }
            int value = 0;
            if (i == 0) {
                value = nums[i] * nums[i + 1];
            } else if (i == nums.length - 1) {
                value = nums[i] * nums[i - 1];
            } else {
                value = nums[i - 1] * nums[i] * nums[i + 1];
            }
            int maxValue = 0;
            String key = bd.toString();
            if (map.containsKey(key)) {
                maxValue = map.get(key);
            } else {
                maxValue = maxCoins_1(tmp);
                map.put(key, maxValue);
            }
            max = Math.max(max, value + maxValue);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

