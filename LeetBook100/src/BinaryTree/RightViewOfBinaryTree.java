package BinaryTree;
// 199. 二叉树的右视图
import java.util.ArrayList;
import java.util.List;

public class RightViewOfBinaryTree {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        ans.add(root.val);
        rightView(root, ans, 0);
        return ans;
    }
    public void rightView(TreeNode root, List<Integer> ans, int level){
        if (root == null) return;
        if (level == ans.size()) ans.add(root.val);
        rightView(root.right, ans, level + 1);
        rightView(root.left, ans, level + 1);
    }
}
