import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Edge case: if there's 1 or 0 intervals, no merging is needed
        if (intervals.length <= 1) {
            return intervals;
        }

        // 1. Sort intervals based on their start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Use a linked list to easily look at the last added interval
        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] interval : intervals) {
            // 2. If the list is empty or current interval doesn't overlap with the last merged one,
            // simply add it to the list.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } 
            // 3. Otherwise, there is an overlap, so merge the current interval into the last one.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        // Convert the list back to a 2D array
        return merged.toArray(new int[merged.size()][]);
    }
}
