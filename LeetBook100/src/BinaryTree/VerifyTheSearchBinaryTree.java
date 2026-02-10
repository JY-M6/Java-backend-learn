package BinaryTree;
//力扣98. 验证二叉搜索树
public class VerifyTheSearchBinaryTree {
    public static long min, max;
    public boolean isValidBST(TreeNode head) {

        if (head == null) {
            min = Long.MIN_VALUE;
            max = Long.MAX_VALUE;
            return true;
        }
        boolean lok = isValidBST(head.left);
        long lmin = min;
        long lmax = max;
        boolean rok = isValidBST(head.right);
        long rmin = min;
        long rmax = max;
        min =Math.min(Math.min(lmin, rmin), head.val);
        max =Math.max(Math.max(lmax, rmax), head.val);
        return lok && rok && (head.val > lmax) && (head.val < rmin);
    }
}
