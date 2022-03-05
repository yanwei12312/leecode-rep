import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

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

public class BSTIterator {

    // 1.利用list的迭代器
    // private List<Integer> list = new ArrayList<>();
    // TreeNode root;
    // Iterator<Integer> itera;

    // private TreeNode cur;

    // void dfs(TreeNode current) {
    //     if(current.left != null) {
    //         dfs(current.left);
    //     }
    //     list.add(current.val);
    //     if(current.right != null) {
    //         dfs(current.right);
    //     }
    // }

    // public BSTIterator(TreeNode root) {
    //     this.root = root;
    //     dfs(root);
    //     itera = list.iterator();
    // }

    // public int next() {
    //     return itera.next();
    // }

    // public boolean hasNext() {
    //     return itera.hasNext();
    // }


    // 2.本题是中序遍历迭代解法的实际应用，很多回复贴的代码思路是对的，但实现过程一言难尽，贴一个清晰好理解的：
    private Stack<TreeNode> stack ;

    private TreeNode cur;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        this.cur = root;
    }

    public int next() {
        if(hasNext()) {
            TreeNode node = stack.pop();
            cur = node.right;
            return node.val;
        }
        return -1;
    }

    public boolean hasNext() {
        if( cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.add(cur);
                cur = cur.left;            }
        }
        return !stack.isEmpty();
    }
}
