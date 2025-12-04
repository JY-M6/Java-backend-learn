package test;
//a)编写应用程序EcmDef.java.接收命令行的两个参数(整数)，计算两数相除。
//b)计算两个数相除，要求使用方法cal(int n1, int n2)
//c)对数据格式不正确(NumberFormatException)、缺少命令行参数
//(ArrayIndexOutOfBoundsException)、除0进行异常处理(ArithmeticException)
@SuppressWarnings("all")
public class Exception {

    public static void main(String[] args) {
        try {
            if(args.length != 2){
                throw new ArrayIndexOutOfBoundsException("请输入两个整数");
            }
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);

            double res = cal(a,b);
            System.out.println(res);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }
    public static double cal(int n1, int n2){
            return n1 / n2;
    }
}
