class Solution {
    public  static int fib(int n) {
        //end base case
        if(n == 0 || n == 1){
            return n ;
        }
        return fib(n - 1)+ fib(n - 2);
        
    }
}
   