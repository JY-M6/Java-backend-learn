import java.util.*;
public class Homework1 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new News("新冠确诊病例超千万，数百万印度教信徒赴恒河\"圣浴\"引起民众担忧"));
        list.add(new News("男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生"));
        for(int i = list.size()-1;i>=0; i--){
            News news = (News) list.get(i);
        System.out.println(process(news));
        }
    }
    public static String process(News news){
        if(news.getTitle().length()>15){
            news.setTitle(news.getTitle().substring(0,15)+"...");
            return news.getTitle();
        }
        else
            return news.getTitle();
    }
}
class News{
    String title;
    String content;

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public News(String title) {
        this.title = title;
    }
}