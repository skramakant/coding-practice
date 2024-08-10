package liked100;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MedianSortedArray {

    // [1, 2] [3,4]
    // [1,2,3,4]
    // 2+3/2 = 2.5


    // O (m+n)

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int l1 = nums1.length;
        int l2 = nums2.length;

        int total = l1 + l2;

        int p1 = 0, p2 = 0;

        int[] mergedArr = new int[l1 + l2];

        List<Integer> list1 = new ArrayList<>();
        int k = 0;
        while (p1 < l1 && p2 < l2) {
            if (nums1[p1] <= nums2[p2]) {
                mergedArr[k] = nums1[p1];
                p1++;
            } else {
                mergedArr[k] = nums2[p2];
                p2++;
            }
            k++;
        }

        while (p1 < l1) {
            mergedArr[k] = nums1[p1++];
            k++;
        }


        while (p2 < l2) {
            mergedArr[k] = nums2[p2++];
            k++;
        }

        return median(mergedArr);
    }

    public double median(int[] nums) {
        int l = nums.length;
        int m = l / 2;
        if (l % 2 == 0) {
            return (nums[m] + nums[m - 1])*1.0 / 2;
        } else {
            return nums[m]*1.0;
        }
    }
}

//1, 2
//3, 4



