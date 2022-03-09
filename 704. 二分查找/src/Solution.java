/**
 * @author yw
 * @since 2022/02/20
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] aa = new int[]{-1,0,3,5,9,12};
        System.out.println(s.search(aa,9));;
    }

    public int search(int[] nums, int target) {
        int length = nums.length;
        int res = -1;
        if(length > 0) {
            int begin = 0;
            int end = length-1;

            while(begin<=end) {
                int mid = (end - begin) / 2 + begin;
                if(nums[mid] == target) {
                    res = mid;
                    break;
                }else if(nums[mid] > target) {
                    end = mid - 1;
                }else {

                    begin = mid + 1;
                }


            }
        }



        return res;
    }

}
