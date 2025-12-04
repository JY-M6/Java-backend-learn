import java.io.*;

public class BufferedReader_BufferedWriter {
    public static void main(String[] args) throws IOException {
        String filepath = "d:\\java\\trial\\IO_\\mytemp\\hello3.txt";
        File file = new File(filepath);
        if(file.createNewFile()){
            System.out.println("File created");
        }else{
            System.out.println("File already exists");
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));
        bw.write("This is a exercise of BufferedReader_BufferedWriter");
        bw.newLine();
        bw.write("This is a exercise of BufferedReader_BufferedWriter");
        bw.close();
        BufferedReader br =new BufferedReader(new FileReader(filepath));
        String str;
        while((str = br.readLine())!=null){
            System.out.println(str);
        }
        br.close();
    }
}