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
 * This application is parsing XML files with my own ADTs for a stack and a queue.
 * 
 * 
 * @author Jaeyoung Kim
 * @version 1.0, November 20, 2020
 *
 */
public class AppDriver {

	/**
	 * @param args the xml file
	 * @throws IOException IOException
	 */
	public static void main(String[] args) throws IOException {
		MyStack<String> stack = new MyStack<String>();
		MyQueue<String> errorQ = new MyQueue<String>();
		MyQueue<String> extrasQ = new MyQueue<String>();

		String fileName = args[0];

		int lineNumber = 1;
		boolean noError = true;
		
		// Open the file
		File file = new File(fileName);
		Scanner inFile = new Scanner(file);

		// Skip the prolog tag
		inFile.nextLine();
		boolean collectStr = false;
		String tmpLine = "";

		// Read from the file
		while (inFile.hasNext()) {
			lineNumber++;
			tmpLine = "";
			String line = inFile.nextLine().trim();

			for (int i = 0; i < line.length(); i++) {

				char curChar = line.charAt(i);

				if (curChar == '<' && !collectStr) { // begging sign: <
					collectStr = true;
				} else if (curChar != '>' && collectStr) { // continuing to collect characters
					tmpLine += curChar;
				} else if (curChar == '>' && collectStr) { // ending sign: >
					collectStr = false;
				} else if (curChar == '<' && collectStr) { // error: begging sign while collecting characters
					System.out.println("Error: Unexpected < (Line #" + lineNumber + ")");
				} else if (curChar == '>' && !collectStr) { // error: ending sign while no collecting character
					System.out.println("Error: Unexpected > (Line #" + lineNumber + ")");
				}

				// once a tag is completed.
				if (tmpLine != "" && !collectStr) {
					if (isSelfClosingTag(tmpLine)) { // self closing tag: <tag />
						tmpLine = ""; // reset tmpLine once a tag is complete for the next character or line
					} else if (isStartTag(tmpLine)) { // start tag: <tag>
						String tmpLineSplit[] = tmpLine.split(" ", 2); // split tag and parameters
						stack.push(tmpLineSplit[0]); // push tag only to stack
						tmpLine = ""; // reset tmpLine once a tag is complete for the next character or line
					} else if (isClosingTag(tmpLine)) { // closing tag: </tag>
						try {
							String tagOpen = stack.peek();
							String tagClose = tmpLine.substring(1, tmpLine.length());
							if (tagOpen.equals(tagClose)) { // If matches top of stack, pop stack and all is well
								stack.pop();
								// System.out.println(tmpLine + " tag matches. (Line #" + lineNumber + ")");
							} else if (tagClose.equals(errorQ.peek())) { // Else if matches head of errorQ, dequeue and
																			// ignore
								errorQ.dequeue();
							} else if (stack.isEmpty()) { // Else if stack is empty, add to errorQ								
								errorQ.enqueue(tmpLine);
								noError = false;
							} else {
								int search = stack.search(tagClose); // Search stack for matching Start_Tag
								if (search > 0) { // If stack has match
									for (int j = 0; j < stack.size() - search; j++) { // Pop each E from stack into
																						// errorQ until match
										tagOpen = stack.peek();
										errorQ.enqueue(stack.pop());
										System.out.println("Error: The " + tagOpen + " tag wasn't closed before the "
												+ tagClose + " tag (Line #" + lineNumber + ")");
									}
									tagOpen = stack.pop(); // pop the correct opening tag after removing error tags.
								} else { // element NOT found.
									extrasQ.enqueue(tmpLine);
								}
								noError = false;
							}
							tmpLine = ""; // reset tmpLine once a tag is complete for the next character or line
						} catch (EmptyStackException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}

		// If stack is not empty, pop each E into errorQ
		while (!stack.isEmpty()) {
			try {
				errorQ.enqueue(stack.pop());
			} catch (EmptyStackException e) {
				e.printStackTrace();
			}
		}

		// Repeat until both queues are empty
		while (!errorQ.isEmpty() && !extrasQ.isEmpty()) {
			String errorTag;
			
			// If both queues are not empty, peek both queues
			// If they don��t match, dequeue from errorQ and report as error
			// Else dequeue from both
			if (!errorQ.peek().equals(extrasQ.peek())) {
				errorTag = (String) errorQ.dequeue();
				System.out.println("Error: The " + errorTag + " tag does not have a match");
			} else {
				errorQ.dequeue();
				extrasQ.dequeue();
			}
		}

		// Repeat until both queues are empty
		while (!(errorQ.isEmpty() && extrasQ.isEmpty())) {
			String errorTag;
			// If either queue is empty (but not both), report each E in both queues as
			// error
			if ((errorQ.isEmpty() || extrasQ.isEmpty()) && !(errorQ.isEmpty() && extrasQ.isEmpty())) {
				if (!errorQ.isEmpty()) {
					errorTag = (String) errorQ.dequeue();
					System.out.println(
							"Error: The " + errorTag + " tag does not have a match");
				} else {
					errorTag = (String) extrasQ.dequeue();
					System.out.println(
							"Error: The " + errorTag + " tag does not have a match");
				}
			}
		}
		
		if (noError) {
			System.out.println("The XML is valid. No error found!");
		}
	}

	/**
	 * Check if it's a self closing tag
	 * 
	 * @param tmpLine the tag to be checked
	 * @return return true if tag is a self closing tag
	 */
	private static boolean isSelfClosingTag(String tmpLine) {
		return tmpLine.charAt(0) != '/' && tmpLine.charAt(tmpLine.length() - 1) == '/';
	}

	/**
	 * Check if it's a starting tag
	 * 
	 * @param tmpLine the tag to be checked
	 * @return return true if tag is a starting tag
	 */
	private static boolean isStartTag(String tmpLine) {
		return tmpLine.charAt(0) != '/' && tmpLine.charAt(tmpLine.length() - 1) != '/';
	}

	/**
	 * Check if it's a closing tag
	 * 
	 * @param tmpLine the tag to be checked
	 * @return return true if tag is a closing tag
	 */
	private static boolean isClosingTag(String tmpLine) {
		return tmpLine.charAt(0) == '/' && tmpLine.charAt(tmpLine.length() - 1) != '/';
	}

}
