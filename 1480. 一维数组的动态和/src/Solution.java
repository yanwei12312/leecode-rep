


/**
 * @author yw
 * @since 2022/02/20
 *
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * 请返回 nums 的动态和。
 *
 */

class Solution {

    public static void main(String[] args) {
    }

    public int[] runningSum(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums;
        }
        for (int i = 1; i < length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }
}
