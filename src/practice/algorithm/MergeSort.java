package practice.algorithm;

import java.util.Arrays;

public class MergeSort {
	public static void sort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	public static void sort(int[] arr, int l, int h) {
		if (l >= h)
			return;
		sort(arr, l, (l + h) / 2);
		sort(arr, (l + h) / 2 + 1, h);

		int[] t = new int[h - l + 1];
		int i1 = l;
		int i2 = (l + h) / 2 + 1;
		for (int i = 0; i < t.length; i++) {
			if (i2 < arr.length && arr[i1] > arr[i2]) {
				t[i] = arr[i2];
				i2++;
			} else {
				t[i] = arr[i1];
				i1++;
			}
		}
		for (int i = 0; i < t.length; i++) {
			arr[i + l] = t[i];
		}
	}

	public static void main(String[] arg) {
		int[] t = { 5, 3, 5, 2, 4, 1 };
		sort(t);
		System.out.println(Arrays.toString(t));
	}
}
