package stack.applications.stringreverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import implementation.arrays.Stack;

class Reverse {
	private String input;  
	private String output;  

	public Reverse(String in) 
	{
		input = in;
	}
 
	public String reverse() 
	{
		int stackSize = input.length(); 
		Stack theStack = new Stack(stackSize); 

		for (int j = 0; j < input.length(); j++) {
			char ch = input.charAt(j);  
			theStack.push(ch);  
		}
		output = "";
		while (!theStack.isEmpty()) {
			char ch = (char) theStack.pop(); 
			output = output + ch;  
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
