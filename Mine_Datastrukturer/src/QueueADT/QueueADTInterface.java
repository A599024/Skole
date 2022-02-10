package QueueADT;

public interface QueueADTInterface<T> {
	
	/**
	 * Inserts a element in the back of the queue.
	 * 
	 * @param el	A element to add.
	 */
	public void inQueue(T el);
	
	/**
	 *	Gets the element that stands first in the queue,
	 *	the element that was added first.
	 *
	 * @return	The element that stands first in the Queue.
	 */
	public T first();
	
	/**
	 * removes the element 
	 * 
	 * return	The removed element.
	 */
	public T outQueue();
	
	/**
	 * Returns true if the queue is empty.
	 * 
	 * @return	true if empty, else false.
	 */
	public boolean isEmpty();
	
//	/**
//	 * Inserts a element in the queue where 
//	 * queuePlace represents the place in the queue
//	 * 
//	 * @param el, queuePlace	El -> The element to be removed
//	 * 							queuePlace -> place in the queue
//	 */
//	public void insert(T el, int queuePlace);

}
