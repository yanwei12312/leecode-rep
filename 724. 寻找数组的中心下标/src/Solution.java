


/**
 * @author yw
 * @since 2022/02/20
 *
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 *
 */

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[]{1, 7, 3, 6, 5, 6};
        solution.pivotIndex(a);

    }

    public int pivotIndex(int[] nums) {
        int res = -1;
        int length = nums.length;
        if (length == 1) {
            return 0;
        }
        int i = 0;
        while (i <= length - 1) {
            int left = 0;
            int right = 0;
            for (int j = 0; j < i; j++) {
                left += nums[j];
            }
            for (int j = length - 1; j > i; j--) {
                right += nums[j];
            }
            if (left == right) {
                res = i;
                break;
            }
            i++;
        }
        return res;
    }
}
