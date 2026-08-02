class MyCalendar {

    List<int[]> list ;

    public MyCalendar() {
        list = new ArrayList<>();
    }

    public boolean overlap(int[] temp, int s2, int e2) {
        int s1 = temp[0];
        int e1 = temp[1];

        if(e1 >= s2 && e2 >= s1) {
            return true;
        }
        return false;
    }
    
    public boolean book(int startTime, int endTime) {
        if(list.size() == 0) {
            list.add(new int[] {startTime, endTime - 1});
            return true;
        }

        for(int i=0; i<list.size(); i++) {
            if(overlap(list.get(i), startTime, endTime - 1)) {
                return false;
            }
        }

        list.add(new int[] {startTime, endTime - 1});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */