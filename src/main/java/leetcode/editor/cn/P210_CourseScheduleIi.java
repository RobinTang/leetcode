package leetcode.editor.cn;
//现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 
//prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。 
//
// 
// 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。 
// 
//
// 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：[0,1]
//解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
// 
//
// 示例 2： 
//
// 
//输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//输出：[0,2,1,3]
//解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
//因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。 
//
// 示例 3： 
//
// 
//输入：numCourses = 1, prerequisites = []
//输出：[0]
// 
//
// 
//提示：
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= numCourses * (numCourses - 1) 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// ai != bi 
// 所有[ai, bi] 互不相同 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 967 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P210_CourseScheduleIi {
    public static void main(String[] args) {
        Solution solution =  new P210_CourseScheduleIi().new Solution();
        int n = 4;
        int[][] arr = {{1,0}, {2,0}, {3,1}, {3,2}};
        solution.findOrder(n, arr);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < prerequisites.length; i++) {
            Node parent = null;
            for (Node node : nodeList) {
                parent = exists(node, prerequisites[i][1]);
            }
            if (parent == null) {
                parent = new Node(prerequisites[i][1]);
                nodeList.add(parent);
            }

            Node cur = null;
            for (Node node : nodeList) {
                cur = exists(node, prerequisites[i][0]);
            }
            if (parent != null) {
                if (cur == null) {
                    parent.childs.add(new Node(prerequisites[i][0]));
                } else {
                    if (exists(parent, cur.value) != null) {
                        return new int[]{};
                    }
                    parent.childs.add(cur);
                }
            }

        }
        return toArray(nodeList);
    }

    void addToArray(Node n, ArrayList<Integer> arr) {
        arr.add(n.value);
        for (Node child : n.childs) {
            addToArray(child, arr);
        }
    }

    int[] toArray(List<Node> list) {
        ArrayList<Integer> res = new ArrayList<>();
        for (Node node : list) {
            addToArray(node, res);
        }
        Integer[] i = res.toArray(new Integer[res.size()]);
        int[] ires = new int[res.size()];
        for (int j = 0; j < res.size(); j++) {
            ires[j] = i[j];
        }
        return ires;
    }

    class Node {
        List<Node> childs = new LinkedList<>();
        int value;

        Node(int v) {
            this.value = v;
        }
    }

    Node exists(Node n, int value) {
        if (n == null) {
            return null;
        }
        if (n.value == value) {
            return n;
        }
        if (!n.childs.isEmpty()) {
            for(Node nn:n.childs) {
                return exists(nn, value);
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
