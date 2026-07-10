class Solution {
    public int beautySum(String s) {

        int ans = 0;

        for(int i = 0 ; i < s.length() ;i++){
            for(int j = i; j < s.length(); j++){


                // array 26 size

                int freq[] = new int[26];

                for(int k = i ; k<=j ; k++ ){
                 //   char ch = s.charAt(k);

                    freq[s.charAt(k) - 'a']++;
                }

                int max = Integer.MIN_VALUE;

                int min = Integer.MAX_VALUE;


                for(int f : freq){

                    if(f>0){
                        max = Math.max(f,max);
                        min= Math.min(f,min);
                    }
                }

                 ans += (max - min);


            }
        }

        return ans;
        
    }
}


// generate all substrings 