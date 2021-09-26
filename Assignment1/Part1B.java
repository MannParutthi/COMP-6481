// -----------------------------------------------------
// Assignment 1 - Question 2
// © Manan Paruthi
// Written by: Manan Paruthi (Concordia University Student ID: 40192620) 
// -----------------------------------------------------

package Assignment1;

import java.util.Scanner;

public class Part1B {
	
	public static void PrintFormattedStringAndHighestOccurringChar(String str) {
		String tempStr = "";
		char highestOccurringChar = str.charAt(0);
		int highestOccurringCharCount = 0;
		
		char currentChar = str.charAt(0);
		int currentCharCount = 1;
		for(int i=1; i<str.length(); i++) {
			if(str.charAt(i) == currentChar) {
				currentCharCount++;
			}
			else {
				//adding current char to the result
				tempStr += Character.toString(currentChar);
				if(currentCharCount > 1) {
					tempStr += Integer.toString(currentCharCount);
				}
				
				//finding highest occurring character count and the character
				if(currentCharCount > highestOccurringCharCount) {
					highestOccurringCharCount = currentCharCount;
					highestOccurringChar = currentChar;
				}
				
				//reset count for new char
				currentChar = str.charAt(i);
				currentCharCount = 1;
			}
			
			// if last element then add to result
			if(i == str.length()-1) {
				tempStr += Character.toString(currentChar);
				if(currentCharCount > 1) {
					tempStr += Integer.toString(currentCharCount);
				}
			}
		}
		
		System.out.println(tempStr);
		System.out.println("Highest occurring character is " + Character.toString(highestOccurringChar) + 
				" with frequency " + Integer.toString(highestOccurringCharCount));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String userInput = sc.next();
		PrintFormattedStringAndHighestOccurringChar(userInput);
		sc.close();
	}

}
// Input : gggN@@@@@KKeeeejjjjjdsmmu