import java.util.*;

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
        List<List<Integer>> lists = s.zigzagLevelOrder(root);
        System.out.println(lists);
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        if(root != null) {
            s.push(root);
        }

        boolean flag = false;

        while(!s.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            List<TreeNode> nodeList = new ArrayList<>();
            int n = s.size();

            for(int i=0;i<n;i++) {
                TreeNode node = s.pop();
                nodeList.add(node);
                row.add(node.val);
            }
            for(int i=0;i<n;i++) {
                if(!flag) {
                    if(nodeList.get(i).left != null) {
                        s.push(nodeList.get(i).left);
                    }
                    if(nodeList.get(i).right != null) {
                        s.push(nodeList.get(i).right);
                    }
                } else {
                    if(nodeList.get(i).right != null) {
                        s.push(nodeList.get(i).right);
                    }
                    if(nodeList.get(i).left != null) {
                        s.push(nodeList.get(i).left);
                    }
                }
            }
            // 反转
            flag = !flag;
            res.add(row);
        }
        return res;
    }


}
