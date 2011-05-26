package practice.datastructre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class ArrayHeap<T extends Comparable<T>> implements Heap<T> {

	private ArrayList<T> arr = new ArrayList<T>();

	void swap(int i, int j) {
		T t = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, t);

	}

	int leftIdx(int i) {
		return i * 2 + 1;
	}

	int rightIdx(int i) {
		return i * 2 + 2;
	}

	T left(int i) {
		int li = leftIdx(i);
		return (arr.size() > li) ? arr.get(li) : null;
	}

	T right(int i) {
		int ri = rightIdx(i);
		return (arr.size() > ri) ? arr.get(ri) : null;
	}

	void heapify(int i) {
		T iv = arr.get(i);
		T rv = right(i);
		T lv = left(i);

		if (rv == null && lv == null)
			return;
		if (rv == null || (lv != null && lv.compareTo(rv) > 0)) {
			if (lv.compareTo(iv) > 0) {
				swap(leftIdx(i), i);
				heapify(leftIdx(i));
			}
		} else {
			if (rv.compareTo(iv) > 0) {
				swap(rightIdx(i), i);
				heapify(rightIdx(i));
			}
		}
	}

	public ArrayHeap() {
	}

	public ArrayHeap(Collection<T> c) {
		arr.addAll(c);
		for (int i = arr.size() / 2; i >= 0; i--) {
			heapify(i);
		}
	}

	/* (non-Javadoc)
	 * @see practice.datastructre.Heap#add(T)
	 */
	@Override
	public void add(T o) {
		arr.add(0, o);
		heapify(0);
	}

	/* (non-Javadoc)
	 * @see practice.datastructre.Heap#peekMax()
	 */
	@Override
	public T peekMax() {
		return arr.get(0);
	}

	/* (non-Javadoc)
	 * @see practice.datastructre.Heap#popMax()
	 */
	@Override
	public T popMax() {
		T m = peekMax();
		arr.set(0, arr.remove(arr.size() - 1));

		heapify(0);
		return m;
	}

	/* (non-Javadoc)
	 * @see practice.datastructre.Heap#addAll(java.util.Collection)
	 */
	@Override
	public void addAll(Collection<T> os) {
		for (T o : os) {
			add(o);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int line = 1;
		for (int i = 0; i < arr.size(); i++) {
			sb.append(arr.get(i)).append(" ");
			if (Math.pow(2, line) == (i + 2)) {
				sb.append("\n");
				line++;
			}
		}
		return sb.toString();
	}

	public static void main(String[] arg) {

		Heap<Integer> h = new ArrayHeap<Integer>(
				Arrays.asList(new Integer[] { 5, 6, 7, 2, 3, 9 }));

		System.out.println(h.toString());
		h.popMax();
		System.out.println(h.toString());
		h.popMax();
		System.out.println(h.toString());
		h.add(15);
		System.out.println(h.toString());
		h.add(1);
		System.out.println(h.toString());

	}
}
