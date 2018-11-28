package bigf.Tree;

import java.util.ArrayList;
import java.util.List;

public class isSubtree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }

        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSubtreeHelper(s, t);
    }

    private boolean isSubtreeHelper(TreeNode s, TreeNode t) {
        if (s == null && t == null)
        {
            return true;
        }

        if (s == null || t == null)
        {
            return false;
        }

        return isSubtreeHelper(s.left, t.left) && (s.val == t.val) && isSubtreeHelper(s.right, t.right);
    }

    // post order traversal
    int index = 0;
    List<Integer> list = new ArrayList<Integer>();
    boolean found = false;
    boolean begin = false;

    public boolean isSubtreePostOrderTraversal(TreeNode s, TreeNode t) {

        return found;
    }

    private void helper(TreeNode s) {
        if (found) {
            return;
        }

        if (s == null) {
            return;
        }
        helper(s.left);
        helper(s.right);

        if (index == list.size()) {
            index = 0;
            begin = false;
        }

        if (s.left == null && s.right == null) {
            if (s.val == list.get(index)) {
                begin = true;
            }
        }

        if (begin) {
            if (s.val == list.get(index)) {
                index++;
            } else {
                begin = false;
                index= 0 ;
            }
        }
        if (index == list.size()) {
            found = true;
        }
    }

    private void traversal(TreeNode t) {
        if (t == null) {
            return;
        }
        traversal(t.left);
        traversal(t.right);
        list.add(t.val);
    }
}
