//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。

    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            // 创建Scanner对象用于读取输入
            Scanner scanner = new Scanner(System.in);
            // 读取一行输入
            String input = scanner.nextLine();
            scanner.close();

            // 创建一个数组来存储每个字母的出现次数，索引0-25对应A-Z
            int[] counts = new int[26];

            // 遍历输入字符串的每个字符
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                // 检查是否为英文字母
                if (Character.isLetter(c)) {
                    // 转换为大写字母，统一处理
                    char upperC = Character.toUpperCase(c);
                    // 计算对应的索引（A对应0，B对应1，...，Z对应25）
                    int index = upperC - 'A';
                    // 对应字母的计数加1
                    counts[index]++;
                }
            }

            // 输出结果，只输出出现过的字母
            for (int i = 0; i < 26; i++) {
                if (counts[i] > 0) {
                    // 将索引转换回对应的大写字母
                    char letter = (char)('A' + i);
                    System.out.println("(" + letter + ")Num=" + counts[i]);
                }
            }
        }
    }

