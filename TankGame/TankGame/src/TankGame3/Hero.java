package TankGame3;

//我的坦克
public class Hero extends Tank {
    Shot shot = null;
    public Hero(int x, int y){
        super(x, y);
    }
    //射击
    public void shotEnmeyTank(){
        //创建shot对象，根据当前hero对象的位置和方向来创建shot
        switch (getDirect()){
            case 0://向上
                shot = new Shot(getX()+20,getY(),0);
                break;
                case 1://向右
                    shot = new Shot(getX()+60,getY()+20,1);
                    break;
                    case 2://向下
                        shot = new Shot(getX()+20,getY()+60,2);
                        break;
                        case 3://向左
                            shot = new Shot(getX(),getY()+20,3);
                            break;
        }
        new Thread(shot).start();
    }
}
