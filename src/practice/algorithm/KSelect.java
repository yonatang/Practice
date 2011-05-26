package practice.algorithm;

import java.util.Arrays;

public class KSelect<T extends Comparable<T>> {
	public static int select(int[] arr, int k) {
		return select(arr, k, 0, arr.length - 1);
	}

	static void swap(int[] arr, int l, int h) {
		int t = arr[l];
		arr[l] = arr[h];
		arr[h] = t;
	}

	public static int select(int[] arr, int k, int l, int h) {
		if (l >= h)
			return arr[l];
		int pv = arr[l];
		int li = l;
		int hi = h;
		while (li < hi) {
			if (arr[li] >= pv) {
				swap(arr, li, hi);
				hi--;
			} else {
				li++;
			}
		}
		if (li >= k) {
			return select(arr, k, l, li);
		} else {
			return select(arr, k, hi, h);
		}
	}

	public static void main(String[] arg) {
		int[] arr = { 6, 4, 5, 2, 3, 1, 7 };
		System.out.println(select(arr, 2));
		System.out.println(Arrays.toString(arr));
	}
}
