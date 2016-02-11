package Arrays;

import java.util.Stack;

/**
 * Created by Le on 2016/2/11.
 */
public class MinStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MinStack() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int num) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(num);
        } else if (num < this.getMin()) {
            this.stackMin.push(num);
        } else {
            int currentMin = this.stackMin.peek();
            this.stackMin.push(currentMin);
        }
        this.stackData.push(num);
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        this.stackMin.pop();
        return this.stackData.pop();
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return this.stackMin.peek();
    }

}
