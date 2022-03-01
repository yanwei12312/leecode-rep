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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,new TreeNode(9,null,null),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        Solution s = new Solution();
        List<List<Integer>> lists = s.levelOrder(root);
        System.out.println(lists);
    }


    // DFS
    // List<List<Integer>> result = new ArrayList<>();
    // Set<Integer> depthSet = new HashSet<>();

    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     if(root != null) {
    //         int depth = 0;
    //         inorder(root,depth);
    //     }
    //     return result;
    // }

    // public void inorder(TreeNode root,int depth) {
    //     if(root == null) return;

    //     depth++;
    //     List<Integer> row = new ArrayList<>();
    //     if(!depthSet.contains(depth)) {
    //         depthSet.add(depth);
    //         result.add(row);
    //     }
    //     result.get(depth-1).add(root.val);

    //     inorder(root.left,depth);

    //     inorder(root.right,depth);
    //     depth--;

    // }

    // BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();

        List<List<Integer>> res = new ArrayList<>();
        if(root != null) {
            // 顶层入队
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
            res.add(row);
        }
        return res;
    }



}
