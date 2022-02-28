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



    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        if(n == 0) return result;
        return getAns(1,n);
    }

    private List<TreeNode> getAns(int start,int end) {
        List<TreeNode> result = new ArrayList<>();
        if(start > end) {
            result.add(null);
            return result;
        }

        if(start == end) {
            TreeNode node = new TreeNode(start);
            result.add(node);
            return result;
        }

        for(int i=start;i<=end;i++) {
            List<TreeNode> leftTree = getAns(start,i-1);
            List<TreeNode> rightTree = getAns(i+1,end);
            for(TreeNode leftNode : leftTree) {
                for(TreeNode rightNode: rightTree) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    result.add(node);
                }
            }
        }
        return result;
    }

}
