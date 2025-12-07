public class Homework2 {
    public static void main(String[] args) {
        String content ="900.3";
        String regStr ="^[-+]?([1-9]\\d*|0)(\\.\\d+)?$";
        if(content.matches(regStr)) {
            System.out.println("匹配成功，是整数或小数");
        }else{
            System.out.println("匹配失败");
        }
    }
}