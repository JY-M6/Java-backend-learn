//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
import java.util.Scanner;
public class Main {
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
                int num = scanner.nextInt();

                if (num == 0) {
                    System.out.println("programe is over.");
                    break;
                }

                if (isPrime(num)) {
                    System.out.println(num + " is sushu.");
                }
                if(!isPrime(num)) {
                System.out.println(num + " is not sushu.");}
        }
    }
}