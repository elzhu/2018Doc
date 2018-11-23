package bigf.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Zigzag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res =new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        ((LinkedList<TreeNode>) queue).add(root);
        boolean order = true;
        int size = 1;
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (order) {
                    temp.add(node.val);
                } else {
                    temp.add(0, node.val);
                }
                if (node.left != null) {
                    ((LinkedList<TreeNode>) queue).add(node.left);
                }
                if (node.right != null) {
                    ((LinkedList<TreeNode>) queue).add(node.right);
                }
            }
            order = !order;
            size = queue.size();
            res.add(temp);
        }
        return res;
    }
}
