class Solution {
    public int myAtoi(String s) {
        // we will not preprocess anything we will check 
        // if the overflows happens it should return at that instant 



        int sign = 1;
        int result = 0 ;
        int i = 0 ;
        int n = s.length();

                // 1. we will check the whitespaces 

        while(i < n && s.charAt(i) == ' '){
            i++;
        }

        // 2 checking sign we only concludee the sign here at last we will put into the result 

        if( i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        //3..start formin the disgit sacn kiya if it is digit 

        while( i < n && Character.isDigit(s.charAt(i)) ){
            int digit = s.charAt(i) - '0';   // ascii value of no in string when we substract it will give ana integer 
            //result = result * 10 + digit;


            //before adding the disgit u should check overflow condition 

            if( result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && digit > 7){
                if(sign == 1){
                    return Integer.MAX_VALUE;
                }
                else{
                   return Integer.MIN_VALUE;
                }
            }

            result = result * 10 + digit;

            i++;

        }

        return sign * result;

    }
}





        

      
        