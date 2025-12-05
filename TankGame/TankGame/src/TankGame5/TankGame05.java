package TankGame5;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class TankGame05 extends JFrame {
    MyPanel mp = null;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        TankGame05 tankGame01 = new TankGame05();
    }

    public TankGame05() {
        System.out.println("请输入选择 1: 新游戏 2: 继续上局");
        String key = sc.next();
        //设置背景大小
        mp = new MyPanel(key);
        Thread t = new Thread(mp);
        t.start();
        this.add(mp);
        this.setSize(1300, 950);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        //在JFrame中增加相应关闭窗口的处理
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Recorder.keepRecord();
                System.exit(0);
            }
        });
    }
}
