package BinaryTree;
//力扣543 二叉树的直径
public class DiameterOfBinaryTree {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0; // 空节点深度为0
        }

        int leftDepth = dfs(node.left);
        int rightDepth = dfs(node.right);

        // 更新直径：经过当前节点的路径长度 = leftDepth + rightDepth
        diameter = Math.max(diameter, leftDepth + rightDepth);

        // 返回当前节点的深度
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
