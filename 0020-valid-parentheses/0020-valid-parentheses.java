class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>(); // inbuilt 

        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);

            if(ch == '('|| ch == '[' || ch == '{'){
                st.push(ch);  // opening bracket 
            }

            else{
                if(st.isEmpty()){
                return false; // else closening bracket
           
            }
            char top = st.pop();

            ///check closening character matches wd top 
            if((ch == ')'  && top != '(' ) || (ch == ']' && top != '[') || (ch == '}' && top != '{')){
                return false;
            }

            }

            

        }

        // if all opening brackets match return
        return st.isEmpty();
        

        
        
        
    }
}