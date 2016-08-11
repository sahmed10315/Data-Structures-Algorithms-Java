package implementation.arrays;

import java.util.EmptyStackException;

public class DynamicStack {

	private int stackSize;
	private int[] stackArr;
	private int top;

	public DynamicStack(int size) {
		this.stackSize = size;
		this.stackArr = new int[stackSize];
		this.top = -1;
	}

	public void push(int entry) {
		if (this.isStackFull()) {
			System.out.println(("Stack is full. Increasing the capacity."));
			this.increaseStackCapacity();
		}
		System.out.println("Adding: " + entry);
		this.stackArr[++top] = entry;
	}

	public int pop() {
		if (this.isStackEmpty()) {
			throw new EmptyStackException();
		}
		int entry = this.stackArr[top--];
		System.out.println("Removed entry: " + entry);
		return entry;
	}

	public long peek() {
		return stackArr[top];
	}

	private void increaseStackCapacity() {

		int[] newStack = new int[this.stackSize * 2];
		for (int i = 0; i < stackSize; i++) {
			newStack[i] = this.stackArr[i];
		}
		this.stackArr = newStack;
		this.stackSize = this.stackSize * 2;
	}

	public boolean isStackEmpty() {
		return (top == -1);
	}

	public boolean isStackFull() {
		return (top == stackSize - 1);
	}

	public static void main(String[] args) {
		DynamicStack stack = new DynamicStack(2);
		for (int i = 1; i < 10; i++) {
			stack.push(i);
		}
		for (int i = 1; i < 4; i++) 
				stack.pop();
	}
}