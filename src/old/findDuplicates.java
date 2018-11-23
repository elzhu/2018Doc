package old;

import java.util.*;

public class findDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                res.add(num);
            } else {
                set.add(num);
            }
        }
        return res;
    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res, int index) {
        if (root == null) {
            return;
        }
        if (index == res.size()) {
            res.add(root.val);
        } else {
            res.set(index, Math.max(root.val, res.get(index)));
        }
        helper(root.left, res, index + 1);
        helper(root.right, res, index + 1);
    }

    public List<Integer> largestValuesBFS(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int queueSize = root == null ? 0 : 1;
        while (queueSize > 0) {
            int largest = Integer.MIN_VALUE;
            for (int i = 0; i < queueSize; i++) {
                TreeNode current = queue.poll();
                largest = Math.max(largest, current.val);
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            res.add(largest);
            queueSize = queue.size();
        }
        return res;
    }
}
