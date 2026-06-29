class Solution {
    public boolean isIsomorphic(String s, String t) {

        // as constraint is given ascii character we know 256 size so we created two arrays fixed size 256 why 2 arrays bozonetrcks the elemnts of ch1and other ch 2 it isnot storngthe elemnts it goes to index 

        if(s.length() != t.length()){
            return false;
        }

        int[] arr1 = new int[256];
        int[] arr2 = new int[256];
         for(int i = 0 ; i < s.length() ; i++){
             char ch1 = s.charAt(i);
             char ch2 = t.charAt(i);

             if(arr1[ch1] != arr2[ch2]){
                // to yh characteraascii code pr gya initially sri values 0 hoti
                return false;
             }

            arr1[ch1]= i+1;
            arr2[ch2] = i + 1;


         }
         return true;
        
    }
}