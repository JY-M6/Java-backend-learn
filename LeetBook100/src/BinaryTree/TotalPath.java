package BinaryTree;
//力扣437

import java.util.HashMap;
import java.util.Map;

/*public class TotalPath {
    // 哈希表记录前缀和及其出现次数
    private Map<Long, Integer> prefix = new HashMap<>();
    private int target;
    private int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        this.target = targetSum;
        // 初始化：前缀和为0的路径有1条（空路径）
        prefix.put(0L, 1);
        dfs(root, 0L);
        return count;
    }

    *//**//**//**//**//**//**//**//**
     * 深度优先搜索遍历二叉树，统计路径和等于目标值的路径数量
     *
     * node 当前遍历的树节点
     * currSum 从根节点到当前节点父节点的路径和（不包含当前节点值）
     *//**//**//**//**//**//**//**//*
    private void dfs(TreeNode node, long currSum) {
        if (node == null) {
            return;
        }
        // 更新当前路径和
        currSum += node.val;

        // 以当前节点结尾，和为 target 的路径数 = 之前出现过的前缀和为 currSum - target 的次数
        count += prefix.getOrDefault(currSum - target, 0);

        // 将当前前缀和加入哈希表
        prefix.put(currSum, prefix.getOrDefault(currSum, 0) + 1);

        // 递归遍历左右子树
        dfs(node.left, currSum);
        dfs(node.right, currSum);

        // 回溯：移除当前前缀和，避免影响其他分支
        prefix.put(currSum, prefix.get(currSum) - 1);
    }
}*/


public class TotalPath {
    public Map<Long,Integer> prefix = new HashMap<>();
    public int current =0;
    public int target;

    public int pathSum(TreeNode root, int targetSum){
        this.target = targetSum;
        prefix.put(0L,1);
        dfs(root,0L);
        return current;
    }

    private void dfs(TreeNode node,Long curSum){
        if (node == null) {
            return;
        }
        curSum +=  node.val;

        current += prefix.getOrDefault(curSum-target,0);

        prefix.put(curSum,prefix.getOrDefault(curSum,0)+1);

        dfs(node.left,curSum);
        dfs(node.right,curSum);

        prefix.put(curSum,prefix.getOrDefault(curSum,0)-1);
    }
}




















