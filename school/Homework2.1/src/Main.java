import java.util.*;
public class Main {
    public static void main(String[] args) {
        //TIP 当文本光标位于高亮显示的文本处时按 <shortcut actionId="ShowIntentionActions"/>
        // 查看 IntelliJ IDEA 建议如何修正。
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int sum = 0;
        System.out.println(n + " to " + m + " WanShu:");
        for (int i = n; i <= m; i++) {
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }
                if (sum == i * 2) {
                    System.out.printf(i + ",");
                } else {
                    sum = 0;
                }
        }
    }
}