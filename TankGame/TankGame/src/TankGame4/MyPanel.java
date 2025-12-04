package TankGame4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

//绘图区
//为了监听键盘事件，实现KeyListener
public class MyPanel extends JPanel implements KeyListener, Runnable {
    //定义我的坦克
    Hero hero = null;
    //定义敌人的坦克
    Vector<EnemyTank> enemyTanks = new Vector<>();
    //定义炸弹
    //当子弹击中敌人坦克时就加入一个Bomb对象到bombs
    Vector<Bomb> bombs = new Vector<>();
    int enemyTankSize = 3;

    //定义三张炸弹图片，用于显示爆炸
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel() {
        hero = new Hero(500, 500);//设置初始位置
        hero.setSpeed(4);//设置移动速度

        //设置敌人的坦克属性
        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            enemyTank.setDirect(2);
            //设置敌人坦克移动速度
            enemyTank.setSpeed(2);
            //启动敌人坦克线程
            new Thread(enemyTank).start();
            //加子弹
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            new Thread(shot).start();
            enemyTank.shots.add(shot);

            //加坦克
            enemyTanks.add(enemyTank);

        }
        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/image1.png"));
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/image2.png"));
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/image3.png"));
    }

    public void paint(Graphics g) {
        super.paint(g);
        //设置背景大小
        g.fillRect(0, 0, 1000, 750);

        //画出自己的坦克-封装方法
        // 自己的坦克出生位置
        if (hero.isLive) {
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
        }

        //画出hero射击的子弹
//        if (hero.shot != null && hero.shot.isLive) {
//            g.draw3DRect(hero.shot.getX(), hero.shot.getY(), 2, 2, false);
//        }
        //画出多颗子弹
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if (shot != null && shot.isLive) {
                g.draw3DRect(shot.getX(), shot.getY(), 2, 2, false);
            } else {//如果该对象已经被销毁，则将该对象从集合中拿掉
                hero.shots.remove(shot);
            }
        }

        //如果bombs里面有对象，就画炸弹
        for (int i = 0; i < bombs.size(); i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //取出炸弹
            Bomb bomb = bombs.get(i);
            //根据当前这个bomb对象的life值去画出对应的图片
            if (bomb.life > 6) {
                g.drawImage(image1, bomb.x, bomb.y, 63, 45, this);
            } else if (bomb.life > 3) {
                g.drawImage(image2, bomb.x, bomb.y, 69, 58, this);
            } else {
                g.drawImage(image3, bomb.x, bomb.y, 82, 68, this);
            }
            //让炸弹生命值减少
            bomb.lifeDown();
            //如果 bomb life 为0，就从bombs的集合中删除
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }

        }
        //画出敌人的坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            //判断是否还活着
            if (enemyTank.isLive) {
                //敌人的坦克出生位置
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);
                //画出所有子弹
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    //取出子弹
                    Shot shot = enemyTank.shots.get(j);
                    if (shot != null && shot.isLive) {
                        g.draw3DRect(shot.getX(), shot.getY(), 2, 2, false);
                    } else {//删除
                        enemyTank.shots.remove(shot);
                    }
                }
            }
        }

    }
    //画出坦克

    /**
     * @param x      坦克的左上角x坐标
     * @param y      坦克的左上角y坐标
     * @param g      画笔
     * @param direct 坦克方向（上下左右）
     * @param type   坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {

        //根据不同类型的坦克，设置不同颜色
        switch (type) {
            case 0://敌人的坦克
                g.setColor(Color.cyan);
                break;
            case 1://我的坦克
                g.setColor(Color.yellow);
                break;
        }

        //根据坦克方向，来绘制对应形状的坦克
        //direct 表示方向（0 向上，1 向右，2 向下，3 向左）
        switch (direct) {
            case 0://表示向上
                g.fill3DRect(x, y, 10, 60, false);//画出坦克上边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克的盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出坦克的圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y);//画出炮筒
                break;
            case 1://表示向右
                g.fill3DRect(x, y, 60, 10, false);//画出坦克左边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克的盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出坦克的圆形盖子
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//画出炮筒
                break;
            case 2://表示向下
                g.fill3DRect(x, y, 10, 60, false);//画出坦克上边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克的盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出坦克的圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//画出炮筒
                break;
            case 3://表示向左
                g.fill3DRect(x, y, 60, 10, false);//画出坦克左边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克的盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出坦克的圆形盖子
                g.drawLine(x + 30, y + 20, x, y + 20);//画出炮筒
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }

    //当子弹打到敌方坦克时敌方坦克销毁
    public void hitTank(Shot s, EnemyTank enemyTank) {
        switch (enemyTank.getDirect()) {
            case 0://坦克向上
            case 2://坦克向下

                if (s.getX() > enemyTank.getX() && s.getX() < enemyTank.getX() + 40 &&
                        s.getY() > enemyTank.getY() && s.getY() < enemyTank.getY() + 60) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    //将被击中的坦克从集合中删除
                    enemyTanks.remove(enemyTank);
                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1://坦克向右
            case 3://坦克向左
                if (s.getX() > enemyTank.getX() && s.getX() < enemyTank.getX() + 60 &&
                        s.getY() > enemyTank.getY() && s.getY() < enemyTank.getY() + 40) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    //将被击中的坦克从集合中删除
                    enemyTanks.remove(enemyTank);
                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
        }
    }

    //当子弹打到我方坦克时我方坦克销毁
    public void hitHero(Shot s, Hero hero) {
        switch (hero.getDirect()) {
            case 0://坦克向上
            case 2://坦克向下

                if (s.getX() > hero.getX() && s.getX() < hero.getX() + 40 &&
                        s.getY() > hero.getY() && s.getY() < hero.getY() + 60) {
                    s.isLive = false;
                    hero.isLive = false;
                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(hero.getX(), hero.getY());
                    hero = null;
                    bombs.add(bomb);
                }
                break;
            case 1://坦克向右
            case 3://坦克向左
                if (s.getX() > hero.getX() && s.getX() < hero.getX() + 60 &&
                        s.getY() > hero.getY() && s.getY() < hero.getY() + 40) {
                    s.isLive = false;
                    hero.isLive = false;
                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(hero.getX(), hero.getY());
                    hero = null;
                    bombs.add(bomb);
                }
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //处理wdsa 键按下的情况
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {//向上
            hero.setDirect(0);
            if (hero.getY() > 0) {
                hero.moveUp();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {//向右
            hero.setDirect(1);
            if (hero.getX() + 60 < 1000) {
                hero.moveRight();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {//向下
            hero.setDirect(2);
            if (hero.getY() + 60 < 750) {
                hero.moveDown();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {//向左
            hero.setDirect(3);
            if (hero.getX() > 0) {
                hero.moveLeft();
            }
        }

        //发射一颗子弹
//        //如果按了J，就发射子弹
//        if (e.getKeyCode() == KeyEvent.VK_J) {
//            //判断hero子弹是否销毁
//            if (hero.shot == null || !hero.shot.isLive) {
//                hero.shotEnmeyTank();
//            }
//        }
        if (e.getKeyCode() == KeyEvent.VK_J) {
            //发射多颗子弹
            hero.shotEnmeyTank();
        }
        //让面板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //遍历所有的子弹
            for (int j = 0; j < hero.shots.size(); j++) {
                Shot shot = hero.shots.get(j);
                //判断是否击中了敌人
                if (hero.shot != null && hero.shot.isLive) {
                    //遍历所有敌人坦克
                    for (int i = 0; i < enemyTanks.size(); i++) {
                        EnemyTank enemyTank = enemyTanks.get(i);
                        hitTank(shot, enemyTank);
                    }
                }
            }
            //遍历所有的敌方坦克
            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank enemyTank = enemyTanks.get(i);
                //遍历敌方坦克的子弹
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    Shot shot = enemyTank.shots.get(j);
                    //判断是否击中了己方
                    if (shot != null && shot.isLive) {
                        hitHero(shot, hero);

                    }
                }
            }
            this.repaint();
//            if (!hero.isLive) {
//                return;
//            }
        }
    }
}
