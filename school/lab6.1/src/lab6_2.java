import java.util.Scanner;
public class lab6_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input first number:");
        double num1 = sc.nextInt();
        System.out.println("Please input second number:");
        int num2 = sc.nextInt();
        try {
            if(num2 <0){
                throw new NegativeException();
            }else if(num2 == 0){
                throw new ZeroException();
            }
            System.out.println("Divisor is : "+num1/num2+"\n" +"finally!");
        } catch (NegativeException e) {
            System.out.println("The divisor, "+num2+", could not be negative!\n" + "finally!");
        } catch (ZeroException e) {
            System.out.println("The divisor, 0,could not be zero!\n" + "finally!");
        }
    }
}
class NegativeException extends RuntimeException {
    public NegativeException() {
        super();
    }

    public NegativeException(String message) {
        super(message);
    }
}
class ZeroException extends RuntimeException {
    public ZeroException() {
        super();
    }

    public ZeroException(String message) {
        super(message);
    }
}
