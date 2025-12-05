import java.util.Scanner;//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        //TIP 当文本光标位于高亮显示的文本处时按 <shortcut actionId="ShowIntentionActions"/>
        // 查看 IntelliJ IDEA 建议如何修正。
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp = n;
        int m = 0;
        int last;
        while(n != 0){
            last = n % 10;
            m = m * 10 + last;
            n /= 10;
        }
        n=temp;
        boolean trap1 = false;
        boolean trap2 = false;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0 && i != n){
                System.out.println("no");
                return;
            }
            if(i == n){trap1 = true;}

        }
        for (int i = 2; i <= m; i++) {
            if(m % i == 0 && i != m){
                System.out.println("no");
                return;
            }
            if(i == m){trap2 = true;}
        }
        if (trap1 && trap2){
            System.out.println("yes");
        }
    }
}