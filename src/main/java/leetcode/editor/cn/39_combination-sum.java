package leetcode.editor.cn;
//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1366 👎 0

import java.util.ArrayList;
import java.util.List;

class CombinationSum{
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
        int[] arr = {2, 3, 6, 7};
        System.out.println(solution.combinationSum(arr, 7));
    }
      
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(candidates, target, list1, list2, 0);
        return list1;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            boolean contain = false;
            for (List<Integer> list : ans) {
                boolean same = true;
                if (list.size() == combine.size()) {
                    for (int i=0; i<list.size(); i++) {
                        if (!list.get(i).equals(combine.get(i))) {
                            same = false;
                        }
                    }
                } else {
                    same = false;
                }
                if (same) {
                    contain = true;
                    break;
                }
            }
            if (!contain) {
                ans.add(new ArrayList<>(combine));
            }
        }
        dfs(candidates, target, ans, combine, idx+1);
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target-candidates[idx], ans, combine, idx);
            combine.remove(combine.size() -1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}