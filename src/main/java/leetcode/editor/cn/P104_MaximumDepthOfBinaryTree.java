package leetcode.editor.cn;
//给定一个二叉树 root ，返回其最大深度。 
//
// 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：root = [1,null,2]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数量在 [0, 10⁴] 区间内。 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1834 👎 0


public class P104_MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution =  new P104_MaximumDepthOfBinaryTree().new Solution();
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.left = left;
        left.right = right;
        System.out.println(solution.maxDepth(root));
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {


    private int calMaxDepth(TreeNode root) {
        int maxDepth = 0;
        if (root != null) {
            maxDepth++;
            if (root.left != null) {
                maxDepth = Math.max(maxDepth, calMaxDepth(root.left) + 1);
            }
            if (root.right != null) {
                maxDepth = Math.max(maxDepth, calMaxDepth(root.right) + 1);
            }
        }
        return maxDepth;
    }

    public int maxDepth(TreeNode root) {
        return calMaxDepth(root);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
