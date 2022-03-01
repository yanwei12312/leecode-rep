import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        TreeNode root = new TreeNode(1,new TreeNode(3,null,new TreeNode(2)),null);
        Solution s = new Solution();
        s.recoverTree(root);
        System.out.println(root);
    }

    TreeNode firstNode = null;
    TreeNode secondNode = null;
    TreeNode pre = null;

    public void recoverTree(TreeNode root) {
        inorder(root);
        if(firstNode != null && secondNode != null) {
            int temp;
            temp = firstNode.val;
            firstNode.val = secondNode.val;
            secondNode.val = temp;
        }

    }

    public void inorder(TreeNode root) {
        if(root == null) return ;

        inorder(root.left);

        if(firstNode == null && pre != null && pre.val >= root.val) {
            firstNode = pre;
        }

        if(firstNode != null && pre != null && pre.val >= root.val) {
            secondNode = root;
        }

        pre = root;

        inorder(root.right);
    }


}
