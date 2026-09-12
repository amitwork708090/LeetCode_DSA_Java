class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int tragetFriendTime = times[targetFriend][0];

        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        
        int[] chairs = new int[times.length];

        for(int i=0; i<chairs.length; i++) {
            for(int j=0; j<chairs.length; j++) {
                if(times[i][0] >= chairs[j]) {
                if(times[i][0] == tragetFriendTime) {
                    return j;
                }
                chairs[j] = times[i][1];
                break;
                }
            }
        }
        return -1;
    }
}