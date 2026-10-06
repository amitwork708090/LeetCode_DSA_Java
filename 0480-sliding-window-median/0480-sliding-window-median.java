class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<k; i++) {
            int num = nums[i];

            // If maxHeap is empty 
            if(maxHeap.isEmpty()) {
                maxHeap.add(num);
                continue;
            }
            
            //even case
            if(maxHeap.size() == minHeap.size()) {
                if(num > maxHeap.peek()) {
                    minHeap.add(num);
                    maxHeap.add(minHeap.poll());
                }
                else {
                    maxHeap.add(num);
                }
            }
            else { //Odd case
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
            }
        }

        int n = nums.length;
        double[] res = new double[n - k + 1];
        int j = 0;

        if(k % 2 == 0) {
            res[j] = ((double) maxHeap.peek() + minHeap.peek()) / 2.0;
            j++;
        }
        else {
            res[j] = maxHeap.peek();
            j++;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=k; i<n; i++) {
            int numA = nums[i]; //Adding number
            int numR = nums[i - k]; // Removing number

            map.put(numR, map.getOrDefault(numR, 0) + 1);
            int count = 0; //If we add numA in maxHeap then count++ and if we add in minHeap count--;

            if(numA <= maxHeap.peek()) {
                maxHeap.add(numA);
                count++;
            }
            else {
                minHeap.add(numA);
                count--;
            }

            if(numR <= maxHeap.peek()) {
                count--;
            }
            else {
                count++;
            }

            if(count > 0) {
                minHeap.add(maxHeap.poll());
            }
            if(count < 0) {
                maxHeap.add(minHeap.poll());
            }
            
            while(!maxHeap.isEmpty() && map.getOrDefault(maxHeap.peek(), 0) > 0) {
                int ele = maxHeap.peek();
                map.put(ele, map.get(ele) - 1);
                maxHeap.poll();
            }
            while(!minHeap.isEmpty() && map.getOrDefault(minHeap.peek(), 0) > 0) {
                int ele = minHeap.peek();
                map.put(ele, map.get(ele) - 1);
                minHeap.poll();
            }

            if(k % 2 == 0) {
                res[j] = ((double) maxHeap.peek() + minHeap.peek()) / 2.0;
                j++;
            }
            else {
                res[j] = maxHeap.peek();
                j++;
            }

        }
    return res;
    }
}