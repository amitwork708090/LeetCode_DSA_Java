class MyCalendar {

    TreeMap<Integer, Integer> tree;

    public MyCalendar() {
        tree = new TreeMap<Integer, Integer>();
    }
    
    public boolean book(int startTime, int endTime) {
        //Adding startTime & endTime in tree...
        tree.put(startTime, tree.getOrDefault(startTime, 0) + 1);
        tree.put(endTime, tree.getOrDefault(endTime, 0) - 1);

        int bookings = 0;

        for(Map.Entry<Integer, Integer> entry : tree.entrySet()) {
            bookings = bookings + entry.getValue();

            if(bookings > 1) {
                tree.put(startTime, tree.get(startTime) - 1);
                tree.put(endTime, tree.get(endTime) + 1);

                if(tree.get(startTime) == 0) tree.remove(startTime);
                if(tree.get(endTime) == 0) tree.remove(endTime);

                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */