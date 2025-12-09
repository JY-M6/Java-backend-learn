import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦",100);
        books[1] = new Book("金瓶梅新",90);
        books[2] = new Book("青年文摘20年",5);
        books[3] = new Book("java从入门到精通",300);
        Book[] book = new Book[books.length];
        book = Arrays.copyOf(books,books.length);
        Arrays.sort(books,new Comparator(){
            public int compare(Object o1, Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
                double d1 = b1.getPrice() - b2.getPrice();
                if(d1>0){
                    return 1;
                }
                else if(d1<0){
                    return -1;
                }
                else{
                    return 0;
                }
            }
        });
        Arrays.sort(book,new Comparator(){
            public int compare(Object o1, Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
                double d1 = b1.getName().length() - b2.getName().length();
                if(d1>0){
                    return 1;
                }
                else if(d1<0){
                    return -1;
                }
                else{
                    return 0;
                }
            }
        });
        System.out.println("book的顺序："+Arrays.toString(book));
        System.out.println("books的顺序："+Arrays.toString(books));
    }
    public static void bobblesort(Book[] books) {

    }
}
class Book{
    String name;
    double price;

    public Book(String name,double price) {
        this.price = price;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}