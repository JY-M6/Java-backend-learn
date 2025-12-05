package TankGame3;

import javax.swing.*;
public class TankGame03 extends JFrame {
    MyPanel mp = null;
    public static void main(String[] args) {
        TankGame03 tankGame01 = new TankGame03();
    }
    public TankGame03() {
        //设置背景大小
        mp = new MyPanel();
        Thread t = new Thread(mp);
        t.start();
        this.add(mp);
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
