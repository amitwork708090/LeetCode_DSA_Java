class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0;

        for(int i=0; i<nums.length; i++) {
            int crrVal = nums[i];

            int numberOfDigit = findNumberOfDigit(crrVal);

            if(numberOfDigit % 2 == 0) {
                ans++;
            }
        }

        return ans;
    }

    public int findNumberOfDigit(int num) {
        int count = 0;

        while(num > 0) {
            num = num / 10;
            count++;
        }

        return count;
    }
}