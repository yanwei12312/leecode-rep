


/**
 * @author yw
 * @since 2022/02/20
 */

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] aa = new int[]{-7,-3,2,3,11};
        int[] ints = s.sortedSquares(aa);
        System.out.println(ints);
    }

    public int[] sortedSquares(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int[] res = new int[nums.length];
        int index = res.length - 1;
        while(l<=r) {
            if(nums[l] * nums[l] > nums[r] * nums[r]) {
                res[index--] = nums[l] * nums[l++];
            } else {
                res[index--] = nums[r] * nums[r--];
            }
        }
        return res;
    }
}
