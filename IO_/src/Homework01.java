import java.io.*;

public class Homework01 {
    public static void main(String[] args) throws IOException {
        String name = "d:\\java\\trial\\IO_\\mytemp";
        File file = new File(name);
        if (file.exists()) {
            System.out.println("File exists");
        }else{
            System.out.println("File does not exist");
            if(file.mkdirs()){
                System.out.println("Directory created");
            }else{
                System.out.println("Directory not created");
            }
        }
        String path = name+"\\hello.txt";
        File file1 = new File(path);
        if (new File(path).exists()) {
            System.out.println("File exists");
        }
        else{
            System.out.println("File does not exist");
            if(file1.createNewFile()){
                System.out.println("File created");
                BufferedWriter bw = new BufferedWriter(new FileWriter(file1));
                bw.write("Hello World");
                bw.newLine();
                bw.write("gsl");
                bw.close();
            }
            else{
                System.out.println("File not created");
            }
        }

    }
}