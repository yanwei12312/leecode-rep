import java.util.*;

/**
 * @author yw
 * @since 2022/02/20
 *
 *
 */

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {

    public static void main(String[] args) {
        List<Node> listNode = new ArrayList<>();
        List<Node> listNode3 = new ArrayList<>();
        listNode3.add(new Node(5));
        listNode3.add(new Node(6));
        listNode.add(new Node(3,listNode3));
        listNode.add(new Node(2));
        listNode.add(new Node(4));
        Node node = new Node(1,listNode);


        Solution solution = new Solution();
        List<Integer> preorder = solution.preorder(node);
        System.out.println(preorder);

    }

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        dfs(root,res);
        return res;
    }

    public void dfs(Node root, List<Integer> res) {
        if(root == null) return;
        res.add(root.val);
        for(Node node : root.children) {
            dfs(node,res);
        }
    }
}
