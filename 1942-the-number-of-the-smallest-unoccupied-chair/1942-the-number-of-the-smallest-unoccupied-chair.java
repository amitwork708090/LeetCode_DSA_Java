class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int targetFriendArrival = times[targetFriend][0];

        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> avaliableChairs = new PriorityQueue<>();

        PriorityQueue<int[]> occupiedChairs = new PriorityQueue<>((a, b) -> a[0] - b[0]); // int[] {endTime, index}

        for(int i=0; i<times.length; i++) {
            avaliableChairs.add(i);
        }

        for(int i=0; i<times.length; i++) {
            int at = times[i][0];

            while(!occupiedChairs.isEmpty()) {
                if(at >= occupiedChairs.peek()[0]) {
                    int[] chair = occupiedChairs.poll();
                    avaliableChairs.add(chair[1]);
                }
                else {
                    break;
                }
            }

            int c = avaliableChairs.poll();

            if(at == targetFriendArrival) {
                return c;
            }

            occupiedChairs.add(new int[]{
                times[i][1], c // endTime, index
            });


        }
    return -1;
    }
}