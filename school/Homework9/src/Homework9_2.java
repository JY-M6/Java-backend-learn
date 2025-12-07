import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Homework9_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input several Book,in the end #");
        List<Book> books1 = new ArrayList<Book>(10);
        while (true) {
            String[] input = sc.nextLine().split(",");
            if (input[0].equals("#")){
                break;
            }
            books1.add(new Book(input[0],Double.parseDouble(input[1])));
        }
        System.out.println("input a new Book:");
        String[] input = sc.nextLine().split(",");
        Book newBook = new Book(input[0],Double.parseDouble(input[1]));
        for (int j = 0; j < books1.size(); j++){
            int num = books1.get(j).compareTo(newBook);
            if (num == 0){
                System.out.println("new book:<"+input[0]+">as same books\n"+books1.get(j).getName()+","+Double.parseDouble(input[1]));
                break;
            }else if (j == books1.size() - 1){
                System.out.println("new book:<"+newBook.getName()+">as same books\n");
            }
        }
    }
}
class Book implements Comparable<Book> {
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public Book(String name, double price) {
        this.price = price;
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Book o) {
        return Double.compare(this.price,o.price);
    }
}