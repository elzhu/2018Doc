package bigf.Tree;

public class longestUnivaluePath {
    int max_length = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root != null) {
            nodeTraverse(root);
        }
        return max_length;
    }

    public int nodeTraverse(TreeNode node){
        int leftPath = 0;
        int rightPath = 0;
        if (node.left == null && node.right == null) {
            return leftPath + rightPath;
        }
        if (node.left != null) {
            if (node.left.val == node.val) {
                leftPath = nodeTraverse(node.left) + 1;
            } else {
                leftPath = nodeTraverse(node.left)
            }
        }
        if (node.right != null) {
            if (node.right.val == node.val) {
                rightPath = nodeTraverse(node.right);
            } else {
                rightPath = nodeTraverse(node.right);
            }
        }

        if ((rightPath + leftPath) >= max_length) {
            max_length = leftPath + rightPath;
        }
        return Math.max(rightPath, leftPath);
    }

    public int longestUnivaluePathDFS(TreeNode root) {
        int[] res = new int[1];

        if (root != null) {
            dfs(root, res);
        }

        return res[0];
    }
    private int dfs(TreeNode node, int[] res) {
        int l = node.left != null ? dfs(node.left, res) : 0; // Longest-Univalue-Path-Start-At - left child
        int r = node.right != null ? dfs(node.right,res) : 0; // Longest-Univalue-Path-Start-At - right child
        int resl = node.left != null && node.left.val == node.val ? l + 1 : 0;
        int resr = node.right != null && node.right.val == node.val ? r + 1 : 0;
        res[0] = Math.max(res[0], resl + resr);
        return Math.max(resl, resr);

    }
}
