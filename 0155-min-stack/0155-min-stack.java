class MinStack {
    Stack<Integer> stack ;
    Stack<Integer> minstack;

    public MinStack() {

        stack = new Stack<>();
        minstack = new Stack<>();


       
    }
        
    
    
    public void push(int value) {
        stack.push(value);

        // how we push when min stack is empty and when val in min stack is greater than the new val m

        if(minstack.isEmpty() || value <= minstack.peek()){
            minstack.push(value);
        }
        
        
    }
    
    public void pop() {

        // in popping out what happens na in genral we think that we have to pop out from the main stack but what if both elemnts value are same in both stack and i just pop from main stack value not from min stack so min stack still points to that avlue and retyurn that value but that value not actually exists in main stack

        if(stack.peek().equals(minstack.peek())){
            minstack.pop();
        }
        stack.pop();
        
    }
    
    public int top() {

        return stack.peek();
        
    }
    
    public int getMin() {
        return minstack.peek();
        
    }
}


// if i have to solve this ques in o(n) tym  min initialize the max value iterate over stack and min = math.mibn(num, min) rturn min

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */