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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            // 都是null返回true
            return true;
        } else if (p == null || q == null) {
            // 有一个null返回false
            return false;
        } else if (p.val != q.val) {
            // 不等返回false
            return false;
        }
        // 相等继续比较
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

}
