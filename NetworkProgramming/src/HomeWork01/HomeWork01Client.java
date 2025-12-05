package HomeWork01;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class HomeWork01Client {
    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        Socket socket = new Socket(inetAddress.getHostName(),8888);
        System.out.println("Client Started");
        OutputStream os = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        os.write(input.getBytes());
        os.flush();
        InputStream is = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int len = is.read(buffer);
        System.out.println(new String(buffer,0,len));
        socket.close();
        is.close();
        os.close();
    }
}
