class Solution {
    public String largestOddNumber(String num) {

        for(int i=num.length() - 1 ; i >=0 ; i--){
            char ch = num.charAt(i);

            // string ke andr no hai 

            if((ch - '0')%2!= 0 ){
                // abh jhn first odd mila return kyuki mereko vo bhi include krna

                return num.substring(0,i+1);
            }


        }
        return "";


        

    }
}


