import java.util.Scanner;

public class Triangle {
    private double a, b, c;


    double getPerimeter() {
        return a + b + c;
    }

    double getArea() {
        return Math.sqrt((getPerimeter() / 2) * (getPerimeter() / 2 - a) * (getPerimeter() / 2 - b) * (getPerimeter() / 2 - c));}
    public Triangle( double a, double b, double c){
            if (a + b <= c || a + c <= b || b + c <= a) {
                this.a = 0;
                this.b = 0;
                this.c = 0;
                return;
            }
            this.a = a;
            this.b = b;
            this.c = c;
        }
        public void setSide ( double a, double b, double c){
            if (a + b <= c || a + c <= b || b + c <= a) {
                this.a = 0;
                this.b = 0;
                this.c = 0;
                return;
            }
            this.a = a;
            this.b = b;
            this.c = c;
        }
        public String toString () {
            return "a=" + a + ",b=" + b + ",c=" + c;
        }
        public double getA () {
            return a;
        }
        public double getB () {
            return b;
        }
        public double getC () {
            return c;
        }
        public double setA ( double a){
            if (a + b <= c || a + c <= b || b + c <= a) {
                System.out.println("a input error");
                return 0;
            }
            this.a = a;
            return 0;
        }
        public double setB ( double b){
            if (a + b <= c || a + c <= b || b + c <= a) {
                System.out.println("b input error");
                return 0;
            }
            this.b = b;
            return 0;
        }
        public double setC ( double c){
            if (a + b <= c || a + c <= b || b + c <= a) {
                System.out.println("c input error");
                return 0;
            }
            this.c = c;
            return 0;
        }


        public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            double x = in.nextDouble();
            double y = in.nextDouble();
            double z = in.nextDouble();
            Triangle t = new Triangle(x, y, z);
            System.out.printf("perimeter=%.2f\n", t.getPerimeter());
            System.out.printf("area=%.2f\n", t.getArea());
            System.out.println(t);
            t.setSide(t.getA() + 3, t.getB() + 2, t.getC() + 1);
            System.out.println(t);
            t.setA(t.getA() + 20);
            System.out.println(t);
            t.setB(t.getB() + 20);
            System.out.println(t);
            t.setC(t.getC() + 20);
            System.out.println(t);
            in.close();
        }
    }
