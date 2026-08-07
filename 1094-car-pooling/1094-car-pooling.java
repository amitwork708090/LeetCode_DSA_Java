class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> tree = new TreeMap<>();

        for(int[] trip : trips) {
            int pass = trip[0];
            int start = trip[1];
            int end = trip[2];

            tree.put(start, tree.getOrDefault(start, 0) + pass);
            tree.put(end, tree.getOrDefault(end, 0) - pass);
        }

        int passengers = 0;

        for(Map.Entry<Integer, Integer> entry : tree.entrySet()) {
            passengers = passengers + entry.getValue();

            if(passengers > capacity) return false;
        }

        return true;
    }
}