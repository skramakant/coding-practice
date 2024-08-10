package tree;

public class SumArrayByRecursion {

    public int sum() {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};

        return sun(arr, arr.length-1);
    }

    public int sun(int[] arr, int index) {
        if(index == 0) {
            return arr[index];
        }

        return arr[index] + sun(arr, index-1);
    }

}
