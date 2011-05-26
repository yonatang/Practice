package practice.algorithm;


public class QuickSort {

	static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
		T t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	static <T extends Comparable<T>> void sort(T[] arr, int low, int hight) {
		T pivot = arr[low];

		int i = low, j = hight;

		while (i <= j) {
			while (arr[i].compareTo(pivot) < 0) {
				i++;
			}
			while (arr[j].compareTo(pivot) > 0) {
				j--;
			}
			if (i <= j) {
				swap(arr, i, j);
				i++;
				j--;
			}
		}
		if (low < j) {
			sort(arr, low, j);
		}
		if (i < hight) {
			sort(arr, i, hight);
		}
	}

	public static <T extends Comparable<T>> void sort(T[] arr) {
		sort(arr, 0, arr.length - 1);
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
