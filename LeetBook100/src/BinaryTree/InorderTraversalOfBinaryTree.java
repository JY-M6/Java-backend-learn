package BinaryTree;
//力扣94

import java.util.ArrayList;
import java.util.List;

    public class InorderTraversalOfBinaryTree {
        public List<Integer> inorderTraversal_1(TreeNode root) {
            // 1. 空节点返回空列表（而非null），避免空指针
            if (root == null) {
                return new ArrayList<>();
            }

            // 2. 初始化结果列表（统一初始化，避免分支遗漏）
            List<Integer> list = new ArrayList<>();

            // 中序遍历核心逻辑：左 -> 根 -> 右
            // 3. 递归遍历左子树，将结果加入列表
            list.addAll(inorderTraversal_1(root.left));
            // 4. 添加当前根节点值（无论左子树是否存在，都要添加）
            list.add(root.val);
            // 5. 递归遍历右子树，将结果加入列表（而非仅添加右节点值）
            list.addAll(inorderTraversal_1(root.right));

            return list;
        }


            public List<Integer> inorderTraversal_2 (TreeNode root){

            List<Integer> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            preOrder(root, ans);
            return ans;
        }

            public void preOrder (TreeNode root, List < Integer > ans){
            if (root == null) {
                return;
            }
            preOrder(root.left, ans);
            ans.add(root.val);
            preOrder(root.right, ans);
        }
    }
