class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> numsToFreqs = new HashMap<>();
        for (int num : nums) {
            Integer freq = numsToFreqs.get(num);
            if (freq != null) {
                numsToFreqs.put(num, freq + 1);
            } else {
                numsToFreqs.put(num, 1);
            }
        }

        HashMap<Integer, List<Integer>> freqsToNums = new HashMap<>();
        for (Integer num : numsToFreqs.keySet()) {
            Integer freq = numsToFreqs.get(num);
            List<Integer> numsForFreq = freqsToNums.get(freq);
            if (numsForFreq != null) {
                numsForFreq.add(num);
            } else {
                List<Integer> newList = new ArrayList<>(Arrays.asList(num));
                freqsToNums.put(freq, newList);
            }
        }

        Set<Integer> freqSet = freqsToNums.keySet();
        int[] sortedFreqs = new int[freqSet.size()];
        int count = 0;
        for (Integer thisFreq : freqSet) {
            sortedFreqs[count] = thisFreq;
            count++;
        }
        Arrays.sort(sortedFreqs);

        int[] topKs = new int[k];
        int idx = 0;

        for (int i = sortedFreqs.length - 1; i >= 0; i--) {
            List<Integer> nextKs = freqsToNums.get(sortedFreqs[i]);

            for (Integer nextNum : nextKs) {
                topKs[idx] = nextNum;
                idx++;
                if (idx == k)
                    break;
            }
            if (idx == k)
                break;
        }
        return topKs;
    }
}