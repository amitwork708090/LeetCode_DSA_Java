class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        int count = 0;

        for(int i=0; i<n; i++) {
            int c = intervals[i][0];
            int d = intervals[i][1];

            boolean isCovered = false;

            for(int j=0; j<n; j++) {
                int a = intervals[j][0];
                int b = intervals[j][1];

                if(i != j && (a <= c && b >= d)) {
                    isCovered = true;
                    break;
                }
            }
            if(!isCovered) {
                count++;
            }
        }
        return count;
    }
}