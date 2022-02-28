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

    int result = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if(root != null) {
            getSumLeft(root,false);
        }
        return result;
    }

    private void getSumLeft(TreeNode root,boolean flag) {
        if(root.left == null && root.right == null) {
            if(flag) result += root.val;
        }
        if(root.left != null) getSumLeft(root.left,true);
        if(root.right != null) getSumLeft(root.right,false);
    }

}
