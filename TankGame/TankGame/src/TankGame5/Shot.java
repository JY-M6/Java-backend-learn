package TankGame5;

public class Shot implements Runnable {
    private int x;
    private int y;
    private int speed = 5;
    private int direct = 0;
    boolean isLive = true;

    public Shot(int x, int y, int direct) {
        this.direct = direct;
        this.y = y;
        this.x = x;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switch (direct) {
                case 0:
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }
            //当子弹碰到边界时，子弹不存活
            //当子弹碰到敌人坦克时，子弹消失
            if (!(x <= 1000 && x >= 0 && y <= 750 && y >= 0 && isLive)) {
                isLive = false;
                break;
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }
}
