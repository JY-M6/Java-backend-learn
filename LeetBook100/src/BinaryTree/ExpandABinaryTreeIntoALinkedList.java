package BinaryTree;
//力扣114 展开二叉树为链表

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class ExpandABinaryTreeIntoALinkedList {
    // 方法一：递归（后序处理）
    public void flatten(TreeNode root) {
        if (root == null) return;

        // 递归展开左右子树
        flatten(root.left);
        flatten(root.right);

        // 暂存右子树
        TreeNode temp = root.right;
        // 将左子树移到右边
        root.right = root.left;
        root.left = null;

        // 找到当前右子树的最后一个节点
        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        // 把原来的右子树接上
        cur.right = temp;
    }
}