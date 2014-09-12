package evaluateReversePolishNotation;

import java.util.Stack;
/**
 * Using Stack to deal with it
 * @author Ricky
 *
 */
public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens){
		Stack<String> stack = new Stack<String>();
		String result = "";
		int len = tokens.length;
		if (len==1) {
			return Integer.parseInt(tokens[0]);
		}
		
		for (String token : tokens){
			if (!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")){
				stack.push(token);
			}
			else{
				String right = stack.pop();
				String left = stack.pop();
				result = Caculation(left, right, token);
				stack.push(result);
			}
		}
		
		result = stack.pop();
		
		return Integer.parseInt(result);
	}

	private String Caculation(String left, String right, String token) {
		int l = Integer.parseInt(left);
		int r = Integer.parseInt(right);
		int result = 0;
		switch (token){
		case "+": 
			result = l + r;
			break;
		case "-": 
			result = l - r;
			break;
		case "*": 
			result = l * r;
			break;
		case "/": 
			try {
				result = l / r;
			}
			catch(ArithmeticException e){
				System.out.println("Error happens" + e.getMessage());
			};
			break;
		}
		return String.valueOf(result);
	}
}
