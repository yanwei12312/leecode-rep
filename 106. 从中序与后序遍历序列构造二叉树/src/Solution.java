import java.util.Arrays;

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
        int[] a = new int[]{9,3,15,20,7};
        int[] b = new int[]{9,15,7,20,3};
        Solution s = new Solution();
        TreeNode treeNode = s.buildTree(a, b);
        System.out.println(treeNode);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        for(int i=0;i<inorder.length;i++) {
            if(inorder[i] == postorder[postorder.length-1]) {
                root.left = buildTree(Arrays.copyOfRange(inorder,0,i),Arrays.copyOfRange(postorder,0,i));
                root.right = buildTree(Arrays.copyOfRange(inorder,i+1,inorder.length),Arrays.copyOfRange(postorder,i,postorder.length-1));
            }
        }
        return root;

    }

}
