package com.ds.sort;

public class BinarySearchInDuplicate {

	// exactly similir to BST just the if loop addition in the match case.
	private static int binarySearchDuplicate(int[] a, int key, boolean searchFirst) {
		int lo = 0;
		int hi = a.length - 1;
		int result = 0;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (a[mid] == key) {
				result = mid;
				if (searchFirst) {
					// if you want to search the first occurrence then go to the first half.
					hi = mid - 1;
				} else {
					// if you want to search the last occurrence then go the the second half.
					lo = mid + 1;
				}
			} else if (a[mid] < key) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}

		}
		return result;
	}

	public static void main(String[] args) {
		int[] a = { 1, 1, 3, 3, 5, 5, 5, 5, 9, 9, 11 };
		int key = 9;

		// search the first index of duplicate --> pass true
		int firstOccurence = binarySearchDuplicate(a, key, true);
		System.out.println(firstOccurence);

		// search the first index of duplicate --> pass false
		int lastOccurence = binarySearchDuplicate(a, key, false);
		System.out.println(lastOccurence);

		// Total number of duplicates for the key would be
		System.out.println(lastOccurence - firstOccurence + 1);
	}
}
