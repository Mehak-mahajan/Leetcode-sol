class Solution {
    public String reverseWords(String s) {

        ///  first we covert stribng into the array in order to access the indices 

        String[] words = s.trim().split("\\s+");  // continues string hai usko array mein convert kiya and leadind or trailing spaces ko trim remove blrkta aur multiple spaces ko s+

        //empty string 

        StringBuilder ans = new StringBuilder();

        // basic idea is that traverse from last appen dthe vlaue 

        for(int i = words.length - 1 ; i >=0 ; i--){
            ans.append(words[i]);
            if(i!=0){
                ans.append(" ");
            }
        }
        return ans.toString();

        
    }
}