package stack.applications.infixtopostfix;

//infix.java
//converts infix arithmetic expressions to postfix
//to run this program: C>java InfixApp
import java.io.*; // for I/O 

import implementation.arrays.Stack;

class InfixToPostfix // infix to postfix conversion
{
	private Stack theStack;
	private String input;
	private String output = "";

	public InfixToPostfix(String in) {
		input = in;
		int stackSize = input.length();
		theStack = new Stack(stackSize);
	}

	public String doTrans() // do translation to postfix
	{
		for (int j = 0; j < input.length(); j++) // for each char
		{
			char ch = input.charAt(j); // get it
			theStack.displayStack("For " + ch + " "); // *diagnostic*
			switch (ch) {
			case '+': // it's + or -
			case '-':
				gotOper(ch, 1); // go pop operators
				break; // (precedence 1)
			case '*': // it's * or /
			case '/':
				gotOper(ch, 2); // go pop operators
				break; // (precedence 2)
			case '(': // it's a left paren
				theStack.push(ch); // push it
				break;
			case ')': // it's a right paren
				gotParen(ch); // go pop operators
				break;
			default: // must be an operand
				output = output + ch; // write it to output
				break;
			} // end switch
		} // end for
		while (!theStack.isEmpty()) // pop remaining opers
		{
			theStack.displayStack("While "); // *diagnostic*
			output = output + theStack.pop(); // write to output
		}
		theStack.displayStack("End   "); // *diagnostic*
		return output; // return postfix
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
			} // end else (it's an operator)
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
		} // end while
	}
}

public class InfixToPostfixConv {
	public static void main(String[] args) throws IOException {
		String input, output;
		while (true) {
			System.out.print("Enter infix: ");
			System.out.flush();
			input = getString(); // read a string from kbd
			if (input.equals("")) // quit if [Enter]
				break;
			// make a translator
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