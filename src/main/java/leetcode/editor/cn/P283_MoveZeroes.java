package leetcode.editor.cn;
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
//
// Related Topics 数组 双指针 👍 2441 👎 0


public class P283_MoveZeroes {
    public static void main(String[] args) {
        Solution solution =  new P283_MoveZeroes().new Solution();
        solution.moveZeroes(new int[]{0, 1, 0, 3, 12});
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    public void moveZeroes(int[] nums) {
        for (int i = nums.length-1; i >=0; i--) {
            if (nums[i] == 0) {
                move(nums, i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    private void move(int[] nums, int k) {
        while (k <= nums.length-2 && nums[k+1] != 0) {
            nums[k] = nums[k+1];
            nums[k+1] = 0;
            k++;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
