import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root != null) {
            q.offer(root);
        }

        while(!q.isEmpty()) {
            int n = q.size();
            for(int i=0;i<n;i++) {
                TreeNode node = q.poll();
                if(i == n-1) {
                    res.add(node.val);
                }
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
        }
        return res;
    }

}
