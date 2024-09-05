package leetcode.editor.cn;// [100]相同的树

//给定两个二叉树，编写一个函数来检验它们是否相同。 
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 示例 1: 
//
// 输入:       1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true 
//
// 示例 2: 
//
// 输入:      1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
// 
//
// 示例 3: 
//
// 输入:       1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
// 
// Related Topics 树 深度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;

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
class Solution100 {

    private boolean isSameNode(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        if ((p.right == null && q.right !=null) ||
            (q.right == null && p.right !=null) ||
            (p.left == null && q.left !=null) ||
            (q.left == null && p.left !=null)) {
            return false;
        }
        return p.val == q.val;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (!isSameNode(p, q)) {
            return false;
        }
        if (p != null) {
            ArrayDeque<TreeNode> stackP = new ArrayDeque<>();
            ArrayDeque<TreeNode> stackQ = new ArrayDeque<>();
            stackP.push(p);
            stackQ.push(q);

            while (!stackP.isEmpty()) {
                TreeNode nodeP = stackP.pop();
                TreeNode nodeQ = stackQ.pop();

                if (!isSameNode(nodeP, nodeQ)) {
                    return false;
                }

                if (nodeP.right != null) {
                    stackP.push(nodeP.right);
                    stackQ.push(nodeQ.right);
                }

                if (nodeP.left != null) {
                    stackP.push(nodeP.left);
                    stackQ.push(nodeQ.left);
                }
            }
            return stackQ.isEmpty();
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
