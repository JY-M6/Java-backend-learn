import java.util.Scanner;//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the first number:");
        int a = sc.nextInt();
        System.out.println("Please input the second number:");
        int b = sc.nextInt();
        System.out.println("Please input the third number:");
        int c = sc.nextInt();
        int max = a > b ? (a > c ? a : c) : (b > c ? b : c);
        System.out.println("The maximum number is:"+max);
    }
}