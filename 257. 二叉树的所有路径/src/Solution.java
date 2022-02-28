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

    public List<String> binaryTreePaths(TreeNode root) {
        // 结果集
        List<String> result = new ArrayList<>();
        if(root != null) {
            getPath(root,result,"");
        }
        return result;
    }

    private void getPath(TreeNode root,List<String> result,String path) {
        // 当叶子节点时，将路径添加到结果集中
        if(root.left == null && root.right == null) {
            path += root.val;
            result.add(path);
            return;
        }
        // 非叶子节点拼接字符串
        path = path + root.val + "->";

        // 左子树不为空继续遍历
        if(root.left != null) getPath(root.left,result,path);
        // 右子树不为空继续遍历
        if(root.right != null) getPath(root.right,result,path);
    }

}
