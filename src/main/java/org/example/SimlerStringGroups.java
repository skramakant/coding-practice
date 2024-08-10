package org.example;

import java.util.*;
class SimlerStringGroups {

    int[] visited;
    public int numSimilarGroups(String[] strs) {

        int l = strs.length;

        visited = new int[l];

        Map<Integer, List<Integer>> addList = new HashMap<Integer, List<Integer>>();

        for(int i =0; i<l; i++) {
            for (int j = i+1; j<l; j++) {
                if(isSimiler(strs[i], strs[j])) {
                    if(addList.containsKey(i)) {
                        addList.get(i).add(j);
                    } else {
                        List<Integer> tl = new ArrayList<>();
                        tl.add(j);
                        addList.put(i, tl);
                    }
                    if(addList.containsKey(j)) {
                        addList.get(j).add(i);
                    } else {
                        List<Integer> tl = new ArrayList<>();
                        tl.add(i);
                        addList.put(j, tl);
                    }
                }
            }
        }

        int count = 0;

        for(int i = 0; i<l; i++) {
            if(visited[i] == 0) {
                count++;
                dfs(addList, i);
            }
        }

        return count;
    }


    public void dfs(Map<Integer, List<Integer>> addList, int i) {
        visited[i] = 1;
        for(Integer x : addList.get(i)) {
            if(visited[x] == 0) {
                dfs(addList, x);
            }
        }
    }

    public boolean isSimiler(String s1, String s2) {
        int diff = 0 ;
        int l = s1.length();
        for(int i =0; i<l; i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }

        return diff == 2 || diff == 0;
    }
}