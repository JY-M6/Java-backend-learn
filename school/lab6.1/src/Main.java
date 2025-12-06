import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input your score");
        int n = 0;
        try {
            n = sc.nextInt();
            if (!(n <= 100 && n >= 0)){
                throw new MyException();
            }
            System.out.println("Your score is:" + n );
        } catch (Exception e) {
            System.out.println("Error,score should be in 0-100.");

    }
    }
}

class MyException extends RuntimeException {
    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }
}