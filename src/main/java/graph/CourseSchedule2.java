package graph;

import java.util.*;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> incoming = new HashMap<>(); // [3 <- 1]   // here 3 depends on 1 means 1 connection coming to 3

        Map<Integer, List<Integer>> outgoing = new HashMap<>();

        for(int i = 0; i < numCourses; i++) {
            incoming.put(i, 0); // I am not dependent on anyone , initialize
            outgoing.put(i, new ArrayList<>()); // nobody depends on me .intialize
        }

        for(int[] x : prerequisites) {
            incoming.put(x[0], incoming.getOrDefault(x[0], 0) + 1);

            var temoList = outgoing.getOrDefault(x[1], new ArrayList<>());
            temoList.add(x[0]);
            outgoing.put(x[1], temoList);
        }

        Queue<Integer> queue = new LinkedList<>();

        for(Map.Entry<Integer, Integer> incomingEntry : incoming.entrySet()) {
            // this node can get completed first
            if(incomingEntry.getValue() == 0) {
                queue.add(incomingEntry.getKey());
            }
        }

        List<Integer> result = new LinkedList<>();

        while (!queue.isEmpty()) {

            int node = queue.poll();

            if(incoming.get(node) == 0) {
                result.add(node);
            }

            List<Integer> dependents = outgoing.get(node);
            for(Integer nd : dependents) {
                // reduce dependecy of dependent nodes , because this node already completed
                incoming.put(nd, incoming.get(nd) -1);

                if(incoming.get(nd) == 0) {
                    queue.add(nd);
                }
            }

        }

        System.out.println(result);

        if(result.size() < numCourses) {
            return new int[]{};
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
