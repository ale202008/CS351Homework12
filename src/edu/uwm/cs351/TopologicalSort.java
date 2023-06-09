package edu.uwm.cs351;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

/**
 * Schedule a collection tasks so that each task is scheduled
 * after anything that it depends on.
 */
public class TopologicalSort {
	private Schedule schedule;
	private Path cycle;
	
	/**
	 * Perform a topological sort of the given tasks.
	 * If a cycle is found, scheduled is terminated early,
	 * and a cycle is set.
	 * @param tasks (non-null) list of tasks to schedule, none of which may be null
	 */
	public TopologicalSort(Set<Task> tasks) {
		// TODO
		schedule = new Schedule();
		Set<Task> visited = new HashSet<Task>();
		
		for (Task i : tasks) {
			Path hey = TSortHelper(i, visited, tasks);
			if (hey != null && hey.isCycle()) {
				cycle = hey;
			}
		}
		
	}
	
	// TODO: space for a (temporary) recursive helper method,
	// but you will have to stop using it (see homework description).
	private Path TSortHelper(Task v, Set<Task> visited, Set<Task> tasks) {
		
		if (!visited.contains(v)) {
			visited.add(v);
			for (Task t: v.getDependencies()) {
				if (tasks.contains(t)) {
					Path problem = TSortHelper(t, visited, tasks);
					if (problem != null && problem.isCycle()) {
						return problem;
					}
					else if (problem != null) {
						return problem.append(v);
					}
				}
			}
			schedule.append(v);
		}
		else if (!schedule.contains(v)){
			Path temp = new DegeneratePath(v);
			return temp;
		}
		
		return null;
	}
	
	/**
	 * Return the schedule of tasks found.
	 * If there are no cycles, this schedule will include all tasks.
	 * @return schedule, never null
	 */
	public Schedule getSchedule() {
		return schedule;
	}
	
	/**
	 * Return the cycle found while scheduling tasks.
	 * If no cycle was found, return null.
	 * The path returned will always be a cycle.
	 * @return cycle found, or null
	 */
	public Path getCycle() {
		return cycle;
	}
}
