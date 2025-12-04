//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
import java.util.*;
public class Main {
    public static void main(String[] args) {
        //TIP 当文本光标位于高亮显示的文本处时按 <shortcut actionId="ShowIntentionActions"/>
        // 查看 IntelliJ IDEA 建议如何修正。
        System.out.println("Please input a sentence:");
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        int  a[] = new int[4];
        for (int i = 0; i < sentence.length(); i++) {
            //TIP 按 <shortcut actionId="Debug"/> 开始调试代码。我们已经设置了一个 <icon src="AllIcons.Debugger.Db_set_breakpoint"/> 断点
            // 但您始终可以通过按 <shortcut actionId="ToggleLineBreakpoint"/> 添加更多断点。
            char ch = sentence.charAt(i);
            if (Character.isLetter(ch)) {
                a[0]++;
            }
            else if (Character.isDigit(ch)) {
                a[1]++;
            }
            else if (Character.isWhitespace(ch)) {
                a[2]++;
            }
            else {
                a[3]++;
            }
        }
        System.out.println("The number of numbers is: " + a[1]);
        System.out.println("The number of English letters is: " + a[0]);
        System.out.println("The number of blank space is: " + a[2]);
        System.out.println("The number of other characters is: " + a[3]);


    }
}