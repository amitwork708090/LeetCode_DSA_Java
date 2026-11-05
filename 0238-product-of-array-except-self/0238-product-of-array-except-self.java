class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        for(int i=0; i<left.length; i++) {
            if(i == 0) {
                left[i] =1;
                continue;
            }

            left[i] = left[i - 1] * nums[i - 1];
        }

        for(int i=right.length - 1; i>=0; i--) {
            if(i == right.length - 1) {
                right[i] = 1;
                continue;
            }

            right[i] = right[i + 1] * nums[i + 1];
            left[i] = left[i] * right[i];
        }

        return left;
    }
}