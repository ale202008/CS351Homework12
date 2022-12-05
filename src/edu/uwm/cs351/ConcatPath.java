package edu.uwm.cs351;

import java.util.Set;
import java.util.Stack;

import edu.uwm.cs351.Path.Work;

/*
 * Andrew Le
 * Homework 12, COMPSCI 351
 */

/**
 * A path built up by concatenating two paths.
 * It doesn't add any edges.  The lengths are added, but the size of the result is
 * one less that the size of the two parts.
 */
public class ConcatPath extends Path {
	// TODO: Data Structure (no wellFormed needed)
	// Remember: all fields should be final
	private final Path leftPath;
	private final Path rightPath;
	private final Task first;
	private final Task last;
	private final int size;
	
	/**
	 * Connect two paths
	 * @param p1 non-degenerate path that ends in one task
	 * @param p2 non-degenerate path start starts with that same task
	 */
	public ConcatPath(Path p1, Path p2) {
		// TODO
		if (p1.getLast() != p2.getFirst()) throw new IllegalArgumentException();
		if (p1 == null || p2 == null) throw new NullPointerException();
		if (p1.size() < 2|| p2.size() < 2) throw new IllegalArgumentException();
		
		first = p1.getFirst();
		last = p2.getLast();
		leftPath = p1;
		rightPath = p2;
		
		size = p1.size() + p2.size() - 1;


	}
	
	@Override // required
	public int size() {
		return size; // TODO
	}

	@Override // required
	public Task getFirst() {
		return first; // TODO
	}

	@Override // required
	public Task getLast() {
		return last; // TODO
	}

	@Override // required
	protected void toArrayHelper(Stack<Work> worklist, Task[] array, int index) {
		// TODO
		worklist.push(new Work(leftPath, index));
		worklist.push(new Work(rightPath, size-leftPath.size()));
	}

	// TODO: other helper methods
	
	protected boolean containsHelper(Stack<Work> worklist, Task query) {
		if (query == first || query == last) {
			return true;
		}
		worklist.push(new Work(leftPath, 0));
		worklist.push(new Work(rightPath, 0));
		return false;
	}
	
	protected Task getHelper(Stack<Work> worklist, int index) {
		worklist.push(new Work(leftPath, 0));
		worklist.push(new Work(rightPath, size-leftPath.size()));
		return null;
	}
}
