class Solution {
    public int maxProduct(int[] nums) {

        //if even no of negative no contains to max product to entire RRAY 


        // if odd no negative yn max sum till first neg yn after last negative two scans 
        int prefix= 1;
        int suffix = 1;
        int ans = Integer.MIN_VALUE;

        for(int i = 0 ; i < nums.length ; i++){
            // left to right scan 

            prefix *= nums[i];

            ans = Math.max(ans, prefix);

            if(prefix ==0){
                prefix = 1; // because it will make further value also 0 so restart from fresh 
            }
        }

             for(int i = nums.length - 1 ; i >= 0; i--){
            // left to right scan 

            suffix *= nums[i];

            ans = Math.max(ans, suffix);

            if(suffix ==0){
                suffix = 1; // because it will make further value also 0 so restart from fresh 
            }
             }

            return ans ;



        }
        
    }


// in this ques we cant use sliding window ngative value as we want subbaaray cant use two pointers as hashmap + prefix sum applies for sum related 