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

    public TreeNode sortedArrayToBST(int[] nums) {
        // 左右等分建立左右子树，中间节点作为子树根节点，递归该过程
        return nums == null ? null : sortedArrayToBST(nums,0,nums.length);
    }

    public TreeNode sortedArrayToBST(int[] nums,int start, int end) {
        if(start == end) return null;
        // 另外需要注意的是，求中点不要用 int mid = (start + end)/2，有溢出风险，稳妥的方法是 int mid = start + (end-start)/2。
        int mid = start+(end-start)/2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums,start,mid);
        root.right = sortedArrayToBST(nums,mid+1,end);
        return root;
    }

}
