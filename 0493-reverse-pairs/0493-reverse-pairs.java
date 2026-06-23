class Solution {
    public int reversePairs(int[] nums) {
        // merege sort algorithm because brute force takes o(n2) time ok 5*10^8 not workable gives tle 

        // merge sort 
       return mergeSort(nums , 0 , nums.length-1);
        
    }

    private int mergeSort(int[] nums , int low , int high){
        int count = 0;

        // base case check 
        if(low>= high){
            return 0;
        }

        int mid = low + (high - low) /2;

        // left dive 
        count += mergeSort(nums , low , mid) ;
        // right 
        count += mergeSort(nums , mid + 1, high);

        // when both left and right hit sthe base case jnoe // merge krlete ho

        count += reversePairs(nums , low , mid , high);

        merge(nums , low , mid , high);

        return count;
    }

    private int reversePairs(int[]nums , int low , int mid , int high){
        int i = low;
        int j = mid + 1;
        int count = 0;

        while(i <= mid && j <= high){

            if((long) nums[i] >2L * nums[j] ){
                count += (mid - i +1); // mid - i + 1 formula comes if current elemnt greater sorted ke to bd vle elemnts v greater honge 
                j++;

                // jb merei condition false hoti tb i move krta vrnba j move krta 

            }
            else{
                i++;

            }
        }
        return count;


    }

    private void merge(int[] nums , int low , int mid , int high){
        // sorte halves ko merge karenge 
        int left = low ;
        int right = mid + 1;
        int k = 0;

        int [] temp = new int[high - low +1] ;// temporary array contain or merge the two sorted half arrays 

        while(left <= mid && right <= high){
// now the array is sorted so we have to utiulise this part na lower value comes first and greater value comes later 
            if( nums[left] <= nums[right]){
                temp[k] = nums[left];
                k++;
                left++;
            }
            else{
                temp[k] = nums[right];
                right++;
                k++;
            }
            }

            // what if agar ek array exhaust hogya 
            while(left <= mid){
                temp[k] = nums[left];
                left++;
                k++;
            }

            while(right <= high){
                temp[k] = nums[right];
                right++;
                k++;

            }
        

            // copy back into riginal arrayu 
            for(int ind = 0 ; ind <temp.length; ind++){
                //as our original array not always merged from 0 we have to update part of low to high
                nums[low+ind] = temp[ind];
            }
        }
    }
