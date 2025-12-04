import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        String choose;
        int num;
        System.out.println("Please enter the size of " +
                        "array you want to create" );
        num = myScanner.nextInt();
        int[] array = new int[num];
        for(int i = 0; i < num; i++){
            System.out.println("Please enter the content of the array ");
            array[i] = myScanner.nextInt();
        }
        for(int i = array.length-1;i > 0;i--) {
            System.out.println();
            System.out.println("是否要缩减数组");
            System.out.println("请输入yes或者no");
            choose = myScanner.next();
            if("yes".equals(choose)&&i >1){
                int[] arrayNew = new int[i];
                for(int j = 0;j < i;j++) {
                    arrayNew[j] = array[j];
                }
                array = arrayNew;
                System.out.print("缩减后的数组为");
                for(int k = 0;k < i;k++) {
                    System.out.print(" " + array[k]);
                }

            }
            else if("no".equals(choose)&&i >1){
                System.out.print("缩减后的数组为");
                for(int k = 0;k < i;k++) {
                    System.out.print(" "+array[k]);
                }
                break;
            }
            else{
                System.out.println("已剩最后一个元素，不可再缩减");
                break;
            }
        }
    }
}