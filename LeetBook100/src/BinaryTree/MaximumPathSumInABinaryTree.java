package BinaryTree;
//力扣124. 二叉树中的最大路径和
public class MaximumPathSumInABinaryTree {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) return 0;

        // 递归计算左右子节点的最大贡献（如果为负则取0，即舍弃该分支）
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 以当前节点为拐点的路径和
        int priceNewPath = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, priceNewPath);

        // 返回当前节点对父节点的最大单侧贡献
        return node.val + Math.max(leftGain, rightGain);
    }
}
