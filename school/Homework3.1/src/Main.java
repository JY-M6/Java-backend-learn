import java.util.Scanner; //TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        //TIP 当文本光标位于高亮显示的文本处时按 <shortcut actionId="ShowIntentionActions"/>
        // 查看 IntelliJ IDEA 建议如何修正。
        Scanner in = new Scanner(System.in);
        System.out.println("Please input a score:");
        int score = in.nextInt();
        char grade;
        if (score >= 90 && score <= 100) {
            grade = 'A'; // 优秀
        } else if (score >= 80 && score < 90) {
            grade = 'B'; // 良好
        } else if (score >= 70 && score < 80) {
            grade = 'C'; // 中等
        } else if (score >= 60 && score < 70) {
            grade = 'D'; // 及格
        } else if (score >= 0 && score < 60) {
            grade = 'E'; // 不及格
        } else {
            grade = '?'; // 无效成绩（处理超出 0-100 的异常值）
        }

        // 输出结果
        if (grade == '?') {
            System.out.println("输入的成绩无效，请输入 0-100 之间的分数！");
        } else {
            System.out.println(grade);
        }
    }
}