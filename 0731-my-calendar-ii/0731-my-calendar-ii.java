class MyCalendarTwo {

    TreeMap<Integer, Integer> tree;

    public MyCalendarTwo() {
        tree = new TreeMap<Integer, Integer>();
    }
    
    public boolean book(int startTime, int endTime) {
        tree.put(startTime, tree.getOrDefault(startTime, 0) + 1);
        tree.put(endTime, tree.getOrDefault(endTime, 0) - 1);

        int bookings = 0;
        for(Map.Entry<Integer, Integer> entry : tree.entrySet()) {
            bookings = bookings + entry.getValue();

            if(bookings > 2) {
                tree.put(startTime, tree.get(startTime) - 1);
                tree.put(endTime, tree.get(endTime) + 1);

                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */