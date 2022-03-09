import java.util.LinkedList;

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

public class Codec {

    private String SEQ = ",";
    private String NULL = "";

    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        return dfs(root,builder).toString();
    }

    public StringBuilder dfs(TreeNode node,StringBuilder builder) {
        if(node == null) {
            builder.append(NULL).append(SEQ);
            return builder;
        }
        builder.append(node.val).append(SEQ);
        dfs(node.left,builder);
        dfs(node.right,builder);
        return builder;
    }
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList();
        for(String node : data.split(SEQ)) {
            nodes.add(node);
        }
        return des(nodes);
    }

    public TreeNode des(LinkedList<String> nodes) {
        if(nodes.isEmpty()) {
            return null;
        }

        String item = nodes.removeFirst();
        if(item == NULL) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(item));
        root.left = des(nodes);
        root.right = des(nodes);

        return root;
    }

}
