class Solution {
     public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        ArrayList<int[]> arr = new ArrayList<int[]>();

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] >= intervals[i + 1][0]) {
                intervals[i + 1][0] = Math.min(intervals[i][0], intervals[i + 1][0]);
                intervals[i + 1][1] = Math.max(intervals[i][1], intervals[i + 1][1]);
            } else {
                arr.add(intervals[i]);
            }
        }

        arr.add(intervals[intervals.length - 1]);

        intervals = new int[arr.size()][2];
        for (int i = 0; i < arr.size(); i++) {
            intervals[i] = arr.get(i);
        }

        return intervals;
    }
}