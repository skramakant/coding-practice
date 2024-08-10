package liked100;

import java.util.Arrays;

public class Merge2Array {


    // nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    // [1, 2, 2, 0]   --[3,5,6]

    //[4,5,6,0,0,0]
    //3
    //[1,2,3]
    //3

    //[1]  [4,2,3]
    public void merge(int[] nums1, int m, int[] nums2, int n) {

//        int j = 0;
//        for(int i = m; i < nums1.length; ) {
//            nums1[i++] = nums2[j++];
//        }
//
//        Arrays.sort(nums1);




        // fill from last element, pick largest of both array and keep filling
        int i = m-1;
        int j = n-1;
        int k = m+n-1; // nums1.length-1


        while (i>=0 && j>=0) {
            if(nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                k--;
                i--;
            } else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }

        while (j >=0) {
            nums1[k--] = nums2[j--];
        }


//        int i = 0, j = 0, k = m;
//        while (i < m && j < n) {
//            if(nums1[i] <= nums2[j]) {
//                //do nothing
//                i++;
//            } else if(nums1[i] > nums2[j]) {
//                nums1[k++] = nums1[i];
//                nums1[i] = nums2[j];
//                j++;
//                i++;
//            }
//        }
//
//        k = m;
//        while (j < n) {
//            if(nums1[k] <= nums2[j]) {
//                //do nothing
//                k++;
//            } else if(nums1[k] > nums2[j]) {
//                nums1[k++] = nums1[i];
//                nums1[i] = nums2[j];
//                j++;
//                i++;
//            }
//        }

        System.out.println(Arrays.toString(nums1));
    }
}
