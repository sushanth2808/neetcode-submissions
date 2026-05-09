class MinStack {

    Stack<Long> stack;
    long min;
    public MinStack() {
        stack = new Stack<>();
        min=0L;
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(0L);
            min=val;
        }
        else {
             stack.push(val-min);
                if(val-min<0){
                min=val;
                }
        }

    }
    
    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        long val = stack.pop();
        if(val<0){
            min=min-val;
        }
    }
    
    public int top() {
        long val = stack.peek();
        if(val>=0){
            return (int) (val+min);
        }
        else{
             return (int) min;
        }  
    }
    
    public int getMin() {
        return (int) min;
    }
}
