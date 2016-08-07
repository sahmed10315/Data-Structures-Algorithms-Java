package implementation.arrays;

import java.util.EmptyStackException;
import java.util.Iterator;

/* Array implementation of stacks.
 * Time complexity: 
 * Insertion/Deletion: O(1), O(1)
 * Search/Access O(n), O(n)	
 * Space Complexity: O(n)
 * */

public class Stack<T> {
	private int maxSize; // size of stack array
	private T[] stackArray;
	private int top; // top of stack

	@SuppressWarnings("unchecked")
	public Stack(int s) {
		maxSize = s; // set array size
		stackArray = (T[]) new Object[maxSize]; // create array
		top = -1; // no items yet
	}

	public void push(T item) // put item on top of stack
	{
		if (maxSize - 1 == top)
			throw new RuntimeException("Stack full");
		stackArray[++top] = item; // increment top, insert item
	}

	public T pop() // take item from top of stack
	{
		if (top == -1)
			throw new EmptyStackException();

		return stackArray[top--]; // access item, decrement top
	}

	public T peek() // peek at top of stack
	{
		if (top == -1)
			throw new EmptyStackException();

		return stackArray[top];
	}

	public boolean isEmpty() // true if stack is empty
	{
		return (top == -1);
	}

	public boolean isFull() // true if stack is full
	{
		return (top == maxSize - 1);
	}

	public T peekN(int n) // return item at index n
	{
		if (n >= maxSize || n < 0 || n > top)
			throw new RuntimeException("Invalid index.");

		return (T) stackArray[n];
	}

	public void displayStack(String s) {
		System.out.print(s);
		System.out.print("Stack (bottom-->top): ");
		for (int j = 0; j <= top; j++) {
			System.out.print(peekN(j));
			System.out.print(' ');
		}
		System.out.println("");
	}

	public Iterator<T> iterator() {
		Iterator<T> it = new Iterator<T>() {

			private int currentIndex = 0;

			@Override
			public boolean hasNext() {
				return currentIndex <= top;
			}

			@Override
			public T next() {
				return stackArray[currentIndex++];
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
		return it;
	}

	public static void main(String[] args) {
		Stack<Integer> theStack = new Stack<>(10); // make new stack
		theStack.push(20); // push items onto stack
		theStack.push(40);
		theStack.push(60);
		theStack.push(80);
		theStack.displayStack("Test: ");
		
		Iterator<Integer> itr = theStack.iterator();
		while(itr.hasNext()) {
	         Object element = itr.next();
	         System.out.print(element + " ");
	      }
		System.out.println("");
		
		while (!theStack.isEmpty()) {
			long value = theStack.pop();
			System.out.print(value); // display it
			System.out.print(" ");
		}
		System.out.println();
	}
}