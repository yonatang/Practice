package practice.datastructre;

import java.util.Collection;

public interface Heap<T extends Comparable<T>> {

	public abstract void add(T o);

	public abstract T peekMax();

	public abstract T popMax();

	public abstract void addAll(Collection<T> os);

}