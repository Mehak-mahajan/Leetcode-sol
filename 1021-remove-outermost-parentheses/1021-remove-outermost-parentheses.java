class Solution {
    public String removeOuterParentheses(String s) {

        int count = 0 ;

        
        //"( , '')"

        // our  count when 0 has two p-ossibilities string empty and no of openings = no of closening 

        // our add only when count 0  greate r 
        StringBuilder ans = new StringBuilder();

        for(char ch :  s.toCharArray()){

            if( ch == '('){
                if(count > 0){
                    ans.append(ch);
                }

                count++;
            }

            else{
                count--;
                if(count >0){
                    ans.append(ch);
                }
            }

        }

        return ans.toString();

        
    }
}