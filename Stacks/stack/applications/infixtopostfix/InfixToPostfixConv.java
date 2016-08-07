package stack.applications.infixtopostfix;
 
/* Converts infix arithmetic expressions to postfix */ 

import java.io.*; 

import implementation.arrays.Stack;

class InfixToPostfix
{
	private Stack<Character> theStack;
	private String input;
	private String output = "";

	public InfixToPostfix(String in) {
		input = in;
		int stackSize = input.length();
		theStack = new Stack<>(stackSize);
	}

	public String doTrans()
	{
		for (int j = 0; j < input.length(); j++)  
		{
			char ch = input.charAt(j);  
			 
			switch (ch) {
			case '+': 
			case '-':
				gotOper(ch, 1); // go pop operators
				break; // (precedence 1)
			case '*':  
			case '/':
				gotOper(ch, 2); 
				break; // (precedence 2)
			case '(':  
				theStack.push(ch);  
				break;
			case ')':  
				gotParen(ch); // go pop operators
				break;
			default: // must be an operand
				output = output + ch; // write it to output
				break;
			}  
		}  
		while (!theStack.isEmpty()) // pop remaining opers
		{
			theStack.displayStack("While "); // *diagnostic*
			output = output + theStack.pop(); // write to output
		}
		theStack.displayStack("End   "); // *diagnostic*
		return output;
	}

	public void gotOper(char opThis, int prec1) { // got operator from input
		while (!theStack.isEmpty()) {
			char opTop = (char) theStack.pop();
			if (opTop == '(') // if it's a '('
			{
				theStack.push(opTop); // restore '('
				break;
			} else // it's an operator
			{
				int prec2; // precedence of new op

				if (opTop == '+' || opTop == '-') // find new op prec
					prec2 = 1;
				else
					prec2 = 2;
				if (prec2 < prec1) // if prec of new op less
				{ // than prec of old
					theStack.push(opTop); // save newly-popped op
					break;
				} else // prec of new not less
					output = output + opTop; // than prec of old
			}
		}  
		theStack.push(opThis); // push new operator
	}

	public void gotParen(char ch) { // got right paren from input
		while (!theStack.isEmpty()) {
			char chx = (char) theStack.pop();
			if (chx == '(') // if popped '('
				break; // we're done
			else // if popped operator
				output = output + chx; // output it
		}  
	}
}

public class InfixToPostfixConv {
	public static void main(String[] args) throws IOException {
		String input, output;
		while (true) {
			System.out.print("Enter infix: ");
			System.out.flush();
			input = getString(); 
			if (input.equals(""))  
				break; 
			InfixToPostfix theTrans = new InfixToPostfix(input);
			output = theTrans.doTrans(); // do the translation
			System.out.println("Postfix is " + output + '\n');
		}
	}

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
}