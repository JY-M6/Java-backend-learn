//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the horizontal (X) :");
        double x = sc.nextDouble();
        System.out.println("\nPlease input the ordinate (Y) :");
        double y = sc.nextDouble();
        System.out.println();
        MyPoint myPoint = new MyPoint(x,y);
        myPoint.point();
    }
}
class MyPoint{
    private double x;
    private double y;

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }
    void point(){
        System.out.println("Your location of horizontal (X) is :" + x + "\n" + "Your location of ordinate (Y) is :" + y);
    }
}