package blind75;

public class FindMinimumRotatedSortedArray {

    //nums = [3,4,5,1,2]
    // 0, 1, 2, 3, 4
    public int findMin(int[] nums) {
        int l =0, r= nums.length-1;

        while (l < r) {
            int mid = (l+r)/2;
            if(nums[mid] > nums[r]) {
               l = mid + 1;
            } else {
                r = mid;
            }
        }

        return nums[r];
    }
}
