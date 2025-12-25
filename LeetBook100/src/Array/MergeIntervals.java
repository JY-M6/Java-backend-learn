package Array;
/**
 * 模块：区间合并（Merge Intervals）
 * 文件功能概述：提供两种区间合并实现——基于按起点排序的线性合并（merge）
 *              与无需排序的增量式合并（mergeNoSort），并在主函数进行示例演示。
 * 作者：Trae Assistant
 * 创建日期：2025-12-25
 * 修改日期：2025-12-25
 * 版本变更记录：
 *   v1.0 初始化：实现排序合并方法 merge
 *   v1.1 增强：新增不排序合并方法 mergeNoSort；补充规范中文注释
 */
import java.util.*;
public class MergeIntervals{
    /**
     * 功能描述：合并重叠区间（先按起点升序排序，再线性扫描合并）
     * 参数说明：
     * - intervals（int[][]）：输入区间集合，每个元素为形如 [start, end] 的闭区间；
     *   允许传入 null 或长度为 0 的数组
     * 返回值说明：
     * - int[][]：合并后的区间数组；若输入为空，返回 new int[0][2]
     * 异常情况处理：
     * - 不抛出异常；若传入 null/空数组，直接返回空二维数组
     * - 注意：为了实现线性合并，此方法会对输入数组进行就地排序，可能改变原数组顺序
     */
    public static int[][] merge(int[][] intervals){
        if(intervals==null||intervals.length==0) return new int[0][2]; // 输入为空的快速返回
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0])); // 按起点升序排序，保证可线性合并
        List<int[]> res=new ArrayList<>(); // 结果集，保存已合并的区间
        int[] cur=intervals[0]; // 当前正在合并的区间
        for(int i=1;i<intervals.length;i++){
            // 重叠判断：下一区间的起点落在当前区间的终点内或相等（闭区间）
            if(intervals[i][0]<=cur[1]){
                // 扩展当前区间的终点为更大的终点值
                cur[1]=Math.max(cur[1], intervals[i][1]);
            }else{
                // 不重叠：提交当前区间到结果集，并切换到新的当前区间
                res.add(cur);
                cur=intervals[i];
            }
        }
        res.add(cur); // 循环结束后补交最后一个尚未写入的区间
        return res.toArray(new int[res.size()][2]); // 列表转二维数组返回
    }
    /**
     * 功能描述：合并重叠区间（无需排序，增量式逐一合并）
     * 思路说明：
     * - 依次取输入中的每个区间，尝试与当前结果集中所有区间进行重叠判断；
     *   若重叠则扩大新区间范围并移除被合并的旧区间；直到与结果集中所有项都不再重叠为止，
     *   再将合并完成的新区间加入结果集
     * 适用场景：
     * - 不希望改变输入数组的原始顺序或无法排序的场景；但时间复杂度可能为 O(n^2)
     * 参数说明：
     * - intervals（int[][]）：输入区间集合，每项为 [start, end] 闭区间；允许 null/空
     * 返回值说明：
     * - int[][]：合并后的区间数组；若输入为空，返回 new int[0][2]
     * 异常情况处理：
     * - 不抛出异常；遇到 null/空数组直接返回空二维数组；不修改输入数组内容
     */
    public static int[][] mergeNoSort(int[][] intervals){
        if(intervals==null||intervals.length==0) return new int[0][2]; // 输入为空的快速返回
        List<int[]> res=new ArrayList<>(); // 结果集，保存逐步合并后的区间
        for(int[] it:intervals){
            int s=it[0], e=it[1]; // 新区间的起止（会在与结果集合并过程中被扩大）
            int i=0;
            // 与结果集中的每一个区间尝试合并，直到不存在重叠为止
            while(i<res.size()){
                int[] cur=res.get(i);
                // 无重叠：新区间完全在当前区间左侧或右侧，继续检查下一个
                if(e<cur[0]||s>cur[1]){
                    i++;
                }else{
                    // 有重叠：扩大新区间范围，并移除被合并的旧区间，继续尝试与其他区间合并
                    s=Math.min(s, cur[0]);
                    e=Math.max(e, cur[1]);
                    res.remove(i);
                }
            }
            // 将最终合并完成的新区间加入结果集
            res.add(new int[]{s,e});
        }
        return res.toArray(new int[res.size()][2]); // 列表转二维数组返回
    }
    /**
     * 功能描述：示例入口，构造样例区间并演示两种合并算法的输出
     * 参数说明：
     * - args（String[]）：命令行参数（本示例未使用）
     * 返回值说明：
     * - void：无返回值
     * 异常情况处理：
     * - 不抛出异常；直接打印演示结果
     */
    public static void main(String args[]){
        int[][] intervals=new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] merged=merge(intervals); // 排序合并
        System.out.println("排序合并:");
        for(int[] it:merged){
            System.out.println(it[0]+" "+it[1]);
        }
        int[][] merged2=mergeNoSort(intervals); // 无排序合并（增量式）
        System.out.println("无排序合并:");
        for(int[] it:merged2){
            System.out.println(it[0]+" "+it[1]);
        }
    }
}
