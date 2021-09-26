// -----------------------------------------------------
// Assignment 1 - Question 3
// © Manan Paruthi
// Written by: Manan Paruthi (Concordia University Student ID: 40192620) 
// -----------------------------------------------------

package Assignment1;

import java.util.Scanner;

public class Part1C {
	
	public static void FindTwoConsEleWithSmallestAndBiggestDiff(int[] arr) {
		
		int smallestDiff = 99999;
		int firstIndexOfSmallestDiff = 0;
		int secondIndexOfSmallestDiff = 0;
		
		int largestDiff = 0;
		int firstIndexOfLargestDiff = 0;
		int secondIndexOfLargestDiff = 0;
		
		for(int i=0; i<arr.length-1; i++) {
			int diffBtwTwoConsEle = Math.abs(arr[i] - arr[i+1]);
			
			if(diffBtwTwoConsEle <= smallestDiff) {
				smallestDiff = diffBtwTwoConsEle;
				firstIndexOfSmallestDiff = i;
				secondIndexOfSmallestDiff = i+1;				
			}
			if(diffBtwTwoConsEle >= largestDiff) {
				largestDiff = diffBtwTwoConsEle;
				firstIndexOfLargestDiff = i;
				secondIndexOfLargestDiff = i+1;				
			}
		}
		
		System.out.println("The two conductive indices with smallest difference between their values are: index " + firstIndexOfSmallestDiff +
				" and index " + secondIndexOfSmallestDiff + ", storing values " + arr[firstIndexOfSmallestDiff] + " and " + arr[secondIndexOfSmallestDiff]);
		
		System.out.println("The two conductive indices with largest difference between their values are: index " + firstIndexOfLargestDiff +
				" and index " + secondIndexOfLargestDiff + ", storing values " + arr[firstIndexOfLargestDiff] + " and " + arr[secondIndexOfLargestDiff]);
	}
	
	public static int[] GetSpaceSeparatedArrayAsInput() {
		Scanner sc = new Scanner(System.in);
		int sizeOfArr = sc.nextInt();
		int[] arr = new int[sizeOfArr];
		
		sc.nextLine();
		String[] temp = sc.nextLine().split(" ");
		
		for(int i=0; i<sizeOfArr; i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}
		
		sc.close();
		
		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = GetSpaceSeparatedArrayAsInput();
		FindTwoConsEleWithSmallestAndBiggestDiff(arr);
	}

}
//Input : 13       20 52 400 3 30 70 72 47 28 38 41 53 20