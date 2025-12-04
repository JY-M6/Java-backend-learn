package TankGame4;

//炸弹
public class Bomb {
    int x,y;//炸弹坐标
    int life = 9;//炸弹生命周期
    boolean isLive = true;//炸弹是否还存活

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }
    //减少生命值
    public void lifeDown(){
        if(life>0){
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            life--;
        } else{
            isLive = false;
        }
    }
}
