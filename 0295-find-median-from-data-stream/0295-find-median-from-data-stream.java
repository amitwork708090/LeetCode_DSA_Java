class MedianFinder {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(max.isEmpty()) {
            max.add(num);
            return;
        }

        //even case
        if(min.size() == max.size()) {
            if(num > max.peek()) {
                min.add(num);
                max.add(min.poll());
            }
            else {
                max.add(num);
            }
        }
        //odd case
        else {
            max.add(num);
            min.add(max.poll());
        }
    }
    
    public double findMedian() {
        //even case
        if(min.size() == max.size()) {
            return (max.peek() + min.peek()) / 2.0;
        }
        //odd case
        return max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */