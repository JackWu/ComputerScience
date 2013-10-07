package datastructure;

import java.util.Stack;

//Last In First Out
public class StackProblems {
	
	/*
	 * Test cases:
	 * ")(dkk)()"       invalid
	 * "((alf)ls)"		valid			
	 */
	public boolean isBalanced(String s){
		Stack<Character> stack = new Stack<Character>();
		
		final char l_parent = '(';
		final char r_parent = ')';
		final char l_brace = '{';
		final char r_brace = '}';
		final char l_bracket = '[';
		final char r_bracket = ']';
		
		for(int i = 0; i < s.length(); i++){

			if(s.charAt(i)==l_parent)
				stack.push(l_parent);

			else if(s.charAt(i)==l_parent)
				stack.push(l_parent);
			
			else if(s.charAt(i)==l_bracket)
				stack.push(l_bracket);
			
			else if(s.charAt(i)==r_parent){
				if(stack.isEmpty()) return false;
				if(stack.pop()!=l_parent) return false;
			}
			else if(s.charAt(i)==r_brace){
				if(stack.isEmpty()) return false;
				if(stack.pop()!=l_brace) return false;}
			
			else if(s.charAt(i)==r_bracket){
				if(stack.isEmpty()) return false;
				if(stack.pop()!=l_bracket) return false;}
			
		}
		
		return stack.isEmpty();
	}


}
