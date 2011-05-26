package practice.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KSelect {
	public static <T extends Comparable<T>> T select(T[] arr, int k) {
		return select(arr, k, 0, arr.length - 1);
	}

	static <T extends Comparable<T>> void swap(T[] arr, int l, int h) {
		T t = arr[l];
		arr[l] = arr[h];
		arr[h] = t;
	}

	public static <T extends Comparable<T>> T select(T[] arr, int k, int l,
			int h) {
		if (l == h)
			return arr[l];
		T pv = arr[l];
		int li = l;
		int hi = h;
		while (li <= hi) {
			while (arr[li].compareTo(pv) < 0)
				li++;
			while (arr[hi].compareTo(pv) > 0)
				hi--;
			if (li <= hi) {
				swap(arr, li++, hi--);
			}
		}
		int p;
		if (hi > l)
			p = hi;
		else
			p = li - 1;
		if (p >= k) {
			return select(arr, k, l, p);
		} else {
			return select(arr, k, p + 1, h);
		}
	}

	public static void main(String[] arg) {
		int n = (int) (Math.random() * 10000);
		Integer[] arr = new Integer[n];
		List<Integer> check = new ArrayList<Integer>(n);
		for (int i = 0; i < n; i++) {
			arr[i] = (int) (Math.random() * (n / 1.2));
			check.add(arr[i]);
		}
		Collections.sort(check);

		for (int i = 0; i < n; i++) {
			assert select(arr, n) == check.get(n);
		}
		System.out.println(String.format("good, for %d values", n));

	}
}
