package TankGame5;

import javax.swing.text.View;
import java.io.*;
import java.util.Vector;

//该类用于记录相关信息，与文件交互
public class Recorder {
    //定义变量，记录我方击毁敌人坦克数
    private static int allEnemyTankNum = 0;
    //定义IO对象
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static String recordFile = "d:\\java\\trial\\TankGame\\myRecord.txt";
    private static Vector<EnemyTank> enemyTanks = null;
    //定义一个Node的Vector,用于保存敌人的信息node
    private static Vector<Node> nodes = new Vector<>();

    //返回记录文件的路径
    public static String getRecordFile() {
        return recordFile;
    }

    public static Vector<Node> getNodesAndEnemyTankRec() {
        try {
            br = new BufferedReader(new FileReader(recordFile));
            allEnemyTankNum = Integer.parseInt(br.readLine());
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] xyd =line.split(" ");
                Node node = new Node(Integer.parseInt(xyd[0]), Integer.parseInt(xyd[1]),
                        Integer.parseInt(xyd[2]));
                //放入nodes Vector
                nodes.add(node);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
        }

        return nodes;
    }

    //当游戏退出时，我们将allEnemyTankNum保存到recordFile
    //增加功能，保存敌人坦克的坐标
    public static void keepRecord() {
        try {
            bw = new BufferedWriter(new FileWriter(recordFile));
            bw.write(allEnemyTankNum + "\r\n");
            //遍历敌人坦克的Vector，然后根据情况保存
            //定义一个属性，通过setXXX得到敌人坦克的Vector
            for(int i = 0;i<enemyTanks.size();i++){
                EnemyTank enemyTank = enemyTanks.get(i);
                if(enemyTank.isLive){
                    //保存该enemyTank的信息
                    String record =  enemyTank.getX()+" "+enemyTank.getY()+" "+enemyTank.getDirect();
                    bw.write(record+"\r\n");
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    public static int getAllEnemyTankNum() {
        return allEnemyTankNum;
    }

    public static void setAllEnemyTankNum(int allEnemyTankNum) {
        Recorder.allEnemyTankNum = allEnemyTankNum;
    }

    //当我方坦克击毁一辆敌人坦克，就应当allEnemyTankNum++
    public static void addEnemyTankNum() {
        Recorder.allEnemyTankNum++;
    }

}
