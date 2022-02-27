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

}
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root != null) {
            getPostOrder(root,result);
        }
        return result;
    }

    private void getPostOrder(TreeNode root,List<Integer> result) {
        if(root == null) return;
        getPostOrder(root.left,result);
        getPostOrder(root.right,result);
        // 后序遍历
        result.add(root.val);

}
