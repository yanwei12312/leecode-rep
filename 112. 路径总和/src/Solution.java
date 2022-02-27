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
        TreeNode node = new TreeNode(1,new TreeNode(2),null);

        System.out.println(s.hasPathSum(node,1));;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        return getPathSum(root,targetSum,0);

    }

    public boolean getPathSum(TreeNode root, int targetSum, int total) {
        if(root.left == null && root.right == null){
            if(targetSum == total+root.val) {
                return true;
            } else {
                return false;
            }
        }
        total += root.val;
        if(root.left != null) {
            boolean left = getPathSum(root.left,targetSum,total);
            if(left) return true;
        }
        if(root.right != null) {
            boolean right = getPathSum(root.right,targetSum,total);
            if(right) return true;
        }
        return false;
    }

}
