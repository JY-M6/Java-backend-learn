package SlidingWindow;
//力扣3. 无重复字符的最长子串
public class LongestSubstringWithoutRepeatingCharacters {
    int Max=Integer.MIN_VALUE;
    int[] cet=new int[256];
    int[] location=new int[256];
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.isEmpty()){
            return 0;
        }
        char[] ca=s.toCharArray();
        find(ca);
        return Max;
    }
    private void find(char[] ca){
        int start=0;
        int len=0;
        for(int end=0;end<ca.length;end++){
            if(cet[ca[end]]==0){
                cet[ca[end]]++;
                location[ca[end]]=end;
                len++;
            }else{
                while(start<=location[ca[end]]){
                    cet[ca[start]]--;
                    //location[ca[start]]=start;
                    len--;
                    start++;
                }
                len++;
                cet[ca[end]]++;
                location[ca[end]]=end;
            }


            Max = Max>len?Max:len;
        }

    }
}
