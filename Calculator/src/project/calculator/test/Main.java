package project.calculator.test;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack = new Stack();
		Scanner scan = new Scanner(System.in);
		System.out.print("식을 입력하시오. : ");
		String input = scan.next();
		System.out.println(input);
	}
}