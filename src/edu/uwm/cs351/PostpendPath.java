package edu.uwm.cs351;

import java.util.Stack;

import edu.uwm.cs351.Path.Work;

/**
 * A path created by adding a new task to the end of an existing path.
 */
public class PostpendPath extends Path {
	private final Path most;
	private final Task task;
	private final Task start;
	private final int size;
	
	/**
	 * Create a path from a path and a task to put at the end
	 * @param p path to add to
	 * @param t task to add
	 */
	public PostpendPath(Path p, Task t) {
		if (t == null) throw new NullPointerException("task cannot be null");
		if (!t.getDependencies().contains(p.getLast())) {
			throw new IllegalArgumentException("path is not connected to task");
		}
		task = t;
		most = p;
		start = most.getFirst();
		size = p.size()+1;
	}

	@Override // required
	public int size() {
		return size;
	}

	@Override // required
	public Task getFirst() {
		return start;
	}

	@Override // required
	public Task getLast() {
		return task;
	}

	@Override // required
	protected void toArrayHelper(Stack<Work> worklist, Task[] array, int index) {
		array[index+size-1] = task;
		worklist.push(new Work(most,index));
	}
	
	// TODO override helpers for contains and get
	protected boolean containsHelper(Stack<Work> worklist, Task query) {
		if (query == task) {
			return true;
		}
		worklist.push(new Work(most, 0));
		return false;
	}

}
