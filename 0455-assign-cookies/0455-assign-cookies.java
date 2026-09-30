class Solution {
    public int findContentChildren(int[] g, int[] s) {

        // so the key intuition is that we have assign the max to max cookies make sure that smallest sufficient cookie we have to assign so that we preserve for other and if the requirement is low and we allocate the greater cookie to it that means we are not preserving for those who actually needed it 

        Arrays.sort(g); // g is basically child needs that cookies for example child 1 needs 1 cookie
        Arrays.sort(s); // size of cookie 

        int ans = 0 ; // if cookie staisfy the child need then just increment the ans 
        int i = 0;
        int j= 0; // poinyers 

        while(i < g.length && j < s.length){
            if(s[j] >= g[i]){
                // size of cookie greater than requirement 

                j++;
                i++;
                ans += 1; // increment the ans as we have tell that how many children get contented 

            }
            else{
                // size less than requirement 
                // that means in future it doenot meet the future requireents of cookie so child reamin same s move 

                j++;


            }
        }
        return ans;

        
    }
}