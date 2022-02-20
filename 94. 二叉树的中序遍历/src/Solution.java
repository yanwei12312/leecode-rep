import java.util.ArrayList;
import java.util.List;

/**
 * @author yw
 * @since 2022/02/20
 */

/**
 * Definition for a binary tree node.
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        // 前序遍历
        inorder(root.left, res);
        // 中序遍历
        res.add(root.val);
        inorder(root.right, res);
        // 后序遍历
    }
}
