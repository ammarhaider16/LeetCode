class Solution {
    public static int trap(int[] height) {
        int len = height.length;

        int[] maxL = new int[len];
        int currMaxL = 0;
        for (int i = 0; i < len; i++) {
            maxL[i] = currMaxL;
            currMaxL = Math.max(currMaxL, height[i]);
        }

        int[] maxR = new int[len];
        int currMaxR = 0;
        for (int i = len - 1; i >= 0; i--) {
            maxR[i] = currMaxR;
            currMaxR = Math.max(currMaxR, height[i]);
        }

        int totalVolume = 0;
        for (int i = 0; i < len; i++) {
            int thisVol = Math.min(maxL[i], maxR[i]) - height[i];
            if (thisVol > 0)
                totalVolume += thisVol;
        }
        return totalVolume;
    }
}