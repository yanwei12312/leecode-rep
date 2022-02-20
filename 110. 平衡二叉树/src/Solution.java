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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.left = new TreeNode(4);
        root.right.right.left.right = new TreeNode(4);
        System.out.println(s.isBalanced(root));;
    }

    /**
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return depth(root) != -1;
    }

    int depth(TreeNode root) {
        if(root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);

        if(left == -1 || right == -1 || Math.abs(left-right) > 1) {
            return -1;
        }
        return Math.max(left,right) + 1;

    }

}
