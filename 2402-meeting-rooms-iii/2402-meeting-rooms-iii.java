class MeetingEndTime_Room {
    long et;
    int idx;

    public MeetingEndTime_Room(long et, int idx) {
        this.et = et;
        this.idx = idx;
    }
}

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        //heap
        PriorityQueue<Integer> avaliableRoom = new PriorityQueue<>();
        PriorityQueue<MeetingEndTime_Room> occupiedRoom = new PriorityQueue<>( // endtime , index
            (a, b) -> {
                if(a.et == b.et) {
                    return a.idx - b.idx;
                }
                else {
                    return Long.compare(a.et, b.et);
                }
            }
        );

        long[] endTimeOfRoom = new long[n];
        int[] count = new int[n];

        for(int i=0; i<n; i++) {
            avaliableRoom.add(i);
        }

        for(int i=0; i<meetings.length; i++) {
            int startTime = meetings[i][0];
            int endTime = meetings[i][1];
            
            while(!occupiedRoom.isEmpty()) {
                if(startTime >= occupiedRoom.peek().et) {
                    MeetingEndTime_Room occRoomDetail = occupiedRoom.poll();
                    avaliableRoom.add(occRoomDetail.idx);
                }
                else {
                    break;
                }
            }

            
           if(avaliableRoom.isEmpty()) {
                MeetingEndTime_Room minOccMeetingRoom = occupiedRoom.poll();
                minOccMeetingRoom.et += endTime - startTime;
                occupiedRoom.add(new MeetingEndTime_Room(minOccMeetingRoom.et, minOccMeetingRoom.idx));
                count[minOccMeetingRoom.idx]++;
           }
           else {
            int room = avaliableRoom.poll();
            count[room]++;
            occupiedRoom.add(new MeetingEndTime_Room(endTime, room));
           }

        }

        int maxCountIdx = 0;

        for(int i=0; i<count.length; i++) {
            if(count[i] > count[maxCountIdx]) {
                maxCountIdx = i;
            }
        }

        return maxCountIdx;
    }
}

//Tc = 
//Sc = 