class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minstack;
    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minstack.isEmpty() || val<=minstack.peek()){
            minstack.push(val);
        }
    }
    
    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        int val = stack.pop();
        if(minstack.peek()==val){
            minstack.pop();
        }
        
    }
    
    public int top() {
        if(stack.isEmpty()){
            return -1;
        }
        return stack.peek();
        
    }
    
    public int getMin() {
        if(minstack.isEmpty()){
            return -1;
        }
        return minstack.peek();
    }
}
