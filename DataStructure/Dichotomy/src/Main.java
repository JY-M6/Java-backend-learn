import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,3,5,6,8,10,15,17,18));
        List<Integer> list1 = new ArrayList<>(Arrays.asList(3,5,2,7,6,8,4));
        list.sort(null);
        System.out.println(list);
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        int index = SearchSpecifiedNumber(list,num);
        int index1 = SearchThePeak(list1);
        if(index != -1){
            System.out.println("指定数字的索引为"+index);
        }else{
            System.out.println("该数不存在");
        }
        if(index1 != -1){
            System.out.println("一个峰值的索引为"+index1);
        }else{
            System.out.println("该数据中没有峰值");
        }
    }

    public static int SearchSpecifiedNumber(List<Integer> list, int num) {
        int L = 0;
        int R = list.size() - 1;
        while (L <= R) {
            int M = L+((R-L)/2);
            if(list.get(M) == num){
                return M;
            }else if(list.get(M)<num){
                L = M+1;
            }else if(list.get(M)>num){
                R = M-1;
            }
        }
        return -1;
    }

    public static int SearchThePeak(List<Integer> list) {
        int ans = -1;
        if(list.size() == 0){
            return -1;
        }else if(list.size() == 1){
            return 0;
        }
        int L = 0;
        int R = list.size() - 1;
        if(list.get(L) > list.get(L+1)){
            return L;
        }else if(list.get(R) > list.get(R-1)){
            return R;
        }
        L = L+1;
        R = R-1;
        while (L <= R) {
            int M = L+((R-L)/2);
            if(list.get(M) < list.get(M+1)){
                L= M+1;
            }else if(list.get(M) < list.get(M-1)){
                R= M-1;
            }else{
                ans = M;
                break;
            }
        }
        return ans;
    }
}