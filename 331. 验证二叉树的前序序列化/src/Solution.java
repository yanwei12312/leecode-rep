


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

    public boolean isValidSerialization(String preorder) {

        int leafCount = 0;
        int nodeCount = 1;

        for(char ch:preorder.toCharArray()) {
            if(leafCount > nodeCount - leafCount) return false;
            if(ch == ',') nodeCount++;
            if(ch == '#') leafCount++;
        }
        return (nodeCount - leafCount) + 1 == leafCount;

    }

}
