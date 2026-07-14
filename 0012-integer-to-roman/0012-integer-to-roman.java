class Solution {
    public String intToRoman(int num) {

        int[] values = {1000 , 900 , 500 , 400 , 100 , 90 , 50 , 40 , 10 , 9 , 5 , 4 , 1};

        String[] symbols = { "M"  ,  "CM" , "D" , "CD" , "C" , "XC" , "L" , "XL" , "X" , "IX" , "V" , "IV" , "I"};

        StringBuilder ans = new StringBuilder();

        for(int i = 0 ; i < values.length; i++){

            while(num >= values[i]){
                ans.append(symbols[i]);

                num -= values[i];

            }

        }

        return ans.toString();

        
        
    }
}

// WHILE APPROACH MEIN MODLULO IMP NHI BECAUSE ANS WRONG AYGA AS 3000 NOW 3000>=1000 OK APPEND M OK NOW 3000%1000 = 0 AND IT STOPS BUT ACTUAL ANS MMM

// IF U WANT TO WRITE MODULO PART THEN ITERATE KIYA ARRAY MEIN STORE KRVAYA int count = num / values[i] while cont > 0 then append and count -- 

// num = num%values[i]