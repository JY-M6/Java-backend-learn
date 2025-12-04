package TCPFileUpload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPFileUploadclient {
    public static void main(String[] args) throws Exception {
        //连接服务端
        Socket socket = new Socket(InetAddress.getLocalHost(),8888);
        System.out.println("Connected to server");
        //验证文件是否存在
        if(new File("D:\\Java\\trial\\NetworkProgramming\\image1.png").exists()){
            System.out.println("File exists");
        }
        //创建文件操作流
        InputStream is = new FileInputStream("D:\\Java\\trial\\NetworkProgramming\\image1.png");
        //BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\Java\\trial\\NetworkProgramming\\image1.png"));
        //将文件信息转为字节型
        byte[] buffer = StreamUtils.streamToByteArray(is);
        is.close();
        //创建socket输出流
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        //发送文件信息
        bos.write(buffer);
        //清除缓存区
        bos.flush();
        //停止传输
        socket.shutdownOutput();
        //创建socket输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
        bos.close();
        socket.close();

    }
}
