package bracketchecker.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import arrays.stack.implementation.Stack;

class BracketCheck {
	private String input;  

	public BracketCheck(String in)  
	{
		input = in;
	}
 
	public void check() {
		int stackSize = input.length();  
		Stack theStack = new Stack(stackSize);  

		for (int j = 0; j < input.length(); j++)  
		{
			char ch = input.charAt(j); 
			switch (ch) {
			case '{': // opening symbols
			case '[':
			case '(':
				theStack.push(ch);  
				break;

			case '}': // closing symbols
			case ']':
			case ')':
				if (!theStack.isEmpty())  
				{
					char chx = (char) theStack.pop(); // pop and check
					if ((ch == '}' && chx != '{') || (ch == ']' && chx != '[') || (ch == ')' && chx != '('))
						System.out.println("Error: " + ch + " at " + j);
				} else // prematurely empty
					System.out.println("Error: " + ch + " at " + j);
				break;
			default:  
				break;
			} 
		}  
		if (!theStack.isEmpty())
			System.out.println("Error: missing right delimiter");
	}  
}  

public class BracketChecker {
	public static void main(String[] args) throws IOException {
		String input;
		while (true) {
			System.out.print("Enter string containing delimiters: ");
			System.out.flush();
			input = getString();  
			if (input.equals("")) // quit if [Enter]
				break; 
			BracketCheck theChecker = new BracketCheck(input);
			theChecker.check(); // check brackets
		}  
	} 

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	} 
} 