package BinaryTree;
//力扣101
import java.util.LinkedList;
import java.util.Queue;

public class SymmetricBinaryTree {

    // 方法1: 递归解法 - 时间复杂度O(n)，空间复杂度O(h)，h为树的高度
    public boolean isSymmetricRecursive(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        // 如果两个节点都为空，对称
        if (left == null && right == null) return true;
        // 如果只有一个节点为空，不对称
        if (left == null || right == null) return false;
        // 如果节点值不相等，不对称
        if (left.val != right.val) return false;
        // 递归检查左子树的左节点和右子树的右节点，以及左子树的右节点和右子树的左节点
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    // 方法2: 迭代解法（使用队列） - 时间复杂度O(n)，空间复杂度O(n)
    public boolean isSymmetricIterative(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        // 将左右子节点成对加入队列
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            // 如果两个节点都为空，继续检查下一对
            if (left == null && right == null) continue;

            // 如果只有一个节点为空，或者节点值不相等，不对称
            if (left == null || right == null || left.val != right.val) {
                return false;
            }

            // 将子节点按镜像对称的方式加入队列
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }

        return true;
    }

    // 方法3: 迭代解法（使用栈） - 时间复杂度O(n)，空间复杂度O(n)
    public boolean isSymmetricStack(TreeNode root) {
        if (root == null) return true;

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.isEmpty()) {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();

            if (left == null && right == null) continue;
            if (left == null || right == null || left.val != right.val) {
                return false;
            }

            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }

        return true;
    }

    // 测试代码
    public static void main(String[] args) {
        SymmetricBinaryTree checker = new SymmetricBinaryTree();

        // 构建一个对称的二叉树
        //      1
        //     / \
        //    2   2
        //   / \ / \
        //  3  4 4  3
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);

        System.out.println("对称二叉树测试:");
        System.out.println("递归解法: " + checker.isSymmetricRecursive(root1)); // true
        System.out.println("迭代队列解法: " + checker.isSymmetricIterative(root1)); // true
        System.out.println("迭代栈解法: " + checker.isSymmetricStack(root1)); // true

        // 构建一个不对称的二叉树
        //      1
        //     / \
        //    2   2
        //     \   \
        //      3   3
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);

        System.out.println("\n不对称二叉树测试:");
        System.out.println("递归解法: " + checker.isSymmetricRecursive(root2)); // false
        System.out.println("迭代队列解法: " + checker.isSymmetricIterative(root2)); // false
        System.out.println("迭代栈解法: " + checker.isSymmetricStack(root2)); // false

        // 空树测试
        System.out.println("\n空树测试:");
        System.out.println("递归解法: " + checker.isSymmetricRecursive(null)); // true
        System.out.println("迭代队列解法: " + checker.isSymmetricIterative(null)); // true
    }
}