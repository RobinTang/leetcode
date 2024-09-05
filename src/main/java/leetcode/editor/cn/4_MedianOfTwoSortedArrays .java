package leetcode.editor.cn;
// [4]寻找两个正序数组的中位数

//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治 
// 👍 4993 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mid2 = (nums1.length + nums2.length) / 2;
        int mid1 = mid2;
        if ((nums1.length + nums2.length) % 2 == 0) {
            mid1 = mid2 - 1;
        }

        int i = 0, j = 0;
        String full = null;
        boolean alone = false;

        if (nums1.length == 0 && nums2.length > 0) {
            alone = true;
            full = "1";
        } else if (nums2.length == 0) {
            alone = true;
            full = "2";
        }

        int targ1 = 0;
        int targ2 = 0;
        while ((i+j) < mid2) {
            if (full == "2" && alone) {
                if ((i+j) == mid1) {
                    targ1 = nums1[i];
                }
                i = i + 1;
                continue;
            } else if (full == "1" && alone) {
                if ((i+j) == mid1) {
                    targ1 = nums2[j];
                }
                j = j + 1;
                continue;
            }
            if (nums1[i] <= nums2[j]) {
                if ((i+j) == mid1) {
                    targ1 = nums1[i];
                }

                if (full == "1") {
                    alone = true;
                }
                i = i + 1;
                if (i >= nums1.length -1) {
                    full = "1";
                }
                if (i > nums1.length -1) {
                    alone = true;
                }
            } else {
                if ((i+j) == mid1) {
                    targ1 = nums2[j];
                }
                if (full == "2") {
                    alone = true;
                }
                j = j + 1;
                if (j >= nums2.length -1) {
                    full = "2";
                }
                if (j > nums2.length -1) {
                    alone = true;
                }
            }
        }

        if (!alone) {
            if (nums1[i] <= nums2[j]) {
                targ2 = nums1[i];
            } else {
                targ2 = nums2[j];
            }
        } else {
            if (full == "2") {
                targ2 = nums1[i];
            } else {
                targ2 = nums2[j];
            }
        }

        if (mid2 > mid1) {
           return  (targ1 + targ2) / 2.0;
        }
        return targ2;
    }

//    public static void main(String[] args) {
//        Solution4 solution = new Solution4();
//        int[] l1 = new int[]{2};
//        int[] l2 = new int[]{2};
//        double res = solution.findMedianSortedArrays(l1, l2);
//        System.out.println(res);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
