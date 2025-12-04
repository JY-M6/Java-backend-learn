//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //TIP 当文本光标位于高亮显示的文本处时按 <shortcut actionId="ShowIntentionActions"/>
        // 查看 IntelliJ IDEA 建议如何修正。
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        Triangle t = new Triangle(a, b, c);
        System.out.println("perimeter="+t.getPerimeter());
        System.out.printf("area=%.1f\n",t.getArea());
        System.out.println(t);
    }
}
class Triangle{
    private double a, b, c;
    double getPerimeter() {
        return a + b + c;
    }
    double getArea() {
        return Math.sqrt((getPerimeter()/2)*(getPerimeter()/2-a)*(getPerimeter()/2-b)*(getPerimeter()/2-c)) ;
    }
    public void setSide(double x, double y, double z) {
        a = x;
        b = y;
        c = z;
    }

    public Triangle(double a, double b, double c) {
        if (a+b<=c || a+c<=b || b+c<=a) {
            this.a = 0;
            this.b = 0;
            this.c = 0;
            return;
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public String toString() {
        return "a="+a+",b="+b+",c="+c;
    }
}