


/**
 * @author yw
 * @since 2022/02/20
 */

class Solution {
    public void moveZeroes(int[] nums) {
        int length = nums.length;

        int start = 0;
        for(int i=0;i<length;i++) {
            if(nums[i] != 0) {
                nums[start++] = nums[i];
            }
        }

        for(int i=start;i<length;i++) {
            nums[start++] = 0;
        }

    }
}
