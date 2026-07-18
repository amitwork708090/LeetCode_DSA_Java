class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        for (int[] interval : intervals) {
            list.add(interval);
        }

        boolean isHappened = true;

        while (isHappened) {
            isHappened = false;
            for (int i = 0; i < list.size(); i++) {
                int j = i + 1;

                while (j < list.size()) {
                    int[] n1 = list.get(i);
                    int[] n2 = list.get(j);

                    if (isOverLap(n1, n2)) {
                        n1[0] = Math.min(n1[0], n2[0]);
                        n1[1] = Math.max(n1[1], n2[1]);

                        list.remove(j);
                        isHappened = true;
                    } else {
                        j = j + 1;
                    }
                }
            }
        }

        int[][] res = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public boolean isOverLap(int[] n1, int[] n2) {
        return (n1[1] >= n2[0]) && (n2[1] >= n1[0]);
    }
}