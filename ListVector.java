/**
 * an implementation of ADT List using vectors
 * Angel Jauregui
 * February 15, 2017
 */
package cs240;

import java.util.Vector;

public class ListVector<T> implements ListInterface {

	private Vector list;

	public ListVector(){
		list = new Vector();
	}
	
	@Override
	public void add(Object item) {
		list.add(item);
	}

	@Override
	public void add(Object item, int index) {
		list.add(index, item);
	}

	@Override
	public Object remove(int index) {
		return list.remove(index);
	}

	@Override
	public void removeAll() {
		list = new Vector();
	}

	@Override
	public T replace(Object item, int index) {
		T result = (T) list.get(index);
		list.add(index, item);
		return result;
	}

	@Override
	public Object look(int index) {
		return list.get(index);
	}

	@Override
	public void lookAll() {
		for(int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
	}

	@Override
	public boolean check(Object item) {
		return list.contains(item);
	}

	@Override
	public int length() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}
}
