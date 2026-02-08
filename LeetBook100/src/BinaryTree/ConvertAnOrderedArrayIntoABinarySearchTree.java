package BinaryTree;
//力扣108. 将有序数组转换为二叉搜索树
public class ConvertAnOrderedArrayIntoABinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        // 递归终止条件：左边界大于右边界
        if (left > right) {
            return null;
        }

        // 选择中间元素作为根节点
        // 使用 (left + right) / 2 可能会出现整数溢出问题，可以使用 left + (right - left) / 2
        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        // 递归构建左子树和右子树
        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);

        return root;
    }
}
