class Solution {
    public boolean checkValidString(String s) {

        // Pass 1: Left -> Right
        // Treat '*' as '('
        int open = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(' || ch == '*') {
                open++;
            } else { // ')'
                open--;
            }

            if (open < 0) {
                return false;
            }
        }

        // Pass 2: Right -> Left
        // Treat '*' as ')'
        int close = 0;

        for (int i = s.length() - 1; i >= 0; i--) {

            char ch = s.charAt(i);

            if (ch == ')' || ch == '*') {
                close++;
            } else { // '('
                close--;
            }

            if (close < 0) {
                return false;
            }
        }

        return true;
    }
}

// for this case tc o(n ) space complexity 0(1)

// class Solution {
//     public boolean checkValidString(String s) {

//         Stack<Integer> open = new Stack<>();
//         Stack<Integer> star = new Stack<>();

//         // best example *(())(*

//         for (int i = 0; i < s.length(); i++) {

//             char ch = s.charAt(i);

//             if (ch == '(') {
//                 open.push(i);
//             } 
//             else if (ch == '*') {
//                 star.push(i);
//             } 
//             else { // ch == ')'

//                 if (!open.isEmpty()) {
//                     open.pop();
//                 } 
//                 else if (!star.isEmpty()) {
//                     star.pop();
//                 } 
//                 else {
//                     return false;
//                 }
//             }
//         }
//         // after end of stack closening bracket aa nhi skti yh sth sth mein processs hojygi 

//         // and if after processing the entire string at the end opening bracket bchi to usko star ke sth replace krna pr konse star ke sth krba thats why we store indices 

//         // Match remaining '(' with '*' that occur after them
//         while (!open.isEmpty() && !star.isEmpty()) {

//             if (open.peek() < star.peek()) {
//                 open.pop();
//                 star.pop();
//             } 
//             else {
//                 return false;
//             }
//         }

//         return open.isEmpty();
//     }
// }

// whenever the options is given give a try out to recursion also but is not efficient if the * is n then there would be 3*n possiblities

// second approach whenver u see the valid paranthesis string give a try to stack approach also
