package leetcode.editor.cn;

//给定一个三角形 triangle ，找出自顶向下的最小路径和。 
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
// 
//
// 示例 2： 
//
// 
//输入：triangle = [[-10]]
//输出：-10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -104 <= triangle[i][j] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
// 
// Related Topics 数组 动态规划 
// 👍 766 👎 0


import java.util.*;

class Triangle{
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(-1));
        triangle.add(Arrays.asList(-2,-3));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));

        Solution solution = new Triangle().new Solution();
        System.out.println(triangle);
        System.out.println(solution.minimumTotal(triangle));
        System.out.println(solution.minimumTotal3(triangle));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        public int minimumTotal(List<List<Integer>> triangle) {
            int[] arr = new int[triangle.size()];

            for (int i=triangle.size()-1; i>=0; i--) {
                for(int j=0; j<triangle.get(i).size(); j++) {
                    if (j < triangle.size() - 1) {
                        int min = Math.min(arr[j], arr[j + 1]);
                        arr[j] = triangle.get(i).get(j) + min;
                    } else {
                        arr[j] = triangle.get(i).get(j) + arr[j];
                    }
                }
            }
            return arr[0];
        }

        public int minimumTotal3(List<List<Integer>> triangle) {
            return dfs(triangle, 0, 0);
        }

        private int dfs(List<List<Integer>> triangle, int i, int j) {
            if (i == triangle.size()) {
                return 0;
            }
            int a = triangle.get(i).get(j);
            return Math.min(dfs(triangle, i+1, j) + a, dfs(triangle, i+1, j+1) + a);
        }


//        private int minimumTotal2(List<List<Integer>> triangle) {
//        List<Integer> list = new ArrayList<>();
//        dfs(triangle, list, 0, 0, 0);
//        Collections.sort(list);
//        return list.get(0);
//        }
//
//        private void dfs(List<List<Integer>> triangle, List<Integer> list, int sum, int idx, int idj) {
//            if (idx == triangle.size() -1) {
//                sum = sum + triangle.get(idx).get(idj);
//                list.add(sum);
//                return;
//            }
//            sum = sum + triangle.get(idx).get(idj);
//            dfs(triangle, list, sum, idx + 1, idj);
//            dfs(triangle, list, sum, idx + 1, idj +1);
//            sum = sum - triangle.get(idx).get(idj);
//        }
}
//leetcode submit region end(Prohibit modification and deletion)

}

