class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;

        for(int i=0; i<nums.length; i++) {
            int crrCount = 0;
            while(i < nums.length && nums[i] == 1) {
                crrCount += 1;
                i++;
            }
            maxCount = Math.max(maxCount, crrCount);
        }

        return maxCount;
    }
}