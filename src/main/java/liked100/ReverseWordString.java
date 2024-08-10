package liked100;

public class ReverseWordString {
    public String reverseWords(String s) {
        char[] input = s.toCharArray();


        // reverse whole string
        reverse(input, 0, s.length()-1);

        //System.out.println(new String(input));

        // reverse indivisual word, skipping the space
        int i =0;

        while(i < input.length) {

            while (i < input.length && input[i] == ' ') {
                i++;
            }

            int start = i;
            int end = i;

            while(end < input.length) {
                if(input[end] == ' ') {
                    break;
                }
                end++;
            }

            reverse(input, start, end-1);

            i = end+1;

        }



        char[] result = new char[input.length];

        int m = 0;

        int k = 0;

        // clean the string by removing unneccesary spaces
        while(k < input.length) {

            while (input[k] == ' ') {
                k++;
            }

            while (k < input.length && input[k] != ' ') {
                result[m++] = input[k++];
            }

            int j = k;

            while(j < input.length && input[j] == ' ') {
                j++;
            }

            if(j < input.length) {
                result[m++] = ' ';
            }

            k = j;
        }


        return new String(result, 0 , m);
    }

    private void reverse(char[] cha, int left, int right) {
        //StringBuilder sb = new StringBuilder(reverse);
        while(left < right) {
            char t = cha[left];
            cha[left] = cha[right];
            cha[right] = t;
            left++;
            right--;
        }
    }
}
