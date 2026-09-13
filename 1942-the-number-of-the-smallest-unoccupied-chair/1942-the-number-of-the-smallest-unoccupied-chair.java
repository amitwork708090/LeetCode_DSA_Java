class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        
        // [[1,4],[2,3],[4,6]], targetFriend = 1

        int targetFriendArrival = times[targetFriend][0]; // 2

        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        // [[1,4],[2,3],[4,6]]

        PriorityQueue<Integer> avaliableChairs = new PriorityQueue<>();

        PriorityQueue<int[]> occupiedChairs = new PriorityQueue<>((a, b) -> a[0] - b[0]); // int[] {endTime, index}

        for(int i=0; i<times.length; i++) {
            avaliableChairs.add(i); // 0, 1, 2
        }

        for(int i=0; i<times.length; i++) {
            int at = times[i][0]; // "at" means avaliableTime = 2

            while(!occupiedChairs.isEmpty()) {
                    // 2 >= 4
                if(at >= occupiedChairs.peek()[0]) {
                    int[] chair = occupiedChairs.poll();
                    avaliableChairs.add(chair[1]);
                }
                else {
                    break;
                }
            }

            int c = avaliableChairs.poll(); // 0, 1, 2 -> 1, 2 -> 2
            
                // 2 == 2 return true
            if(at == targetFriendArrival) {
                return c;
            }

            occupiedChairs.add(new int[]{
                times[i][1], c // endTime, index oc = {4,0}
            });


        }
    return -1;
    }
}