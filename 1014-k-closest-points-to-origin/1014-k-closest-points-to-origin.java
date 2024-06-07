class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new kClosestComparator());

        int m = points.length;

        for (int i = 0; i < m; i++) {
                int[] coords = { points[i][0], points[i][1] };
                pq.add(coords);
        }


        int[][] toReturn = new int[k][2];

        for (int i = 0; i < k; i++) {
            toReturn[i] = pq.poll();
        }

        return toReturn;
    }

    class kClosestComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            int distA = a[0] * a[0] + a[1] * a[1];
            int distB = b[0] * b[0] + b[1] * b[1];
            return distA - distB;
        }
    }
}