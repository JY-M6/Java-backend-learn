import java.util.Scanner;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        //TIP 当文本光标位于高亮显示的文本处时按 <shortcut actionId="ShowIntentionActions"/>
        // 查看 IntelliJ IDEA 建议如何修正。
        System.out.println("Please input 10 numbers:");
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[10];
        for (int i = 0; i < 10; i++) {
            //TIP 按 <shortcut actionId="Debug"/> 开始调试代码。我们已经设置了一个 <icon src="AllIcons.Debugger.Db_set_breakpoint"/> 断点
            // 但您始终可以通过按 <shortcut actionId="ToggleLineBreakpoint"/> 添加更多断点。
            numbers[i] = sc.nextInt();
        }
        System.out.println("Your numbers are:");
        for (int i = 0; i < 10; i++) {
            System.out.printf(numbers[i]+" ");
        }
        System.out.println();
        System.out.println("Please input m:");
        int m = sc.nextInt();
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            if (m + i < 10){
                a[m+i] = numbers[i];
            }
            else if(m+i >= 10){
                a[i+m-10] = numbers[i];
            }
        }
        System.out.println("The new numbers are:");
        for (int i = 0; i < 10; i++) {
            System.out.printf(a[i]+" ");
        }
    }
}