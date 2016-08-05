package stringreverse.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import arrays.stack.implementation.Stack;

class Reverse {
	private String input; // input string
	private String output; // output string 

	public Reverse(String in) 
	{
		input = in;
	}
 
	public String reverse() 
	{
		int stackSize = input.length(); // get max stack size
		Stack theStack = new Stack(stackSize); // make stack

		for (int j = 0; j < input.length(); j++) {
			char ch = input.charAt(j); // get a char from input
			theStack.push(ch); // push it
		}
		output = "";
		while (!theStack.isEmpty()) {
			char ch = (char) theStack.pop(); // pop a char,
			output = output + ch; // append to output
		}
		return output;
	}  
}  

public class Reverser {
	public static void main(String[] args) throws IOException {
		String input, output;
		while (true) {
			System.out.print("Enter a string: ");
			System.out.flush();
			input = getString();  
			if (input.equals(""))  
				break;
			// make a Reverser
			Reverse theReverser = new Reverse(input);
			output = theReverser.reverse(); 
			System.out.println("Reversed: " + output);
		}  
	}  

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	} 
}  
