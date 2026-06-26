class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        // our result store the left elemnts 

        // it start from index 1 we r finding left to that index if it strts from 0 it goes out of bound

        result[0] = 1;
        for(int i = 1 ; i < nums.length ; i++){
            result[i] = result[i-1]*nums[i-1];


        }

        int right = 1;

        for(int i = nums.length -1 ; i>=0 ;i--){
            result[i] = result[i] * right;

            right= right*nums[i];
        }

        return result;


        
    }
}

// instead of creating separate left and right array it wil take the extra space we will use space in result