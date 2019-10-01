/*
 * @lc app=leetcode id=232 lang=java
 *
 * [232] Implement Queue using Stacks
 */
class MyQueue {
    
    /** Initialize your data structure here. */
    Stack<Integer> stack_start;
    Stack<Integer> stack_end; 
    Integer res;
    public MyQueue() {
        stack_start = new Stack<>();
        stack_end = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {  
        
        stack_start.push(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {  
      if(stack_end.isEmpty()){
        while(!stack_start.isEmpty()){
            stack_end.push(stack_start.pop());
        }
      }
        return stack_end.pop();
    }
    
    /** Get the front element. */
    public int peek() {
      if(stack_end.isEmpty()){
        while(!stack_start.isEmpty()){
            stack_end.push(stack_start.pop());
        }
      }
        return stack_end.peek();
    
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        
        return stack_start.isEmpty()&&stack_end.isEmpty();
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
