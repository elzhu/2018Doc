package bigf.Tree;

import java.util.ArrayList;
import java.util.List;

public class FindLeaves {
    public static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        findLeavesHelper(result, root);
        return result;
    }

    private static int findLeavesHelper(List<List<Integer>> result, TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftLevel = findLeavesHelper(result, root.left);
        int rightLevel = findLeavesHelper(result, root.right);
        System.out.println("--------------------------------" );
        System.out.println("----leftLevel : " + leftLevel);
        System.out.println("----rightLevel : " + rightLevel);
        int level = 1 + Math.max(leftLevel,rightLevel);
        System.out.println("----level : " + level);
        System.out.println("----result.size() : " + result.size());
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        System.out.println("----result.get(level): " + result.get(level));
        System.out.println("----root.val: " + root.val);
        result.get(level).add(root.val);
        root.left = null;
        root.right = null;
        return level;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode left2 = new TreeNode(4);
        TreeNode right2 = new TreeNode(5);

        root.left = left;
        root.right = right;
        left.left = left2;
        left.right = right2;

        System.out.println(findLeaves(root));
    }
}
