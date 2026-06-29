class Solution {
    public boolean rotateString(String s, String goal) {

        if(s.length() != goal.length()){
            return false;
        }

        // optimizeed instead of running 2 loops can isay my rotation will store in s+s

        return (s+s).contains(goal);
        
    }
}