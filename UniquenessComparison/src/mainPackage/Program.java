package mainPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Program {
	private static int N; // sets array length . Determined by user input
	private static ArrayList<Integer> list = new ArrayList<Integer>();
	private static int comps; // comparisons counter
	private static int assigns; // assignments counter
	private final static int RANGE = 100; // sets the highest numerical value possible for an element

	public static void main(String[] args) {

		starter(); // request input from user
		randomfill(list); // randomly fill the list
		originalAlg(new ArrayList<Integer>(list)); // committing the task using original algorithm
		ByInsertionSort(new ArrayList<Integer>(list)); // committing the task using insertion sort
		ByMergeSort(new ArrayList<Integer>(list), 0, N - 1); // committing the task using Merge-sort
		ByCountingsort(new ArrayList<Integer>(list));// committing the task using "C array" of Counting-sort
		ByHashTable(new ArrayList<Integer>(list));// committing the task using Hash Table

	}

	private static void ByHashTable(ArrayList<Integer> arr) {
		comps = assigns = 0;
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		int u_size = 0;// determines number of unique elements in input array
		// filling HashMap with array elements as KEYS and occurrences as VALUES
		for (int i = 0; i < N; i++) {
			comps++;
			Integer count = hmap.get(arr.get(i)); // count sets occurrences of element so far in search
			assigns++;

			if (hmap.get(arr.get(i)) == null) { // in case of newly contacted element
				hmap.put(arr.get(i), 1);
				comps++;
				assigns++;
				u_size++;
				assigns++;

			}

			else { // in case element already exists in HashMap
				count++;
				assigns++;
				hmap.put(arr.get(i), count);
				assigns++;
			}
		}
		comps++; // due to last iteration of for loop above
		System.out.println(
				" for N = " + N + " ,ByHashTable comitted " + comps + " comparisons and " + assigns + " assignments");
		/* following message is optional... uncomment to plot */

		// System.out.println(" there are " + u_size + " unique elements in the array");
	}

	private static void ByCountingsort(ArrayList<Integer> arr) {
		comps = assigns = 0;
		int C[] = new int[RANGE + 1]; // "C ARRAY" of counting-sort
		int u_size = 0; // determines number of unique elements in input array
		assigns += 2;

		for (int i = 0; i < RANGE + 1; i++) { // initializing to zeros
			comps++;
			C[i] = 0;
			assigns++;
		}
		comps++; // due to last iteration of for loop above

		for (int i = 0; i < N; i++) {
			comps += 2; // due to conditional in for loop (previous line) and conditional in following
						// if statement
			if (C[arr.get(i)] == 0) { // checking whether element exists in C array
				u_size++; // if not , increment u_size
				assigns++;
			}
			C[arr.get(i)]++;
			assigns++;
		}
		comps++; // due to last iteration of for loop above

		System.out.println(" for N = " + N + " ,ByCountingSort comitted " + comps + " comparisons and " + assigns
				+ " assignments");
		/* following message is optional... uncomment to plot */

		// System.out.println(" there are " + u_size + " unique elements in the array");

	}

	static void ByMergeSort(ArrayList<Integer> arr, int p, int r) {
		if (p == 0 && r == N - 1) {
			comps = assigns = 0;
		}
		if (p < r) {
			comps++;
			// middle point
			int q = p + (r - p) / 2;
			assigns++;

			// Sort halves
			ByMergeSort(arr, p, q);
			ByMergeSort(arr, q + 1, r);

			// Merge sorted halves
			merge(arr, p, q, r);

			if (p == 0 && r == N - 1) { // after final merge occurred
				comps += 2;
				// section of counting unique elements
				int u_size = linearCount(arr); // determines number of unique elements in input array
				assigns++;
				System.out.println(" for N = " + N + " ,ByMergeSort comitted " + comps + " comparisons and " + assigns
						+ " assignments");
				/* following message is optional... uncomment to plot */

				// System.out.println(" there are " + u_size + " unique elements in the array");
			}
		}
	}

	private static void merge(ArrayList<Integer> arr, int p, int q, int r) {
		// sizes of two halves to be merged
		int n1 = q - p + 1;
		int n2 = r - q;
		assigns += 2;
		// temp arrays
		int L[] = new int[n1];
		int R[] = new int[n2];
		assigns += 2;
		// Copy data to temp arrays
		for (int i = 0; i < n1; ++i) {
			comps++;
			L[i] = arr.get(p + i);
			assigns++;
		}
		comps++; // due to last iteration of for loop
		for (int j = 0; j < n2; ++j) {
			comps++;
			R[j] = arr.get(q + 1 + j);
			assigns++;
		}
		comps++; // due to last iteration of for loop

		// Merge temp arrays

		// indexes of first and second temp arrays
		int i = 0, j = 0;

		int k = p; // index of original input array
		assigns += 3;
		while (i < n1 && j < n2) {
			comps++;

			if (L[i] <= R[j]) {
				comps++;
				arr.set(k, L[i]);
				i++;
				assigns += 2;
			} else {
				comps++;
				arr.set(k, R[j]);
				j++;
				assigns += 2;
			}
			k++;
			assigns++;
		}
		comps++; // due to last iteration of while loop

		// Copy remaining elements of L[]
		while (i < n1) {
			comps++;
			arr.set(k, L[i]);
			i++;
			k++;
			assigns += 3;
		}
		comps++; // due to last iteration of while loop

		// Copy remaining elements of R[]
		while (j < n2) {
			comps++;
			arr.set(k, R[j]);
			j++;
			k++;
			assigns += 3;
		}
		comps++; // due to last iteration of while loop

	}

	// Implementation of task using insertion-sort
	private static void ByInsertionSort(ArrayList<Integer> arr) {
		comps = assigns = 0;

		for (int i = 1; i < N; ++i) {
			comps++;
			int key = arr.get(i);
			assigns++;
			int j = i - 1;
			assigns++;
			while (j >= 0 && arr.get(j) > key) {
				comps += 2; // due to dual boolean checks in conditional above
				arr.set(j + 1, arr.get(j));
				assigns++;
				j--;
				assigns++;

			}
			comps++; // due to last iteration of while loop
			arr.set(j + 1, key);
			assigns++;
		}
		comps++; // due to last iteration of for loop

		// section of counting unique elements
		int u_size = linearCount(arr); // determines number of unique elements in input array

		System.out.println(" for N = " + N + " ,ByInsertionSort comitted " + comps + " comparisons and " + assigns
				+ " assignments");

		/* following message is optional... uncomment to plot */

		// System.out.println(" there are " + u_size + " unique elements in the array");

	}

	// this is the original algorithm from exercise 1
	public static void originalAlg(ArrayList<Integer> arr) {
		comps = assigns = 0;

		int u_size = 1;
		assigns++;
		for (int i = 1; i < arr.size(); i++) {
			comps++;
			boolean u = true;
			assigns++;
			int j = 0;
			assigns++;
			while (j < u_size) {
				comps++;
				if (arr.get(j) == arr.get(i)) {
					comps++;
					u = false;
					assigns++;
					j = u_size;
					assigns++;
				} else {
					comps++;
					j++;
					assigns++;
				}
			}
			comps++; // due to last iteration of while loop
			comps++;
			if (u) {
				u_size++;
				assigns++;
				arr.set(u_size - 1, arr.get(i));
				assigns++;
			}

		}
		comps++; // due to last iteration of for loop

		System.out.println(" for N = " + N + " ,original Algorithm comitted " + comps + " comparisons and " + assigns
				+ " assignments");
		/* following message is optional... uncomment to plot */

		// System.out.println(" there are " + u_size + " unique elements in the array");
	}

	/*
	 * 
	 * 
	 * ---- AUXILLARY METHODS -----
	 * 
	 */

	// this method starts interaction with the user ( requests input and processes
	// it)
	private static void starter() {
		Scanner scan = new Scanner(System.in);

		N = -1;// initial default value

		// positive integer validation
		while (N < 1) {

			System.out.println("please insert an integer greater than zero");
			String input = scan.nextLine();

			try {
				N = Integer.valueOf(input);
			} catch (NumberFormatException e) {
				N = -1;
			}
		} // --- end of validation

	}

	// this method fills the array randomly with N (determined by user) integers in
	// range (1 - 100)
	private static void randomfill(ArrayList<Integer> array) {
		Random rand = new Random();
		for (int i = 0; i < N; i++) {
			array.add(rand.nextInt(RANGE) + 1);
		}
	}

	// this method counts the number of unique elements in a SORTED ARRAY
	private static int linearCount(ArrayList<Integer> array) {

		int u_size = 1;
		assigns++;
		for (int i = 1; i < N; i++) {
			comps += 2; // generated by for loop conditional + if conditional
			if (array.get(i) != array.get(i - 1)) {
				u_size++;
				assigns++;
			}
		}
		comps++; // due to last iteration of for loop

		return u_size;
	}

}
