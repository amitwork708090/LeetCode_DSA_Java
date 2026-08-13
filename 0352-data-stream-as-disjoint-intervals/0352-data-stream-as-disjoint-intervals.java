class SummaryRanges {

    TreeSet<Integer> set;

    public SummaryRanges() {
        set = new TreeSet<Integer>();
    }
    
    public void addNum(int value) {
        set.add(value);
    }
    
    public int[][] getIntervals() {

        if(set.isEmpty()) return new int[][] {};


        Integer left = null, right = null;

        List<int[]> res = new ArrayList<>();

        for(Integer val : set) {
            if(left == null && right == null) {
                left = val;
                right = val;
            }
            else if(val == right + 1) {
                right = val;
            }
            else {
                res.add(new int[]{left, right});
                left = val;
                right = val;
            }
        }

        res.add(new int[]{left, right});

        int[][] ans = new int[res.size()][2];
        for(int i=0; i<res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */