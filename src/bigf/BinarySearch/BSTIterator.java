package bigf.BinarySearch;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        addLeftMost(root);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        if (!hasNext()) {
            return -1;
        }
        TreeNode cur = stack.pop();
        addLeftMost(cur.right);
        return cur.val;
    }

    //add all left most nodes for a tree of which the root is node
    private void addLeftMost(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

}
