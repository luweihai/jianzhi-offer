/*
首先，初始化的构造方法是可以为空的，只要在前面初始化了，当然也可以留在构造方法中初始化
此外，要理解题目的思路。
我们要用两个栈实现，一个 stack 和 一个 minstack 
最直观的思路是，每次判断入栈的元素和当前最小栈 minstack 的栈顶元素的大小，如果小于minstack 栈顶元素就把与minstack 的栈顶元素再次入 minstack
这样可能 minstack 中多个元素相同，而且保持了与 stack中元素的同步
要取出最小的元素，就直接 minstack.peek()即可
*/


public class Solution {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minstack = new Stack<>();
    public void push(int node) {
        if(minstack.isEmpty() == true || minstack.peek() > node){     // 关键是这里以及接下来的几句   这几句实现了两个栈的同步
            minstack.push(node);
        }
        else{
            minstack.push(minstack.peek());
        }
        stack.push(node);
    }
    
    public void pop() {
        minstack.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        return minstack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */