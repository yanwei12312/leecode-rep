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

    /**
     * 递归比较左子树和右子树的深度
     */
    // public int minDepth(TreeNode root) {
    //     if(root == null) return 0;
    //     if(root.left == null && root.right == null ) {
    //         return 1;
    //     }
    //     int ans = Integer.MAX_VALUE;
    //     if(root.left != null) {
    //         ans = Math.min(minDepth(root.left),ans);
    //     }
    //     if(root.right != null) {
    //         ans = Math.min(minDepth(root.right),ans);
    //     }
    //     return ans + 1;
    // }

    /**
     * 递归找出左子树和右子树的最小深度
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left != null && root.right == null) return minDepth(root.left) + 1;
        if(root.right != null && root.left == null) return minDepth(root.right) + 1;
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;

    }

}
