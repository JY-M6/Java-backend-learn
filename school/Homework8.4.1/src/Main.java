import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        // 分割整数部分和小数部分
        String[] parts = input.split("\\.");
        int integerPart = Integer.parseInt(parts[0]);
        String fractionalPart = parts[1];

        // 计算分子和分母
        int numerator = Integer.parseInt(fractionalPart);
        int denominator = 1;
        for (int i = 0; i < fractionalPart.length(); i++) {
            denominator *= 10;
        }

        // 计算最大公约数并化简
        int gcd = gcd(numerator, denominator);
        int simplifiedNumerator = numerator / gcd;
        int simplifiedDenominator = denominator / gcd;

        // 输出结果
        System.out.println(integerPart + " " + simplifiedNumerator + " " + simplifiedDenominator);
    }

    // 计算最大公约数（辗转相除法）
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}