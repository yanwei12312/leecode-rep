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

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        if(root.left != null) invertTree(root.left);
        if(root.right != null) invertTree(root.right);
        invert(root);
        return root;
    }

    public TreeNode invert(TreeNode node) {
        if (node == null) return node;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp; // 简简单单交换左右节点
        return node;
    }

}
