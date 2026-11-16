class Solution {

    public void conquer(int[] arr, int left, int mid, int right) {
        int[] sortArr = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                sortArr[k++] = arr[i++];
            } else { // arr[i] >= arr[j];
                sortArr[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            sortArr[k++] = arr[i++];
        }

        while (j <= right) {
            sortArr[k++] = arr[j++];
        }

        for (int x = 0; x < sortArr.length; x++) {
            arr[left + x] = sortArr[x];
        }
    }

    public void divide(int[] arr, int left, int right) {
        if (left >= right)
            return;

        int mid = left + (right - left) / 2;

        divide(arr, left, mid);
        divide(arr, mid + 1, right);
        conquer(arr, left, mid, right);
    }

    public void mergeSort(int[] arr) {
        divide(arr, 0, arr.length - 1);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        mergeSort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i == 0 || nums[i] != nums[i - 1]) {
                helperFunc(nums, i, res);
            }
        }
        return res;
    }

    public void helperFunc(int[] nums, int i, List<List<Integer>> res) {
        int j = i + 1;
        int k = nums.length - 1;

        while (j < k) {
            int sum = nums[i] + nums[j] + nums[k];

            if (sum < 0) {
                j++;
            } else if (sum > 0) {
                k--;
            } else {
                res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                j++;
                k--;

                while (j < k && nums[j] == nums[j - 1]) {
                    j++;
                }
                while (j < k && nums[k] == nums[k + 1]) {
                    k--;
                }
            }
        }
    }
}