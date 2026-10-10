class ProjectDetails {
    int profit;
    int capital;

    public ProjectDetails(int profit, int capital) {
        this.profit = profit;
        this.capital = capital;
    }
}

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capitals) {
        int cc = w;
        ProjectDetails[] pjs = new ProjectDetails[profits.length];

        for(int i=0; i<pjs.length; i++) {
            pjs[i] = new ProjectDetails(profits[i], capitals[i]);
        }

        Arrays.sort(pjs, (a, b) -> a.capital- b.capital);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int p = 0;
        for(int i=0; i<k; i++) {
            
            while(p < pjs.length && cc >= pjs[p].capital) {
                maxHeap.add(pjs[p].profit);
                p++;
            }
            
            if(maxHeap.size() == 0) {
                return cc;
            }

            cc = cc + maxHeap.poll();
        }
        return cc;
    }
}