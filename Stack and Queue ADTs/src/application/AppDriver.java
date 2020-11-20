/**
 * 
 */
package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import exceptions.EmptyStackException;
import utilities.*;

/**
 * @author kornk
 *
 */
public class AppDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		MyStack<String> stack = new MyStack<String>();
		MyQueue<String> errorQ = new MyQueue<String>();
		MyQueue<String> extrasQ = new MyQueue<String>();

		String fileName = "res/sample1.xml"; // args[0];

		// Open the file
		File file = new File(fileName);
		Scanner inFile = new Scanner(file);

		// Skip the prolog tag
		inFile.nextLine();
		boolean collectStr = false;
		String tmpLine = "";

		// Read from the file
		while (inFile.hasNext()) {

			tmpLine = "";
			String line = inFile.nextLine().trim();

			for (int i = 0; i < line.length(); i++) {
				char curChar = line.charAt(i);

				if (curChar == '<') {
					// tmpLine += curChar;
					collectStr = true;
				} else if (curChar != '>' && collectStr) {
					tmpLine += curChar;
				} else if (curChar == '>') {
					// tmpLine += curChar;
					collectStr = false;
				}

				// If Self_Closing_Tag
				if (tmpLine != "" && !collectStr) {
					if (isSelfClosingTag(tmpLine)) {
						break;
					} else if (isStartTag(tmpLine)) {
						stack.push(tmpLine.substring(0, tmpLine.indexOf(' ') - 1));
//						stack.push(tmpLine.substring(0, tmpLine.length()));
						break;
					} else if (isClosingTag(tmpLine)) {
						System.out.println("Closing tag" + tmpLine);
						break;
					}
				}

				// If Prolog_Tag
				/*
				 * if (isPrologTag(line)) { // Ignore }
				 */

				// If Self_Closing_Tag

				// If End_Tag
				// If matches top of stack, pop stack and all is well
				// Else if matches head of errorQ, dequeue and ignore
				// Else if stack is empty, add to errorQ
				// Else
				// Search stack for matching Start_Tag

				// If stack has match
				// Pop each E from stack into errorQ until match, report as error
				// Else
				// Add E to extrasQ
			}
			// System.out.print("break");
		}

		// If stack is not empty, pop each E into errorQ
		// If either queue is empty (but not both), report each E in both queues as
		// error
		// If both queues are not empty, peek both queues
		// If they don��t match, dequeue from errorQ and report as error
		// Else dequeue from both
		// Repeat until both queues are empty

		// Add to the stack
//		stack.push("tag");
//
//		// Pop off the stack.
//		try {
//			String tag1 = stack.pop();
//		} catch (EmptyStackException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		// Add to queue
//		errorQ.enqueue("tag");
//
//		// Dequeue
//		String tag2 = errorQ.dequeue();
		System.out.print("break");
		System.out.print("break");
	}

	private static boolean isPrologTag(String line) {
		return false;
		// Check if it's a prolog tag (i.e. <?xml version="1.0" encoding="UTF-8"?>)
	}

	/**
	 * Check if it's self closing (i.e. <tag />)
	 * 
	 * @param chracter
	 * @return
	 */
	private static boolean isSelfClosingTag(String tmpLine) {
//		return tmpLine.charAt(0) == '<' && tmpLine.charAt(1) != '/' && tmpLine.charAt(tmpLine.length() - 2) == '/'
//				&& tmpLine.charAt(tmpLine.length() - 1) == '>';
		return tmpLine.charAt(0) != '/' && tmpLine.charAt(tmpLine.length() - 1) == '/';
	}

	/**
	 * Check if it's a starting tag (i.e. <tag>)
	 * 
	 * @param chracter
	 * @return
	 */
	private static boolean isStartTag(String tmpLine) {
//		return tmpLine.charAt(0) == '<' && tmpLine.charAt(1) != '/' && tmpLine.charAt(tmpLine.length() - 2) != '/'
//				&& tmpLine.charAt(tmpLine.length() - 1) == '>';
		return tmpLine.charAt(0) != '/' && tmpLine.charAt(tmpLine.length() - 1) != '/';
	}

	private static boolean isClosingTag(String tmpLine) {
//		return tmpLine.charAt(0) == '<' && tmpLine.charAt(1) == '/' && tmpLine.charAt(tmpLine.length() - 2) != '/'
//				&& tmpLine.charAt(tmpLine.length() - 1) == '>';
		return tmpLine.charAt(0) == '/' && tmpLine.charAt(tmpLine.length() - 1) != '/';
		// Check if it's a starting tag (i.e. <tag>)
	}

}
