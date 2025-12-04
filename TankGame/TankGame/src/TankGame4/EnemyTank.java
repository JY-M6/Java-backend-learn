package TankGame4;

import java.util.Vector;

//敌人的坦克
public class EnemyTank extends Tank implements Runnable {
    //在敌人坦克类，使用Vector保存多个Shot
    Vector<Shot> shots = new Vector<>();
    boolean isLive = true;

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while (true) {
            //当子弹集合里面没有子弹了，就加一个子弹
            if (isLive && shots.size() < 5) {
                Shot s = null;
                //根据坦克的方向判断射击方向
                switch (getDirect()) {
                    case 0:
                        s = new Shot(getX() + 20, getY(), 0);
                        break;
                    case 1:
                        s = new Shot(getX() + 60, getY() + 20, 1);
                        break;
                    case 2:
                        s = new Shot(getX() + 20, getY() + 60, 2);
                        break;
                    case 3:
                        s = new Shot(getX(), getY() + 20, 3);
                        break;
                }
                shots.add(s);
                //启动
                new Thread(s).start();
            }
            switch (getDirect()) {
                case 0://向上
                    for (int i = 0; i < 15; i++) {
                        //移动
                        if (getY() > 0) {
                            moveUp();
                        }
                        //等待
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 1://向右
                    for (int i = 0; i < 15; i++) {
                        //移动
                        if (getX() + 60 < 1000) {
                            moveRight();
                        }
                        //等待
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2://向下
                    for (int i = 0; i < 15; i++) {
                        //移动
                        if (getY() + 60 < 750) {
                            moveDown();
                        }
                        //等待
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 3://向左
                    for (int i = 0; i < 15; i++) {
                        //移动
                        if (getX() > 0) {
                            moveLeft();
                        }
                        //等待
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
            }
            //设置随机方向
            setDirect((int) (Math.random() * 4));
            //退出线程条件
            if (!isLive) {
                break;
            }
        }
    }
}
