package BinaryTree;
//力扣105. 从前序与中序遍历序列构造二叉树

import java.util.HashMap;
import java.util.Map;

public class ConstructABinaryTreeFromPreorderAndInorderTraversalSequences {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 哈希表记录中序序列中值到索引的映射，便于快速定位根节点位置
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        // 调用递归辅助函数
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1,
                indexMap);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd,
                           Map<Integer, Integer> indexMap) {
        // 递归终止条件：序列无效
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // 先序第一个节点是根节点
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // 根节点在中序中的位置
        int rootIndex = indexMap.get(rootVal);
        // 左子树的节点个数
        int leftSize = rootIndex - inStart;

        // 递归构建左子树
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, rootIndex - 1,
                indexMap);
        // 递归构建右子树
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, rootIndex + 1, inEnd,
                indexMap);

        return root;
    }
}
