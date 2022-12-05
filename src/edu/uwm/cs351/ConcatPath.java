package edu.uwm.cs351;

import java.util.Stack;

/**
 * A path built up by concatenating two paths.
 * It doesn't add any edges.  The lengths are added, but the size of the result is
 * one less that the size of the two parts.
 */
public class ConcatPath extends Path {
	// TODO: Data Structure (no wellFormed needed)
	// Remember: all fields should be final
	
	/**
	 * Connect two paths
	 * @param p1 non-degenerate path that ends in one task
	 * @param p2 non-degenerate path start starts with that same task
	 */
	public ConcatPath(Path p1, Path p2) {
		// TODO
	}
	
	@Override // required
	public int size() {
		return 0; // TODO
	}

	@Override // required
	public Task getFirst() {
		return null; // TODO
	}

	@Override // required
	public Task getLast() {
		return null; // TODO
	}

	@Override // required
	protected void toArrayHelper(Stack<Work> worklist, Task[] array, int index) {
		// TODO
	}

	// TODO: other helper methods
}
