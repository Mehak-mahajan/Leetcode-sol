class Solution {
    public String longestPalindrome(String s) {

        //optimal sol expand around each centre 

         if(s.length() <2 || s == null){
            return s;
         }
        int start = 0 ;
        int end = 0 ;

        for(int i = 0 ; i < s.length() ; i++){
            // for every index u have to check odd / enven palindrome 

            int len1 =  isPalindrome(s,i,i); // odd

            int len2 = isPalindrome(s,i,i+1); // even 

            int len = Math.max(len1, len2);

            if(len > end - start + 1){
                 start = i - (len - 1)/ 2;
                 end = i + len / 2 ; // works for both even and odd i +(l - 1) / 2 donot work 4 even 
            }
            

            // now i want to print longest substring i need start end 
        }

        return s.substring(start , end + 1);

    }
        private int isPalindrome(String s , int left , int right){
            // when i expand it left out of boud right

            while(left>=0 && right < s.length()){
                if(s.charAt(left) == s.charAt(right)){

                    left--;
                    right++;

                }
                else{

                    break;

                }

                

            }
            return right - left - 1;
            // as if it is palindrome now bab is palindrome length (babad)

            //3-(-1) - 1 = 3 bab asit moves ponter ahead 
            
        }


        
    }


// check whetger string plaindromic or not
// two pointer s.charatleft = s.chartAt right equal 

// 0(n3) 
// o(n2) for generating all the substrings is it palindrome if yes len = j - i + 1
// max = -1 len > max then max = len ans= s.substring(i,j1)
