//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
import java.util.*;
import java.text.DecimalFormat;
public class Main {
    public static void main(String[] args) {
        //TIP 当文本光标位于高亮显示的文本处时按 <shortcut actionId="ShowIntentionActions"/>
        // 查看 IntelliJ IDEA 建议如何修正。
        Rectangle rectangle = new Rectangle();
        System.out.print("Please input length:");
        Scanner sc = new Scanner(System.in);
        rectangle.length = sc.nextDouble();
        System.out.println();
        System.out.print("Please input width:");
        rectangle.width = sc.nextDouble();
        System.out.println();
        System.out.printf("The lengh is:%.1f", rectangle.length);
        System.out.println();
        System.out.printf("The width is:%.1f", rectangle.width);
        System.out.println();
        DecimalFormat df = new DecimalFormat("0.0#########");
        System.out.print("The area is:");
        System.out.printf(df.format(rectangle.length * rectangle.width));
    }
}
class Rectangle {
    double length;
    double width;
}