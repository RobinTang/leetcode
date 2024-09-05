package leetcode.editor.cn;

//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 589 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSumIi{
    public static void main(String[] args) {
    Solution solution = new CombinationSumIi().new Solution();
    int[] arr = {1,2,5,1,2};
    System.out.println(solution.combinationSum2(arr, 7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(candidates, target, 0, list1, list2);
        return list1;
    }

    private void dfs(int[] candidates, int target, int idx, List<List<Integer>> result, List<Integer> temp) {
        if (target == 0) {
            boolean contain = false;
            for (List<Integer> list : result) {
                boolean same = true;
                if (list.size() == temp.size()) {
                    for (int i=0; i<list.size(); i++) {
                        if (!list.get(i).equals(temp.get(i))) {
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
                result.add(new ArrayList<>(temp));
            }

            return;
        }
        if (idx == candidates.length) {
            return;
        }
        dfs(candidates, target, idx+1, result, temp);
        if (target-candidates[idx] >= 0) {
            temp.add(candidates[idx]);
            dfs(candidates, target-candidates[idx], idx+1, result, temp);
            temp.remove(temp.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

