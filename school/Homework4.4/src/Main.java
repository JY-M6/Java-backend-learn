//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        char[] arr = S.toCharArray();
        int N = sc.nextInt();
        sc.close();

        int deleteCount = 0; // 记录已删除的数量

        // 第一阶段：按题目提示删除（找第一个比后位大的字符）
        while (deleteCount < N) {
            boolean found = false; // 标记是否找到要删除的字符
            for (int j = 0; j < arr.length - 1; j++) {
                // 跳过已标记删除的位置
                if (arr[j] == '/') {
                    continue;
                }
                // 找到下一个未被删除的字符（用于比较）
                int next = j + 1;
                while (next < arr.length && arr[next] == '/') {
                    next++;
                }
                // 边界处理：如果后面没有有效字符，跳出
                if (next >= arr.length) {
                    break;
                }
                // 找到需要删除的位置
                if (arr[j] > arr[next]) {
                    arr[j] = '/'; // 标记删除
                    deleteCount++;
                    found = true;
                    break; // 删一个就重新循环检查
                }
            }
            // 如果没找到可删除的（说明剩下的字符是递增的），则从尾部开始删
            if (!found) {
                break;
            }
        }

        // 第二阶段：如果还没删够，从尾部删除剩余需要删除的字符
        if (deleteCount < N) {
            int remain = N - deleteCount; // 还需要删除的数量
            // 从后往前找未被删除的字符进行标记
            for (int j = arr.length - 1; j >= 0 && remain > 0; j--) {
                if (arr[j] != '/') {
                    arr[j] = '/';
                    remain--;
                }
            }
        }

        // 过滤掉被标记的字符，拼接结果
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (c != '/') {
                sb.append(c);
            }
        }

        // 处理极端情况：如果所有字符都被删除，输出0
        String result = sb.length() == 0 ? "0" : sb.toString();
        System.out.println(result);
    }
}

