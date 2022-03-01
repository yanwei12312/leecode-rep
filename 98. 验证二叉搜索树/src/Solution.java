import java.util.ArrayList;
import java.util.List;

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

    TreeNode pre = null;

    // 利用BST中序遍历得到结果集是升序的特性
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        if(!isValidBST(root.left)) {
            return false;
        }

        if(pre != null && pre.val >= root.val) {
            return false;
        }

        pre = root;

        return isValidBST(root.right);
    }

}
