import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入作业编号来决定从哪个作业开始运行");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    runTaskOne();
                    break;
                case 2:
                    runTaskTwo();
                    break;
                case 3:
                    runTaskThree();
                    break;
                case 4:
                    runTaskFour();
                    break;
               case 5:
                   runTaskFive();
                   break;
               case 6:
                   runTaskSix();
                   break;
               case 7:
                   runTaskSeven();
                   break;
               case 9:
                   runTaskNine();
                   break;
               case 11:
                   runTaskEleven();
                   break;
               case 12:
                       runTaskTwelve();
                       break;
               case 13:
                       runTaskThirteen();
                       break;
               case 14:
                   runTaskFourteen();
                   break;
               default:
                    System.out.println("无效的输入");
            }
            System.out.print("是否继续执行下一个作业？：");
            char continueChoice = sc.next().charAt(0);
            if (continueChoice != 'y' && continueChoice != 'Y') {
                System.out.println("程序结束。");
                break;
            }
        }
    }

    public static void runTaskOne() {
        //1.编写类A01,定义方法max，实现求某个double数组的最大值，并返回
        Scanner sc = new Scanner(System.in);
        System.out.println("作业一：");
        System.out.println("请输入数组大小");
        int size = sc.nextInt();
        double[] arr01 = new double[size];
        System.out.println("请输入数组的个元素");
        for (int i = 0; i < 5; i++) {
            arr01[i] = sc.nextDouble();
        }
        A01 a01 = new A01();
        System.out.println("该数组的最大值是" + a01.max(arr01));
    }

    public static void runTaskTwo() {
        //2.编写类A02,定义方法find，实现查找某字符串数组中的元素查找，并返回索引I， 如果找不到，返回-1.
        Scanner sc = new Scanner(System.in);
        System.out.println("作业二：");
        A02 a02 = new A02();
        System.out.println("请输入数组大小");
        int size = sc.nextInt();
        String[] arr02 = a02.createArray(size);
        System.out.println("请输入目标元素");
        String target = sc.next();
        if (a02.find(target, arr02) != -1) {
            System.out.println("目标元素已找到，其索引为" + a02.find(target, arr02));
        } else System.out.println("目标元素未找到");
    }

    public static void runTaskThree() {
        //3.编写类Book，定义方法updatePrice，实现更改某本书的价格，具体:如果价格>150,
        // 则更改为150，如果价格>100,更改为100，否则不变
        Scanner sc = new Scanner(System.in);
        System.out.println("作业三：");
        System.out.println("请输入书的价格");
        int price = sc.nextInt();
        int[] book = {price};
        Book update = new Book();
        book = update.updatePrice(book);
        System.out.println(book[0]);
    }

    public static void runTaskFour() {
        //4.编写类A03,实现数组的复制功能copyArr，输入旧数组，返回一个新数组，元素和旧数组一样
        Scanner sc = new Scanner(System.in);
        System.out.println("作业四：");
        System.out.println("请输入数组大小");
        int size = sc.nextInt();
        int[] Arr = new int[size];
        System.out.println("请输入数组各元素");
        for (int i = 0; i < size; i++) {
            Arr[i] = sc.nextInt();
        }
        A03 a03 = new A03();
        int[] copyArr = a03.copyArr(Arr);
        System.out.println("遍历新数组");
        for (int j : copyArr) {
            System.out.println(j);
        }
    }

    public static void runTaskFive() {
        //5.定义一个圆类Circle，定义属性:半径，提供显示圆周长功能的方法，提供显示圆面积的方法
        Scanner sc = new Scanner(System.in);
        System.out.println("作业五：");
        Circle circle = new Circle();
        circle.radius = sc.nextDouble();
        System.out.println("周长为" + circle.perimeter() + "/n" + circle.area());

    }
    public static void runTaskSix() {
        //6.编程创建一个Cale计算类，在其中定义2个变量表示两个操作数，
        // 定义四个方法实现求和、差、乘、商(要求除数为0的话，要提示)并创建两个对象，分别测试
        Scanner sc = new Scanner(System.in);
        System.out.println("作业六：");
        Cale cale = new Cale();
        cale.x = sc.nextDouble();
        cale.y = sc.nextDouble();
        System.out.println("加=" + cale.add() + "减=" + cale.subtract() + "乘=" + cale.multiply()
                        + "除=" + cale.divide());
    }
    public static void runTaskSeven() {
        //7.设计一个Dog类，有名字、颜色和年龄属性，定义输出方法showO显示其信息。
        // 并创建对象，进行测试、【提示 this.属性】
        Scanner sc = new Scanner(System.in);
        System.out.println("作业七：");
        String name = sc.next();
        char colour = sc.next().charAt(0);
        int age = sc.nextInt();
        Dog dog = new Dog(age,name,colour);
        dog.show();
    }
    public static void runTaskNine() {
        //9.定义Music类，里面有音乐名name、音乐时长times属性，
        // 并有播放play功能和返回本身属性信息的功能方法getInfo.
        Scanner sc = new Scanner(System.in);
        System.out.println("作业九：");
        String name = sc.next();
        double time = sc.nextDouble();
        Music music = new Music(name,time);
        music.show();
    }
    public static void runTaskEleven() {
        //11.在测试方法中，调用method方法，代码如下，编译正确，试写出method方法的定义形式，
        // 调用语句为:System.out.println(method(method(10.0,20.0),100);
        //Scanner sc = new Scanner(System.in);
        //未理解题意
        System.out.println("作业十一：" );
    }
    public static void runTaskTwelve() {
        //12.创建一个Employee类，属性有(名字，性别，年龄，职位，薪水)，提供3个构造方法，可以初始化
        // (1)(名字，性别，年龄，职位，薪水)，(2)(名字，性别，年龄)(3) (职位，薪水)，要求充分复用构造器
        //Scanner sc = new Scanner(System.in);
        //未理解题意
        System.out.println("作业十二：" );
        Employee employee = new Employee("JY",'男',19,"程序员",10000);
        employee.show();
    }
    public static void runTaskThirteen() {
        //13.将对象作为参数传递给方法。题目要求:
        //(1)定义一个Circle类，包含一个double型的radius属性代表圆的半径，一findArea0 方法返回圆的面积。
        //(2)定义一个类PassObject，在类中定义一个方法printAreas(),
        // 该方法的定义如下: public void printAreas(Circle c, int times) //方法签名
        //(3)在printAreas方法中打印输出1到times之间的每个整数半径值，以及对应的面积。
        //例如，times为5，则输出半径1，2,3,4,5,以及对应的圆面积。
        //(4)在main方法中调用printAreas()方法，调用完毕后输出当前半径值。程序运行结果如图所示
        Scanner sc = new Scanner(System.in);
        System.out.println("作业十三：" );
        PassObject passObject = new PassObject();
        Circle circle = new Circle();
        System.out.println("请输入想输出的最大半径值");
        double times = sc.nextInt();
        passObject.printAreas(circle,times);
    }
    public static void runTaskFourteen() {
        //14.扩展题，学员自己做.
        // 有个人 Tom设计他的成员变量。
        // 成员方法，可以电脑猜拳.
        // 电脑每次都会随机生成0，1,2 0表示石头1表示剪刀2表示布并要可以显示 Tom的输赢次数(清单)
        Scanner sc = new Scanner(System.in);
        System.out.println("作业十四：" );
        System.out.println("请输入要进行的次数");
        int num = sc.nextInt();
        System.out.println("要进行的次数是" + num);
        Finger_guessing_game game = new Finger_guessing_game();
        System.out.println("Tom获胜的次数是" + game.finger_guessing_game(num));
    }

}

