package org.example;

import java.util.*;

public class LargestColorPathValueGraphTopological {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();

        int[][] cache = new int[n][26];

        Map<Integer, LinkedList<Integer>> outDegree = new HashMap<>();

        int[] inDegree = new int[n];

        for (int[] edge : edges) {
            outDegree.computeIfAbsent(edge[0], k -> new LinkedList<>()).add(edge[1]);
            inDegree[edge[1]]++;
        }

        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int visited = 0;
        int res = 1;

        while (!queue.isEmpty()) {
            visited++;
            int top = queue.removeFirst();

            res = Math.max(res, ++cache[top][colors.charAt(top) - 'a']);

            if (!outDegree.containsKey(top)) {
                continue;
            }
            //get nighours
            LinkedList<Integer> inLinkedList = outDegree.get(top);
            for (Integer node : inLinkedList) {
                inDegree[node]--;
                for (int i = 0; i < 26; i++) {
                    cache[node][i] = Math.max(cache[node][i], cache[top][i]);
                }
                if (inDegree[node] == 0) {
                    queue.add(node);
                }
            }
        }

        if (visited < n) {
            return -1;
        }

        return res;
    }
}
