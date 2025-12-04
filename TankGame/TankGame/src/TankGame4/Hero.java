package TankGame4;

import java.util.Vector;

//我的坦克
public class Hero extends Tank {
    Shot shot = null;
    boolean isLive = true;
    //设置子弹集合用来发射多颗子弹
    Vector<Shot> shots = new Vector();
    public Hero(int x, int y) {
        super(x, y);
    }

    //射击
    public void shotEnmeyTank() {
        //最多仅允许出现5颗自己的子弹
        if(shots.size() == 5) {
            return;
        }
        //创建shot对象，根据当前hero对象的位置和方向来创建shot
        switch (getDirect()) {
            case 0://向上
                shot = new Shot(getX() + 20, getY(), 0);
                break;
            case 1://向右
                shot = new Shot(getX() + 60, getY() + 20, 1);
                break;
            case 2://向下
                shot = new Shot(getX() + 20, getY() + 60, 2);
                break;
            case 3://向左
                shot = new Shot(getX(), getY() + 20, 3);
                break;
        }
        //把新创建的shot放入shots集合中
        shots.add(shot);
        //启动线程
        new Thread(shot).start();
    }
}
