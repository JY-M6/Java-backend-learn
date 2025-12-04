//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
import java.util.*;
public class Main {
    public static void main(String[] args) {
        //TIP 当文本光标位于高亮显示的文本处时按 <shortcut actionId="ShowIntentionActions"/>
        // 查看 IntelliJ IDEA 建议如何修正。
        System.out.println("Please input a number:");
        int n,m,sum=0,i = 1;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = n;
        do{
            m = n;
            do{
                i *= m;
                m--;
            }while (m > 0);
            sum = sum + i;
            n--;
            i = 1;
        }while(n > 0);
        System.out.println("1+2!+3!+...+n!= "+sum);
    }
}