class A01{
    public double max(double[] arr01){
        double max = arr01[0];
        //这段代码的作用是通过遍历 arr01 数组，
        // 找到其中的最大值并存储在 max 变量中。下面是对这段代码的详细解释：
        //for (double v : arr01)：这是一个增强的 for 循环（也叫做 foreach 循环），
        // 它遍历数组 arr01 中的每个元素，将每个元素赋值给 v。
        //if (v > max)：如果当前的 v 大于 max，则进入条件语句。
        //max = v;：将 max 更新为当前的 v，即找到了一个更大的值
        for (double v : arr01) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }
}
class A02{
    //创建字符串数组
    public String[] createArray(int n){
        String[] arr = new String[n];
        for(int i=0; i<n; i++){
            System.out.println("请输入第"+(i+1)+"个元素");
            Scanner sc = new Scanner(System.in);
            arr[i] = sc.next();
        }
        return arr;
    }
    public int  find(String target, String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
}
class Book{
    public int[] updatePrice(int[] price){
        if(price[0] > 150){
            price[0] = 150;
        }
        else if (price[0] > 100) {
            price[0] = 100;
        }
        return price;
    }
}
class A03{
    public int[] copyArr(int[] arr){
        int[] newArr = new int[arr.length];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        return newArr;
    }
}
class Circle{
    double radius;
    public double perimeter(){
        return radius * 2 * Math.PI;
    }
    public double area(){
        return radius * radius * Math.PI;
    }
}
class Cale{
    double x;
    double y;
    public double add(){
        return x + y;
    }
    public double subtract(){
        return x - y;
    }
    public double multiply(){
        return x * y;
    }
    public double divide(){
        if(y == 0){
            System.out.println("除数不可为零");
            return 0;
        }
        return x / y;
    }
}
class Dog{
    String name;
    char colour;
    int age;
    public Dog(int age, String name, char colour) {
        this.age = age;
        this.name = name;
        this.colour = colour;
    }
    public void show(){
        System.out.println("姓名是" + name + "颜色是" + colour + "年龄是" + age);
    }
}
class Music{
    String name;
    double time;
    Music(String name, double time){
        this.name = name;
        this.time = time;
    }
    public void show(){
        System.out.println("名字是" + name + "时长是" + time);
    }
}
class Employee{
    String name;
    char gender;
    int age;
    String position;
    double salary;
    //由于是要复用构造器，所以要从写属性少的构造器开始写
    public Employee(String position,double salary){
        this.position = position;
        this.salary = salary;
    }
    public Employee(String name, char gender, int age){
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    public Employee(String name, char gender, int age, String position, double salary){
        this(name, gender, age);//使用前面的构造器，但是对this的调用必须是构造器中的第一个语句
        this.position = position;
        this.salary = salary;
    }
    public void show(){
    System.out.println("名字是" + name + "性别是" + gender + "年龄是" + age
    + "职位是" + position + "薪水是" + salary);
    }
}
class PassObject {
    //(2)定义一个类PassObject，在类中定义一个方法printAreas(),
    // 该方法的定义如下: public void printAreas(Circle c, int times) //方法签名
    //(3)在printAreas方法中打印输出1到times之间的每个整数半径值，以及对应的面积。
    //例如，times为5，则输出半径1，2,3,4,5,以及对应的圆面积。
    public void printAreas(Circle c, double times){
        for (double i = 1; i <= times; i++) {
            c.radius = i;
            System.out.println("半径为" + i + '\t'+"面积为" + c.area());
        }
    }
}
class Finger_guessing_game{
    int count;
    int x,y;
    Random random = new Random();
    public int finger_guessing_game(int num) {
        for (int i = 0; i < num; i++) {
            x = random.nextInt(3);
            y = random.nextInt(3);
            //0表示石头1表示剪刀2表示布
            if ((x == 0 && y == 1) || (x == 1 && y == 2) || (x == 2 && y == 0)) {
                count++;
            }
        }
        return count;
    }

}