class MyCalendarThree {

    TreeMap<Integer, Integer> tree;

    public MyCalendarThree() {
        tree = new TreeMap<Integer, Integer>();
        // key : touchpoints
        // value : bookings
    }
    
    public int book(int startTime, int endTime) {
        tree.put(startTime, tree.getOrDefault(startTime, 0) + 1);
        tree.put(endTime, tree.getOrDefault(endTime, 0) - 1);

        int booking = 0;
        int max = 0;

        for(Map.Entry<Integer, Integer> entry : tree.entrySet()) {
            booking = booking + entry.getValue();

            max = Math.max(max, booking);
        }

        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */