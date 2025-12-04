import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        int b = (int) a;
        int c =look(a,b);
        int d = gcd(c,(int)((a-b)*c));
        int e = (int)((a-b)*c/d);
        int f =c/d;
        System.out.println(b+" "+e+" "+f);
        System.out.println();
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static int look(double a, int b) {
        double temp = a-b;
        int c = 1;
        while(true){
            if(temp != (int)temp){
                temp = temp*10;
                c*=10;
            }
            else{break;}
        }
        return c;
    }
}
