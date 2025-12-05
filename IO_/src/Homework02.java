import java.io.*;

public class Homework02 {
    public static void main(String[] args) throws IOException {
    String name = "d:\\java\\trial\\IO_\\mytemp\\hello.txt";
    BufferedReader br = new BufferedReader(
            new FileReader(name));
    String line;
    int i = 1;
    while ((line = br.readLine()) != null) {
        System.out.println(i++ +"."+line);
    }
    br.close();
    }
}
