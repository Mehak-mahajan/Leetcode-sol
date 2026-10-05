class Solution {
    public List<Integer> partitionLabels(String s) {

        // in this ques it states that we have to partition the labels and the char of partition label should not come into the other  partition label 


        // i will store last occurence of cahracter for ex the 1st char is a and i dont know what its last occurence so i will the iterate over the string and again again i will overite its occurence so that become by the end of arrayt its last occurence 

        int[] last = new int[26]; // small lowercase char

        for(int i = 0 ; i < s.length() ; i++){

            last[s.charAt(i) - 'a'] = i ;
            //last[a-a = 0] = 0;



        }
        List<Integer> ans = new ArrayList<>();

        int start = 0 ;
        int end = 0;

        // after find the last occurence of all the lements there i have to find the range partitionning label

        for(int i = 0 ; i < s.length() ; i++){

            // what is my end so end is basically where it last reached 

            end = Math.max(end , last[s.charAt(i) - 'a']);
             // last occurence value if greater then it will expand 

            //when to cut the partition
            if(i == end){

                ans.add(end - start + 1);

                start = i + 1;

            }


        }
        return ans;


        
    }
}