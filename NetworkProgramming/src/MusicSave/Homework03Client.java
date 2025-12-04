package MusicSave;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.file.Files;
import java.util.Scanner;

public class Homework03Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        System.out.println("连接成功");
        File path = new File("D:\\java\\trial\\NetworkProgramming\\song.mp3");
        //创建文件
        if(path.exists()){
            System.out.println("文件存在");
        }else{
            path.createNewFile();
        }

        //创建音乐文件输出流
        BufferedOutputStream out = new BufferedOutputStream(Files.newOutputStream(path.toPath()));
        System.out.println("已读到文件");
        //创建Socket输出和输入流
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("即将保存："+str);
        bos.write(str.getBytes());
        bos.flush();
        socket.shutdownOutput();
        byte[] buffer =StreamUtils.streamToByteArray(bis);
        out.write(buffer);
        System.out.println("音乐添加成功");
        out.close();
        bis.close();
        bos.close();
        socket.close();
    }
}
