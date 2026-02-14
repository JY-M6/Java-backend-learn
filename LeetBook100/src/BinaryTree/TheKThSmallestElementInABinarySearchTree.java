package BinaryTree;
//力扣230. 二叉搜索树中第K小的元素
import java.util.ArrayList;
import java.util.List;

public class TheKThSmallestElementInABinarySearchTree {
    public int kthSmallest(TreeNode root, int k) {
        List<List<Integer>> ans = levelOrder(root);
        int[] arr = new int[k];
        for (int x = 0; x < k; x++) {
            int min = Integer.MAX_VALUE;
            int minI = -1, minJ = -1;
            for (int i = 0; i < ans.size(); i++) {
                for (int j = 0; j < ans.get(i).size(); j++) {
                    int val = ans.get(i).get(j);
                    if (val < min) {  // 仅当更小时更新坐标
                        min = val;
                        minI = i;
                        minJ = j;
                    }
                }
            }
            ans.get(minI).set(minJ, Integer.MAX_VALUE);
            arr[x] = min;
        }
        return arr[k-1];

    }
    public static int MAX = 10001;
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


    //方法二递归
    public int result = 0;
    public int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return result;
    }

    public void dfs(TreeNode root ,int k){
        if (root == null) return ;
        dfs(root.left,k);
        count++;
        if(count == k) {
            result = root.val;
            return;
        }

        dfs(root.right,k);
    }
}
