package org.example;

import java.util.*;

public class CheckingExistenceOfEdgeDisjointSetUnion {

    // n = 3, edgeList = [[0,1,2],[1,2,4],[2,0,8],[1,0,16]], queries = [[0,1,2],[0,2,5]]
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        List<Query> qu = new ArrayList<>();
        for (int i= 0; i< queries.length; i++) {
            qu.add(new Query(queries[i][0], queries[i][1], queries[i][2], i));
        }
        qu.sort(new Comparator<Query>() {
            @Override
            public int compare(Query o1, Query o2) {
                return o1.getDistance() - o2.getDistance();
            }
        });

        List<Edge> ed = new ArrayList<>();
        for (int[] e: edgeList) {
            ed.add(new Edge(e[0], e[1], e[2]));
        }

        ed.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.getDistance() - o2.getDistance();
            }
        });

        int edgeIndex = 0;

        Duset duset = new Duset(n);

        boolean[] result = new boolean[queries.length];

        for (Query q: qu) {
            while (edgeIndex < ed.size() && ed.get(edgeIndex).getDistance() < q.getDistance()) {
                duset.union(ed.get(edgeIndex).getFrom(), ed.get(edgeIndex).getTo());
                edgeIndex++;
            }

            result[q.getIndex()] = duset.find(q.getFrom()) == duset.find(q.getTo());
        }

        return  result;
    }


    class Edge {
        int from, to, distance;
        public Edge(int from, int to, int distance) {
            this.from = from;
            this.to = to;
            this.distance = distance;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        public int getDistance() {
            return distance;
        }
    }

    class Query {
        int from, to, distance, index;
        public Query(int from, int to, int distance, int index) {
            this.from = from;
            this.to = to;
            this.distance = distance;
            this.index = index;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        public int getDistance() {
            return distance;
        }

        public int getIndex() {
            return index;
        }
    }

    class Duset {

        int[] du;
        public Duset(int n) {
            du = new int[n];

            for (int i =0; i < n; i++) {
                du[i] = i;
            }
        }

        public int find(int x) {
            if(x == du[x]) {
                return x;
            }
            return du[x] = find(du[x]);
        }

        public void union(int x, int y) {
            int m = find(x);
            int n = find(y);

            if(m != n) {
                du[n] =m;
            }
        }
    }
}
