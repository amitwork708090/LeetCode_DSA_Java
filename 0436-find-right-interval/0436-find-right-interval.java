class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] res = new int[n];

        for(int i=0; i<n; i++) {
            int minStartIdx = -1;

            for(int j=0; j<n; j++) {
                if(intervals[j][0] >= intervals[i][1]) {
                    if(minStartIdx == -1) minStartIdx = j;

                    if(intervals[minStartIdx][0] > intervals[j][0]) {
                        minStartIdx = j;
                    }
                }

                res[i] = minStartIdx;
            }
        }
        return res;
    }
}