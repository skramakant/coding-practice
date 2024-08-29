package org.example;

import blind75.*;
import corejava.ThreadCommViaWaitNotify;
import corejava.ThreadCommunicationViaQueue;
import interviews.CheapestFlightWithInKStops;
import interviews.MaxPossibleScore;
import interviews.MostBookedRoom;
import interviews.ShoppingWillingWaitTime;
import liked100.*;
import live.MinimumMeetingRoom;
import live.RemoveDuplicateFromString;
import tree.SumArrayByRecursion;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
//        int[][] grid = new int[][]{
//                {1, 1, 1, 1, 1, 1, 1, 0},
//                {1, 0, 0, 0, 0, 1, 1, 0},
//                {1, 0, 1, 0, 1, 1, 1, 0},
//                {1, 0, 0, 0, 0, 1, 0, 1},
//                {1, 1, 1, 1, 1, 1, 1, 0},
//        };
//
//        int res = new NumberClosedIsland().closedIsland(grid);
//        System.out.println(res);

//        System.out.println("remove stars");
//
//        System.out.println(new RemoveStars().removeStars("adwda**"));
//

//        System.out.println("simplyfy path");
//
//        System.out.println(new SimplifyPath().simplifyPath("/home//foo/"));
//        System.out.println(new SimplifyPath().simplifyPath("/home/"));
//        System.out.println(new SimplifyPath().simplifyPath("/../"));
//
//        System.out.println("longest palindrome subsequence");
//        System.out.println(new LongestPalindromSubsequence().longestPalindromeSubseq("bbbab"));
//        System.out.println(new LongestPalindromSubsequence().longestPalindromeSubseq("cbbd"));

        // stones

//        System.out.println(new LastStoneWeight().lastStoneWeight(new int[]{2,7,4,1,8,1}));
        // n = 3, edgeList = [[0,1,2],[1,2,4],[2,0,8],[1,0,16]], queries = [[0,1,2],[0,2,5]]
//        5
//                [[0,1,10],[1,2,5],[2,3,9],[3,4,13]]
//[[0,4,14],[1,4,13]]

//        int[][] edges = { {0,1,10}, {1,2,5}, {2,3,9}, {3,4,13} };
//        int[][] queries = {{0,4,14}, {1,4,13}};
//        boolean[] r = new CheckingExistenceOfEdgeDisjointSetUnion().distanceLimitedPathsExist(5, edges, queries);
//        for (boolean m: r) {
//            System.out.println(m);
//        }

        //threadMessagePass();
//        anagramGroups();
//        kMostFrequent();
//        encodeDecodeString();
//        isPalindrome();
//        threadCommunication();
//        tripleSum();
//        maxWaterSum();
//        longestSubstringNotRepeatingChar();
//        longestCharacterReplacement();
//        wordDictionary();
//        letterCombination();
          //combinationSum();
        test();
    }
    public static void threadMessagePass() {
        BlockingQueue<Integer> in = new LinkedBlockingQueue<>();

        for (int i =1 ; i < 100 ; i++) {
            in.add(i);
        }
        in.add(0);

        ThreadCommunicationViaQueue a = new ThreadCommunicationViaQueue(in, new LinkedBlockingQueue<>());
        a.passMessage();
        a.consumeMessage();
    }

    public static void anagramGroups() {
        System.out.println(new AnagramGroups().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    public static void kMostFrequent() {
        System.out.println(new TopKFrequentElement().topKFrequentBucketSort(new int[]{1,1,1,2,2,3}, 2));
    }

    public static void encodeDecodeString(){
        String encode = new EncodeDecodeString().encode(List.of("lintcodeleetcode","code","love","you"));
        System.out.println(encode);
        System.out.println(new EncodeDecodeString().decode(encode));
    }

    public  static  void isPalindrome() {
        System.out.println(new ValidPanindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static void threadCommunication() {
       ThreadCommViaWaitNotify threadCommViaWaitNotify = new ThreadCommViaWaitNotify();
       new Thread(new Runnable() {
           @Override
           public void run() {
               threadCommViaWaitNotify.produce();
           }
       }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadCommViaWaitNotify.consumer();
            }
        }).start();
    }

    public static void tripleSum() {
        System.out.println(new TripletSum().threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    public static void maxWaterSum() {
        System.out.println(new MaxAreaWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public static void longestSubstringNotRepeatingChar() {
        System.out.println(new LongestSubString().lengthOfLongestSubstring("abba"));
    }

    public static void longestCharacterReplacement() {
        System.out.println(new LongestCharacterReplacement().characterReplacement("AABABBA", 1));
    }

    public static void wordDictionary() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("word");
        System.out.println(wordDictionary.search("word"));

        wordDictionary.addWord("wordxt");
        System.out.println(wordDictionary.search("w..dxt"));
    }

    public static void letterCombination() {
        LetterCombination letterCombination = new LetterCombination();
        System.out.println(letterCombination.letterCombinations("23"));
    }

    public static void combinationSum() {
        CombinationSum letterCombination = new CombinationSum();
        System.out.println(letterCombination.combinationSum(new int[]{2,3,6,7}, 7));
    }


    public static void test() {
        //int[] input = new int[]{ 20,10,20,30,40,50,80,10,90 };
        //int[] input = new int[]{ 20,10,20,30,40,50,80,10,5 };
        //System.out.println(Solution.findMaxProfitDays(new int[]{20, 10, 20, 30, 40, 50, 80, 10, 90}));
//        new Merge2Array().merge(
//                new int[]{4,0,0,0,0,0}, 1, new int[]{1,2,3,5,6}, 5
//        );
        //System.out.println(new MinimumMeetingRoom().minimumRoom());
        //System.out.println(new BestTimeToBuySell2().maxProfit(new int[]{7,1,5,3,6,4}));

        //System.out.println(new RemoveDuplicateFromString().removeDuplicateCharString("aaabbcddbbbaaa"));
        //System.out.println(new FirstOccuranceStringIndex().strStr("leetcode", "leet0"));

        //System.out.println(new MaxPossibleScore().maxScore(new int[]{3,12,9,10}));
        //System.out.println(new SumArrayByRecursion().sum());
        //System.out.println(new ShoppingWillingWaitTime().waitTime(4, 4, new int[]{0, 0, 0, 0}));
//        System.out.println(new CheapestFlightWithInKStops().findCheapestPrice(4, new int[][]{
//                {0,1,1},
//                {0,2,5},
//                {1,2,1},
//                {2,3,1}
//        }, 0, 3, 1));

        System.out.println(new MostBookedRoom().mostBooked(3, new int[][] {
                {1,20},
                {2,10},
                {3,5},
                {4,9},
                {6,8}
        }));
    }
}

