package com.persistent.swapnil.ctrl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class StackOperator {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		ArrayList<String> stack = new ArrayList<String>();

		String command = "";
		while (true) {
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			System.out.println("Which stack operation would you like to perform ?: ");
			System.out.println("Allowed Operations are 1. PUSH, b. POP, c. PEEK, d. QUIT");
			command = br.readLine().replaceAll("\\s+", " ").trim();
			String[] tokens = command.split(" ");
			int length = tokens.length;
			if (length < 1 || length > 2) {
				System.err.println("Not a valid Command");
			}
			String operation = tokens[0].toUpperCase();
			switch (operation) {
			case "PUSH":
				if (length != 2) {
					System.err.println("'" + command + "' is INVALID");
				} else {
					stack.add(tokens[1]);
					System.out.println("Stack Elements : " + stack);
				}
				break;

			case "POP":
				if (length != 1) {
					System.err.println("'" + command + "' is INVALID");
				} else {
					if (stack.size() < 1)
						System.out.println("NOTHING to POP");
					else
						System.out.println("Element '" + stack.remove(stack.size() - 1) + "' is POPPED");

					System.out.println("Stack Elements : " + stack);
				}
				break;

			case "PEEK":
				if (length != 1) {
					System.err.println("'" + command + "' is INVALID");
				} else {
					if (stack.size() < 1)
						System.out.println("NOTHING to PEEK");
					else
						System.out.println("Element '" + stack.get(stack.size() - 1) + "' is PEEKED");
				}
				break;

			case "QUIT":
				System.out.println("Thank You...");
				br.close();
				isr.close();
				return;

			default:
				System.err.println(operation + " is not a valid stack operation");
			}
		}
	}
}
