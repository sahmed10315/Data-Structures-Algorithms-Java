package stack.applications.evaluatepostfix;

/* The postfix notation(RPN) is used to represent algebraic expressions. The expressions written in postfix form are evaluated 
 * faster compared to infix notation as parenthesis are not required in postfix. This program evaluates postfix arithmetic expressions.
 * 
 * Time complexity: O(N)
 */

import java.io.*;

import implementation.arrays.Stack;

class ParsePost {
	private Stack<Integer> theStack;
	private String input;

	public ParsePost(String s) {
		input = s;
	}

	public int doParse() {
		theStack = new Stack<Integer>(20);
		char ch;
		int j;
		int num1, num2, interAns;

		for (j = 0; j < input.length(); j++) {
			ch = input.charAt(j);

			if (ch >= '0' && ch <= '9')
				theStack.push(ch - '0');
			else // it's an operator
			{
				num2 = (int) theStack.pop(); // pop operands
				num1 = (int) theStack.pop();
				switch (ch) // do arithmetic
				{
				case '+':
					interAns = num1 + num2;
					break;
				case '-':
					interAns = num1 - num2;
					break;
				case '*':
					interAns = num1 * num2;
					break;
				case '/':
					interAns = num1 / num2;
					break;
				default:
					interAns = 0;
				}
				theStack.push(interAns); // push result
			}
		}
		interAns = (int) theStack.pop(); // get answer
		return interAns;
	}
}

public class EvaluatePostfix {
	public static void main(String[] args) throws IOException {
		String input;
		int output;

		while (true) {
			System.out.print("Enter postfix: ");
			System.out.flush();
			input = getString();
			if (input.equals(""))
				break;
			ParsePost aParser = new ParsePost(input);
			output = aParser.doParse(); // do the evaluation
			System.out.println("Evaluates to " + output);
		}
	}

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
}