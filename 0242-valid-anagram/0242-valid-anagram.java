import java.util.*;
class Solution {
    public  static boolean isAnagram(String s, String t) {
        if(s==null|| t==null){
            return false;
        }
        if(s.length()!= t.length()){
            return false;
        }
        s= s.toLowerCase();
        t=t.toLowerCase();
        char[] array1=s.toCharArray();
        char[] array2= t.toCharArray();

        Arrays.sort(array1);
        Arrays.sort(array2);

       return Arrays.equals(array1,array2);
        
    }
}
    