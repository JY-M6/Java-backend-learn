package Draw;

import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JFrame {
    //定义一个面板
    private Mypanel mp = null;

    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle() {
        mp = new Mypanel();
        this.add(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setVisible(true);
    }
}

class Mypanel extends JPanel {
    public void paint(Graphics g) {
        super.paint(g);
        //g.drawOval(10, 10, 100, 100);

        //画一个坦克
        g.setColor(Color.blue);
        g.fillRect(10,10,20,100);
        g.fillRect(60,10,20,100);
        g.fillRect(30,30,30,50);
        g.fillRect(40,10,10,50);
    }
}