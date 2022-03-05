
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

    private int res = 0;

    public int sumNumbers(TreeNode root) {
        getSum(root,0);
        return res;
    }

    private void getSum(TreeNode root,int num) {
        if(root == null) return ;
        num = num*10 + root.val;
        if(root.left == null && root.right == null) {
            res += num;
            return ;
        }
        getSum(root.left,num);
        getSum(root.right,num);
    }

}
