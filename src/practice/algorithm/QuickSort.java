package practice.algorithm;

import java.util.Arrays;

public class QuickSort<T extends Comparable<T>> {

	static <T extends Comparable<T>> int part(T[] arr, int l, int h, int p) {
		T pv = arr[p];
		while (true) {
			System.out.println(arr[l].compareTo(pv));
			while (arr[l].compareTo(pv) < 0)
				l++;
			System.out.println(arr[h].compareTo(pv));
			while (arr[h].compareTo(pv) >= 0)
				h--;

			if (l < h) {
				T t = arr[l];
				arr[l] = arr[h];
				arr[h] = t;
			} else {
				return h;
			}
		}
	}

	static <T extends Comparable<T>> void sort(T[] arr, int l, int h) {
		int p = part(arr, l, h, l);
		sort(arr, l, p);
		sort(arr, p + 1, h);
	}

	public static <T extends Comparable<T>> void sort(T[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	public static void main(String[] arg) {
		Integer[] t = { 5, 3, 5, 2, 4, 1 };
		sort(t);
		System.out.println(Arrays.toString(t));
	}
}
