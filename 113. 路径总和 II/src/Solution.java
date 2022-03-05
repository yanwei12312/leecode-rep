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

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode node = new TreeNode(5,new TreeNode(4,new TreeNode(11,new TreeNode(7),new TreeNode(2)),null),new TreeNode(8,new TreeNode(13),new TreeNode(4,new TreeNode(5),new TreeNode(1))));

        System.out.println(s.pathSum(node,22));;
    }

    List<List<Integer>> res = new ArrayList<>();

    int depth = 0;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root != null) {
            List<Integer> path = new ArrayList<>();
            getPath(root,targetSum,0,path);
        }
        return res;
    }

    public void getPath(TreeNode root, int targetSum, int total, List<Integer> path) {
        if(root.left == null && root.right == null) {
            total += root.val;
            if( total == targetSum) {
                path.add(root.val);
                List<Integer> newPath = new ArrayList<>();
                newPath.addAll(path);
                res.add(newPath);
                path.remove(depth);
            }
            return;
        }

        path.add(root.val);
        total += root.val;
        depth++;

        if(root.left != null) {
            getPath(root.left,targetSum,total,path);
        }


        if(root.right != null) {
            getPath(root.right,targetSum,total,path);
        }
        path.remove(depth-1);
        depth--;
    }

}
