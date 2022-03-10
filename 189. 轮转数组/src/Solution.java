


/**
 * @author yw
 * @since 2022/02/20
 */

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] aa = new int[]{-7,-3,2,3,11};
        s.rotate(aa,2);
    }

    // 使用临时数组
    // public void rotate(int[] nums, int k) {
    //     int length = nums.length;
    //     int[] res = new int[length];
    //     for(int i=0;i<length;i++) {
    //         int j = (i+k) % length;
    //         res[j] = nums[i];
    //     }
    //     for(int i=0;i<length;i++) {
    //         nums[i] = res[i];
    //     }

    // }
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int length = nums.length;
        // 全部反转
        reverse(nums,0,length-1);
        // 反转前k个
        reverse(nums,0,k-1);
        // 反转后length-k个
        reverse(nums,k,length-1);
    }

    public void reverse(int[] nums,int start,int end) {
        while(start <= end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
