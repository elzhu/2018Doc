package old;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class preorder {

    //Recursive Solution
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root != null) {
            preorderHelper(root, res);
        }
        return res;
    }
    public void preorderHelper(Node root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
        }
        List<Node> childern = root.children;
        if (childern != null) {
            for (Node child : childern) {
                preorderHelper(child, res);
            }
        }
    }

    //Iterative Solution
    public List<Integer> preorderIterative(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Stack<Node> stack = new Stack<Node>();
        stack.add(root);
        while (!stack.empty()) {
           root = stack.pop();
           res.add(root.val);
           for (int i = root.children.size()- 1; i >= 0; i--) {
               stack.add(root.children.get(i));
           }
       }
        return res;
    }
}
