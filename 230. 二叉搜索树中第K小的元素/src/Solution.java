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

    // public int kthSmallest(TreeNode root, int k) {
    //     Stack<TreeNode> stack = new Stack<>();

    //     int i=0;
    //     while(root != null || !stack.isEmpty()) {
    //         while(root != null) {
    //             stack.push(root);
    //             root = root.left;
    //         }
    //         root = stack.pop();
    //         i++;
    //         if(i == k) {
    //             return root.val;
    //         }
    //         root = root.right;
    //     }
    //     return -1;
    // }


    // 中序遍历
    List<Integer> res = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        dfs(root);
        return res.get(k-1);
    }

    public void dfs(TreeNode node){
        if(node == null) return;
        dfs(node.left);
        res.add(node.val);
        dfs(node.right);
    }

}
