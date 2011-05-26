package practice.algorithm;

public class MergeSort {
	public static <T extends Comparable<T>> void sort(T[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> void sort(T[] arr, int l, int h) {
		if (l >= h)
			return;
		sort(arr, l, (l + h) / 2);
		sort(arr, (l + h) / 2 + 1, h);

		Object[] t = new Object[h - l + 1];
		int i1 = l;
		int i2 = (l + h) / 2 + 1;
		for (int i = 0; i < t.length; i++) {
			if (i2 < arr.length && arr[i1].compareTo(arr[i2]) > 0) {
				t[i] = arr[i2];
				i2++;
			} else {
				t[i] = arr[i1];
				i1++;
			}
		}
		for (int i = 0; i < t.length; i++) {
			arr[i + l] = (T) t[i];
		}
	}

	public static void main(String[] arg) {
		int n = (int) (Math.random() * 10000) + 1;
		Integer[] arr = new Integer[n];
		for (int i = 0; i < n; i++) {
			arr[i] = (int) (Math.random() * (n / 1.2));
		}
		sort(arr);
		for (int i = 1; i < n; i++) {
			assert arr[i - 1] <= arr[i];
		}
		System.out.println(String.format("good, for %d values", n));
	}
}
