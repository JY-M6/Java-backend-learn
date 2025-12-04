//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();
        Circle circle = new Circle(r);
        circle.disp();
    }
}
class Circle{
    private double radius;
    double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public Circle() {
        this.radius = 0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    double getArea() {
        return Math.PI * radius * radius;
    }
    void disp(){
        System.out.printf("radius=%.4f",radius);
        System.out.println();
        System.out.printf("perimeter=%.4f",getPerimeter());
        System.out.println();
        System.out.printf("area=%.4f",getArea());
    }
}