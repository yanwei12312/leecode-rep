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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(s.maxDepth(root));;
    }

    int res = 0;
    public int maxDepth(TreeNode root) {
        int depth = 0;

        getDept(root,depth);
        return res;
    }

    public void getDept(TreeNode root,int depth) {
        if(root == null) return;
        depth++;
        res = Math.max(res,depth);
        getDept(root.left,depth);
        getDept(root.right,depth);
        depth--;
    }

}
