package cs240;

public interface ListInterface<T> {
	/**
	 * Adds an item to the list.
	 * @param item: an object to be added
	 */
	public void add(T item);
	
	/**
	 * Adds an item to a particular location, pushing everything else down
	 * @param item: an object to be added
	 * @param index: the location in the list to put them
	 */
	public void add(T item, int index);
	
	/**
	 * Removes an item from the list.
	 * @param index: the location of the item to be removed
	 * @return The item that was removed
	 */
	public T remove(int index);
	
	/**
	 * Completely clears the list.
	 */
	public void removeAll();
	
	/**
	 * Replaces an item in the list with another item.
	 * @param item: the item to insert
	 * @param index: the location of the item being removed
	 * @return The item that was replaced.
	 */
	public T replace(T item, int index);
	
	/**
	 * Returns a reference to an item
	 * @param index: the location of the item being looked at
	 * @return The item at the index location
	 */
	public T look(int index);
	
	/**
	 * Prints all items in the list
	 * @return all the items
	 */
	public void lookAll();
	
	/**
	 * Checks if an item exists on the list
	 * @param item: the item being searched for.
	 * @return True if the item is in the list
	 */
	public boolean check(T item);
	
	/**
	 * 
	 * @return The length of the list
	 */
	public int length();
	
	/**
	 * 
	 * @return True if the list is empty.
	 */
	public boolean isEmpty();
}
