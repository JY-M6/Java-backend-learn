import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReader_FileWriter
{
    public static void main(String[] args) throws IOException {
        String filepath = "d:\\java\\trial\\IO_\\mytemp\\hello1.txt";
        File file = new File(filepath);
        if(file.createNewFile()){
            System.out.println("File created");
        }else{
            System.out.println("File already exists");
        }
        FileReader fr = new FileReader(filepath);
        FileWriter fw = new FileWriter(filepath);
        fw.write("This is a exercise of FileReader_FileWriter.");
        fw.close();
        char[] buffer = new char[1024];
        int len;
        while((len =fr.read(buffer)) != -1){
            System.out.print(new String(buffer,0,len));
        }
        fr.close();

    }
}
