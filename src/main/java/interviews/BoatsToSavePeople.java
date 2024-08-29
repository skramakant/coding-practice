package interviews;

import java.util.Arrays;

// https://leetcode.com/problems/boats-to-save-people/
public class BoatsToSavePeople {


    // solve int in O(n)
    public int numRescueBoats(int[] people, int limit) {
        // using counting sort as weight of any person will not be more then boat limit

        int[] countSort = new int[limit+1];

        for(int p : people) {
            countSort[p]++;
        }

        int start = 0, end = countSort.length-1;

        int ans = 0;

        while (start <= end) {

            // first start position in bucket
            while(countSort[start] <=0 && start<=end) start++;

            //first position from end
            while (countSort[end] <=0 && start<=end) end--;

            // mo body left
            if((countSort[start] <=0 && countSort[end] <= 0) || start > end) {
                break;
            }

            if(start + end <= limit) {
                countSort[start]--;
                countSort[end]--;
                ans++;
            } else  {
                ans++;
                countSort[end]--;
            }

        }

        return ans;
    }

    // O(nlogn)
    public int numRescueBoatsSort(int[] people, int limit) {
        Arrays.sort(people);

        int ans = 0;

        int i =0, j = people.length - 1;

        while(i <= j) {
            int twoPeopleWaitSum = people[i] + people[j];

            if(twoPeopleWaitSum <= limit) {
                ans++;
                i++;
                j--;
            } else {
                ans++;
                j--;
            }
        }

        return ans;
    }
}
