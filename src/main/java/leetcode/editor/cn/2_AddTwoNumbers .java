package leetcode.editor.cn;
// [2]两数相加

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 7455 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode node = head;
        int init = 1;
        int res = 0;

        while (l1 != null && l2 != null) {
            int cur = l1.val + l2.val + res;

            if (init == 1) {
                init = 0;
            } else {
                node.next = new ListNode();
                node = node.next;
            }

            if (cur >= 10) {
                res = (cur - cur % 10) / 10;
                node.val = cur % 10;
            } else {
                res = 0;
                node.val = cur;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int cur = l1.val + res;
            node.next = new ListNode();
            node = node.next;

            if (cur >= 10) {
                res = (cur - cur % 10) / 10;
                node.val = cur % 10;
            } else {
                res = 0;
                node.val = cur;
            }
            l1 = l1.next;
        }

        while (l2 != null) {
            int cur = l2.val + res;
            node.next = new ListNode();
            node = node.next;

            if (cur >= 10) {
                res = (cur - cur % 10) / 10;
                node.val = cur % 10;
            } else {
                res = 0;
                node.val = cur;
            }
            l2 = l2.next;
        }

        if (res > 0) {
            node.next = new ListNode(res);
        }
        return head;
    }



    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        ListNode l1 = new ListNode(8, new ListNode(6, new ListNode(3)));

        ListNode l2 = new ListNode(7, new ListNode(9));
        ListNode res = solution.addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
