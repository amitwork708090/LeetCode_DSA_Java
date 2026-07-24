class Solution {
    public int countDays(int days, int[][] meetings) {
        //Sort Array
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        //create list and add meetings array it 

        ArrayList<int[]> list = new ArrayList<>();
        list.add(meetings[0]);

        //Merge meetings and add in list 

        for(int i=1; i<meetings.length; i++) {
            if(list.get(list.size() - 1)[1] >= meetings[i][0]) { //e1 >= s2
                list.get(list.size() - 1)[0] = Math.min(list.get(list.size() - 1)[0], meetings[i][0]);
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], meetings[i][1]);
            }
            else {
                list.add(meetings[i]);
            }
        }

        //find meetings days

        int meetingDays = 0;
        for(int i=0; i<list.size(); i++) {
            meetingDays = meetingDays + list.get(i)[1] - list.get(i)[0] + 1;
        }

        int gap = days - meetingDays;
        return gap;
    }
}