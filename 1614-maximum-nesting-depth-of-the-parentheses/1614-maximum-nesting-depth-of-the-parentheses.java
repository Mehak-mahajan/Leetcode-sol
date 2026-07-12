class Solution {
    public int maxDepth(String s) {

        // MAX NESTING DEPTH 
        int maxDepth = 0 ; 
        int depth = 0 ;

        for(char ch : s.toCharArray()){
            if( ch == '('){
                depth++ ;
                maxDepth = Math.max(depth , maxDepth);

            }
            else if( ch == ')'){// here my mistake is i use else but we fant use else because other than opening bracket everythinh other included it will eventually decrease the depth
                depth--;
            }
        }
        return maxDepth;

        
        
    }
}