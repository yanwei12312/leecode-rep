import java.util.ArrayList;
import java.util.Arrays;
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
        int[] a = new int[]{1,2,4,7,3,5,6,8};
        int[] b = new int[]{4,7,2,1,5,3,8,6};
        Solution s = new Solution();
        TreeNode treeNode = s.buildTree(a, b);
        System.out.println(treeNode);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for(int i=0;i<preorder.length;i++) {
            if(root.val == inorder[i]) {
                root.left = buildTree(Arrays.copyOfRange(preorder,1,i+1), Arrays.copyOfRange(inorder,0,i));
                root.right = buildTree(Arrays.copyOfRange(preorder,i+1,preorder.length),Arrays.copyOfRange(inorder,i+1,inorder.length));
                break;
            }
        }
        return root;

    }

}
