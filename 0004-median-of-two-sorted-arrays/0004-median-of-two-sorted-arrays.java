class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergeArray = merge(nums1, nums2);
        int len = mergeArray.length;
        
        if(len % 2 == 0) { // even length
            int mid1 = len / 2;
            int mid2 = mid1 - 1;

            double median = (double) (mergeArray[mid1] + mergeArray[mid2]) / 2;

            return median;

        }
        else { // odd length
            return (double) mergeArray[len / 2];
        }
    }

    public int[] merge(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int res[] = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < n && j < m) {
            if(nums1[i] <= nums2[j]) {
                res[k] = nums1[i];
                i++;
                k++;
            }
            else { // nums1[i] > nums2[j];
                res[k] = nums2[j];
                k++;
                j++;
            }
        }

        while(i < n) {
            res[k] = nums1[i];
            k++;
            i++;
        }

        while(j < m) {
            res[k] = nums2[j];
            k++;
            j++;
        }
        return res;
    }
}