package BinaryTree;
//力扣104

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    //递归
    public int maxDepth1(TreeNode root) {
        // 递归终止条件：空节点深度为0
        if (root == null) {
            return 0;
        }

        // 分别计算左右子树的深度
        int leftDepth = maxDepth1(root.left);
        int rightDepth = maxDepth1(root.right);

        // 当前节点的深度 = 左右子树深度的较大值 + 1（当前节点）
        return Math.max(leftDepth, rightDepth) + 1;
    }

    //迭代法
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }
}
