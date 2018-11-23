package bigf.BinarySearch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

public class LCA {

    // recursive
    public TreeNode lowestCommonAncestorR(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestorR(root.left, p, q);
        TreeNode right = lowestCommonAncestorR(root.right, p, q);
        if (right != null && left != null) {
            return root;
        }
        return left == null ? right : left;
    }

    //iterative
    public TreeNode lowestCommonAncestorI(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        parent.put(root, null);
        stack.push(root);
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        HashSet<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = parent.get(p);
        }

        while (!set.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }
}
