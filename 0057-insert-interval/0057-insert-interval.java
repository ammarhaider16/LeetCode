class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayList<int[]> arr = new ArrayList<int[]>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            arr.add(intervals[i]);
            i++;
        }

        while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        arr.add(newInterval);

        while (i < intervals.length) {
            arr.add(intervals[i]);
            i++;
        }

        intervals = new int[arr.size()][2];
        for (int j = 0; j < arr.size(); j++)
            intervals[j] = arr.get(j);

        return intervals;

    }
}