import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author yw
 * @since 2022/02/20
 */

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Solution {

    public Node connect(Node root) {
        Queue<Node> q = new ArrayDeque<>();
        if (root != null) {
            q.offer(root);
        }

        while (!q.isEmpty()) {
            int n = q.size();
            Node node = q.poll();
            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
            for (int i = 1; i < n; i++) {
                node.next = q.poll();
                node = node.next;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return root;

    }

}
