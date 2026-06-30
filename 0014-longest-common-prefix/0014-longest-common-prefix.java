class Solution {
    public String longestCommonPrefix(String[] strs) {
        // first ko fix krnge aur bhkiyon ke sth compare krnge

        //edge case 
        if(strs==null || strs.length ==0){
            return "";  // as array exist but elemnt donot exist it acceess elemntrs but elemnts exist nhi krteso it throw null pointer exception so in oorder to prevent tghis i use null
        }

        // ideologfy ap ek ko fix kro bkiyon k sth comparision kro 

        String first = strs[0];  // array ka first idx ke sth fix krliya 

        // abh us index pr elkk string 
        for(int i = 0 ; i < first.length() ; i++){
            char ch = first.charAt(i);

            // abh jese flower uska phla charcter agya f usko mein array ke bki strings ke sth compare krungi

            for(int j = 1 ; j <strs.length ; j++){
                // what if meri hli string length jiyada aur agli ki km tous case return 
                if(i ==  strs[j].length() || ch != strs[j].charAt(i)){
                    return first.substring(0, i);

                }
            }
        }
        return first;


        
    }
}

