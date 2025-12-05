import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //设置迷宫
        System.out.println("请输入数字以决定迷宫长宽");
        int length = sc.nextInt();
        int[][] map = new int[length][length];
        map[3][2] = 1;
        map[3][1] = 1;
        map[2][2] = 1;
        for (int i = 0; i < length; i++) {
            map[0][i] = 1;
            map[i][0] = 1;
            map[length-1][i] = 1;
            map[i][length-1] = 1;
        }
        //输出迷宫
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        Labyrinth labyrinth = new Labyrinth();
        labyrinth.Judgment(map,1,1,length);
        System.out.println("完成后的迷宫");
        labyrinth.print(map);
    }

}
class Labyrinth {
    public boolean Judgment(int[][] maze, int i, int j, int length) {
        //0 表示还没走过   1 表示不能走     2 表示能走   3 表示能走但是走不通
        if (maze[length - 2][length - 2] == 2) {//说明已找到
            return true;
        } else {
            if (maze[i][j] == 0) {//说明能走
                maze[i][j] = 2;//假定能走通
                // 选策略为下左上右
                if (Judgment(maze,i + 1,j,length)) {//下
                    return true;
                } else if (Judgment(maze, i, j + 1, length)) {//左
                    return true;
                } else if (Judgment(maze, i - 1, j, length)) {//上
                    return true;
                } else if (Judgment(maze, i, j - 1, length)) {//右
                    return true;
                }
                else{
                 maze[i][j] = 3;
                 return false;
                }
            }else
                return false;
        }
    }
    public void print(int[][] Labyrinth) {
        //输出完成后的迷宫
        for (int[] ints : Labyrinth) {
            for (int j = 0; j < Labyrinth.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}