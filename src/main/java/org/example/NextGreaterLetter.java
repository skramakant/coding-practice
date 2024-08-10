package org.example;

public class NextGreaterLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int h = letters.length - 1;

        while(l <= h) {
            int mid = l + (h-l)/2;

            if(letters[mid] > target) {
                h = mid-1;
            } else {
                l = mid+1;
            }
        }

        if(h+1 >= letters.length) {
            return letters[0];
        }

        return letters[h+1];
//        [1, 2,3]   4
//[1, 3, 5] 4
//        ["c","f","j"]
//        "c"
    }
}
