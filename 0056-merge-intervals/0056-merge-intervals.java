class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        list.add(intervals[0]);

        for(int i=1; i<intervals.length; i++) {
            int[] prev = list.get(list.size() - 1);
            int[] crr = intervals[i];

            if(prev[1] >= crr[0]) {
                prev[0] = Math.min(prev[0], crr[0]);
                prev[1] = Math.max(prev[1], crr[1]);
            }
            else {
                list.add(intervals[i]);
            }
        }

        int[][] res = new int[list.size()][2];

        for(int x=0; x<list.size(); x++) {
            res[x] = list.get(x);
        }

        return res;
    }
}