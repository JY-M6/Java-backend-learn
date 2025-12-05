package MusicSave;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;

public class Homework03Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        System.out.println("连接成功");
        File filepath1 = new File("C:\\Users\\Administrator\\Music\\蓝心羽 - 阿拉斯加海湾.ogg");
        if (filepath1.exists()) {
            System.out.println("文件存在");
        }
        File filepath2 = new File("C:\\Users\\Administrator\\Music\\芊芊龍 - 是想你的声音啊.ogg");
        File filepath3 = new File("C:\\Users\\Administrator\\Music\\吴青峰 - 利爪.ogg");
        //创建音乐文件输入流
        BufferedInputStream in1 =new BufferedInputStream(Files.newInputStream(filepath1.toPath()));
        byte[] buffer1 = StreamUtils.streamToByteArray(in1);
        BufferedInputStream in2 =new BufferedInputStream(Files.newInputStream(filepath2.toPath()));
        byte[] buffer2 = StreamUtils.streamToByteArray(in2);
        BufferedInputStream in3 =new BufferedInputStream(Files.newInputStream(filepath3.toPath()));
        byte[] buffer3 = StreamUtils.streamToByteArray(in3);
        System.out.println("已读入文件");
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        byte[] buffer = new byte[1024];
        int len ;
        String str = null;
        while((len = bis.read(buffer)) != -1){
            str = new String(buffer, 0, len);
        }
        if(str.equals("阿拉斯加海湾")){
            System.out.println("即将传输："+str);
            bos.write(buffer1);
        }else if(str.equals("是想你的声音啊")){
            System.out.println("即将传输："+str);
            bos.write(buffer2);
        }else{
            System.out.println("即将传输："+str);
            bos.write(buffer3);
        }
        bos.flush();
        bos.close();
        in1.close();
        in2.close();
        in3.close();
        bis.close();
        socket.close();
        serverSocket.close();
    }
}
