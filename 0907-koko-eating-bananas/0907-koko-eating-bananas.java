class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = piles[0];
        for (int pile : piles)
            if (pile > max)
                max = pile;

        int k = 1;
        while (min <= max) {
            int middleSpeed = (min + max) / 2;
            long totalhrs = getTotalHrs(piles, middleSpeed);
            if (totalhrs > h)
                min = middleSpeed + 1;
            else if (totalhrs < h) {
                max = middleSpeed - 1;
                k = middleSpeed;
            } else {
                while (middleSpeed > 1 && getTotalHrs(piles, middleSpeed - 1) == h) {
                    middleSpeed--;
                }
                return middleSpeed;
            }

        }
        return k;
    }

    public long getTotalHrs(int[] piles, long middleSpeed) {
        long totalhrs = 0;
        for (long pile : piles)
            if (pile % middleSpeed == 0)
                totalhrs += (pile / middleSpeed);
            else
                totalhrs += (pile / middleSpeed + 1);

        return totalhrs;
    }
}