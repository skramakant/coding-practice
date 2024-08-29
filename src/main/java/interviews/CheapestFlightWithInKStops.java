package interviews;

import java.util.*;

public class CheapestFlightWithInKStops {


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        for(int step =0; step<=k ; step++) {

            int[] temp = cost.clone();

            for(int[] flight : flights) {
                int currentStation = flight[0];
                int nextStation = flight[1];
                int costTravel = flight[2];
                if(cost[currentStation] == Integer.MAX_VALUE) {
                    continue;
                }
                temp[nextStation] = Math.min(temp[nextStation], cost[currentStation] + costTravel);
            }

            cost = temp;
        }

        return cost[dst] == Integer.MAX_VALUE? -1 : cost[dst];
    }

    // priority queue dikishtra
    // TLE
//    .Dijkstra's
//    Much like BFS, but use a PriorityQueue based on the cheapest cost. Incorporate the stop limit to individual paths to traverse upto k stops.
    public int findCheapestPriceDks(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();

        for(int[] flight : flights) {
            map.putIfAbsent(flight[0], new ArrayList<>());
            map.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        // cost, node, step
        pq.offer(new int[]{0, src, k+1});

        while (!pq.isEmpty()) {
            int[] t = pq.poll();

            int cost = t[0];
            int curr = t[1];
            int stops = t[2];

            if(curr == dst) {
                return  cost;
            }

            if(!map.containsKey(curr)) {
                continue;
            }

            if(stops > 0) {
                for(int[] nextFlight : map.get(curr)) {
                    pq.offer(new int[]{cost + nextFlight[1], nextFlight[0], stops-1});
                }
            }

        }

        return -1;
    }

    // bfs, giving tle
    public int findCheapestPriceBfs(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<Stopage>> map = new HashMap<>();

        for(int i =0; i< n; i++) {
            map.put(i, new LinkedList<Stopage>());
        }

        for(int[] edge : flights) {
            List<Stopage> temp = map.get(edge[0]);
            temp.add(new Stopage(edge[1], edge[2]));
            map.put(edge[0], temp);
        }

        int[] prices = new int[n];

        for(int i=0; i<n; i++) {
            prices[i] = Integer.MAX_VALUE;
            if(i == src) {
                prices[src] = 0;
            }
        }

        int[] visited = new int[n];

        Queue<StopNode> q = new LinkedList<>();
        q.add(new StopNode(src, 0));

        int stopx = 0;

        while(stopx <=k && !q.isEmpty()) {


            int size = q.size();

            while (size-- != 0) {

                StopNode onNode = q.remove();

                for(Stopage s : map.get(onNode.node)) {

                    int t = prices[onNode.node] + s.cost;


                    if(stopx == k && s.node != dst) {
                        continue;
                    }

                    if(t < prices[s.node]) {
                        prices[s.node] = t;
                    }

                    q.add(new StopNode(s.node, onNode.stops + 1));
                }
            }



//            if(visited[onNode.node] == 1) {
//                continue;
//            }
//
//            visited[onNode.node] = 1;

//            for(Stopage s : map.get(onNode.node)) {
//
//                if(onNode.stops <= k) {
//
//                    int t = prices[onNode.node] + s.cost;
//
//                    if(t < prices[s.node] && onNode.stops + 1 <= k && s.node != dst) {
//                        prices[s.node] = t;
//                    }
//
//                    q.add(new StopNode(s.node, onNode.stops + 1));
//
//                }
//
//            }

            stopx++;
        }

        return prices[dst] == Integer.MAX_VALUE? -1 : prices[dst];
    }
}

class StopNode {
    int node;
    int stops;

    public StopNode(int node, int stops) {
        this.node = node;
        this.stops = stops;
    }
}

class Stopage {
    int node;
    int cost;
    public Stopage(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

