package BinaryTree;
//力扣102. 二叉树的层序遍历

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversalOfBinarTree {
    public static int MAX = 2001;
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        TreeNode[] count = new TreeNode[MAX];
        int l=0,r=0;
        int size = 1;
        int sizes = 0;
        TreeNode node = root;
        count[r++] = node;
        while(l<r){
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<size;i++){
                if(node.left != null){
                    count[r++] = node.left;
                    sizes++;
                }
                if(node.right != null){
                    count[r++] = node.right;
                    sizes++;
                }
                temp.add(node.val);
                node = count[++l];
            }
            size = sizes;
            sizes = 0;
            ans.add(temp);
        }
        return ans;
    }
}
