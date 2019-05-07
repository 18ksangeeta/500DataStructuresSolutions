/**
 * 
 */
package arrays;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Sangeeta
 *
 */
public class PairSumInArray {

	/**
	 * Given an unsorted array of integers, find a pair with given sum in it.
	 * * Ex: 
	 * Input:
	 * arr = [8, 7, 2, 5, 3, 1], sum = 10
	 * 
	 * Output:
	 * Pair found at index 0 and 2 (8 + 2)
	 * or
	 * Pair found at index 1 and 4 (7 + 3)
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {8,7,3,2,9,1,4};
		int sum = 10;
		
		/*
		 * Approach 1 - O(n log n)
		 * 
		 * */
		Arrays.sort(arr); // 1 2 3 5 7 8 O( n log n)
		int i = 0;
		int j=arr.length-1;
		boolean found = false;
		for(;i<j;) {
			//O(n-1) = O(n)
			if(arr[i]+arr[j]==sum) {
				System.out.println("Found pair : "+arr[i]+"+"+arr[j]+" = "+sum);
				i++;
				j--;
				found = true;
			}
			else if(arr[i]+arr[j]<sum)
				i++;
			else if(arr[i]+arr[j]>sum) {
				j--;
			}				
		}
		if(!found)
			System.out.println("not exists");
		found = false;
		System.out.println("\n\n");
		/*
		 * Approach 2 - O(n)
		 * 
		 * */
		int[] arr2 = {8,7,3,2,9,1,4};
		HashMap<Integer, Integer> hMap = new HashMap<Integer,Integer>();
		for(i = 0;i<arr2.length;i++) {
			if(hMap.containsKey(arr2[i]))
				System.out.println("Found pair : "+arr2[i]+"+"+hMap.get(arr2[i])+" = "+sum);
			else {
				hMap.put(Math.abs(sum-arr2[i]), arr2[i]);
				found = true;
				}
			
		}
	}
}
