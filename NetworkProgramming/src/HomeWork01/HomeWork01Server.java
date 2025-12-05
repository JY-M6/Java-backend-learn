package HomeWork01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HomeWork01Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket =new ServerSocket(8888);
        System.out.println("Server started");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected");
        InputStream is = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int len = is.read(buffer);
        System.out.println("Client received: " + new String(buffer, 0, len));
        OutputStream os = socket.getOutputStream();
        if("name".equals(new String(buffer, 0, len))){
            os.write("我是nova".getBytes());
        }else if("hobby".equals(new String(buffer,0,len))){
            os.write("编写java程序".getBytes());
        }else{
            os.write("你说啥呢".getBytes());
        }

        os.flush();
        socket.close();
        is.close();
        os.close();
    }
}