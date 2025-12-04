import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStream_FileOutputStream {
    public static void main(String[] args) throws IOException {
        String filepath = "d:\\java\\trial\\IO_\\mytemp\\hello.txt";
        FileInputStream fis = new FileInputStream(filepath);
        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer))!=-1){
            String str = new String(buffer,0,len);
            System.out.println(str);
        }
        FileOutputStream fos = new FileOutputStream(filepath,true);
        String str1 = "This is a exercise of FileInputStream_FileOutputStream.";
        fos.write(str1.getBytes());
        byte[] buffer1 = new byte[1024];
        int len1;
        while((len1 = fis.read(buffer1))!=-1){
            String str = new String(buffer1,0,len1);
            System.out.println(str);
        }
        fis.close();
        fos.close();
    }
}
