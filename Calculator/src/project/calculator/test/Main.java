package project.calculator.test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack = new Stack();
		Scanner scan = new Scanner(System.in);

		System.out.print("식을 입력하시오. : "); //식을 입력할 때 숫자와 연사자를 ' '로 구분한다.

		String input = scan.nextLine();
		System.out.println(input);

		String[] expression = input.split(" ");

		String post = "";
		
		//피연산자를 만나면 그대로 출력한다.
		//연산자를 만났을 때 스택이 비어있다면 스택에 push한다.
		//연산자를 만났을 때 스택이 비어있지 않다면 게속 pop한다.
		//(다만 최상위 연산자(stack.peek())가 현재 연산자인 s연산자보다 우선순위가 낮은 연산자라면 s를 push한다.
		for (String s : expression) {
			
			switch(s) {
			case "+":
			case "-":
				if(stack.isEmpty()) {
					stack.push(s);
					break;
				}
				while(!stack.isEmpty()) 
					post += stack.pop() + " ";
				stack.push(s);
				break;
				
			case "*":
			case "/":
				if (stack.isEmpty()) {
					stack.push(s);
					break;
				}
				String operator = (String)stack.peek();
				if (operator == "*" || operator == "/" ) {
					while(!stack.isEmpty()) 
						post += stack.pop() + " ";
				}
				else {
					stack.push(s);
					break;
				}
				
			default:
				post += s + " ";

			}
		}
		while(!stack.isEmpty()) {
			post += stack.pop() + " ";
		}

		System.out.println(post);
	}
}