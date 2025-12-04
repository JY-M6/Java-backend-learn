import java.io.*;

public class BufferedInputStream_BufferedOutputStream {
    public static void main(String[] args) throws IOException {
        String filepath = "d:\\java\\trial\\IO_\\mytemp\\hello2.txt";
        File file = new File(filepath);
        if(file.createNewFile()){
            System.out.println("File created");
        }else{
            System.out.println("File already exists");
        }
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filepath));
        String str = "This is a exercise of BufferedInputStream_bufferedOutputStream";
        bos.write(str.getBytes());
//        bos.flush();
        bos.close();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filepath));
        byte[] buffer = new byte[1024];
        int len;
        while((len = bis.read(buffer)) != -1){
            System.out.println(new String(buffer,0,len));
        }

        bis.close();
    }
}