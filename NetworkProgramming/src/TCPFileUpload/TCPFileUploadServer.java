package TCPFileUpload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileUploadServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        //已连接到客户端
        System.out.println("accept connection");
        //创建socket输入端
        InputStream bis =new BufferedInputStream(socket.getInputStream());
        //创建socket输出端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        //创建文件输出流
        BufferedOutputStream bos1 = new BufferedOutputStream(new FileOutputStream(new File("src\\image.png")));
        byte[] buffer = StreamUtils.streamToByteArray(bis);
        bos1.write(buffer);
        bos1.close();
        String str = "收到文件";
        bos.write(str.getBytes());
        bos.flush();
        bos.close();
        bis.close();
        socket.close();
        serverSocket.close();
    }
}
