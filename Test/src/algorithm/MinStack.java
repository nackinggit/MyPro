package algorithm;

import java.util.ArrayList;

public class MinStack {
	public ArrayList<Integer> stack = new ArrayList<Integer>();
	public ArrayList<Integer> minStack = new ArrayList<Integer>();
	
	
	public void push(int x) {
        int size = stack.size();
        
        if(size == 0) {
        	minStack.add(0);
        } else {
			int minPosition = minStack.get(size-1);
			int minData = stack.get(minPosition);
			
			if(minData > x) {
				minStack.add(stack.size());
			} else {
				minStack.add(minPosition);
			}
		}
        
        stack.add(x);
    }

    public void pop() {
        int size = stack.size();
        stack.remove(size-1);
        minStack.remove(size-1);
    }

    public int top() {
        int size = stack.size();
        return stack.get(size-1);
    }

    public int getMin() {
        int size = minStack.size();
        return stack.get(minStack.get(size-1));
    }
}
