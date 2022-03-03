import java.util.*;

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


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root != null) {
            q.offer(root);
        }

        while(!q.isEmpty()) {
            int n = q.size();
            List<Integer> row = new ArrayList<>();

            for(int i=0;i<n;i++) {
                TreeNode node = q.poll();
                row.add(node.val);
                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
            }
            res.addFirst(row);
        }
        return res;

    }

}
