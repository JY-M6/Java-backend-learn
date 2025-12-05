//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
import java.util.*;
public class Main {
    public static void main(String[] args) {
        //TIP 当文本光标位于高亮显示的文本处时按 <shortcut actionId="ShowIntentionActions"/>
        // 查看 IntelliJ IDEA 建议如何修正。
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        for (int i = n; i <= m; i++){
            int temp = i;
            int change = 0;
            while (temp != 0) {
                int a = temp % 10;
                change = change*10 + a;
                temp /= 10;
            }
            if (change == i) {
                System.out.println(i);
            }
        }
    }
}