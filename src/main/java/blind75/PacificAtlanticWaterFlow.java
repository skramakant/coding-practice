package blind75;

import java.util.*;

public class PacificAtlanticWaterFlow {
    int[] xx = new int[]{1, 0, -1, 0};
    int[] yy = new int[]{0, 1, 0, -1};
    int rows, cols;

    Set<Pair> pacific = new HashSet<>();
    Set<Pair> atlantic = new HashSet<>();

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;

        for(int i = 0; i<rows; i++) {
            dfs(heights, i, 0, pacific);
            dfs(heights, i, cols-1, atlantic);
        }

        for(int i = 0; i<cols; i++) {
            dfs(heights, 0, i, pacific);
            dfs(heights, rows-1, i, atlantic);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i<rows; i++) {
            for (int j = 0; j<cols; j++) {
                Pair key = new Pair(i, j);
                if(pacific.contains(key) && atlantic.contains(key)) {
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }

    public void dfs(int[][] heights,  int i, int j, Set<Pair> visit) {
        Pair key = new Pair(i, j);
        if(visit.contains(key) || i< 0 || j<0 || i>= rows || j >= cols) {
            return;
        }
        visit.add(key);
        for(int k =0; k<4; k++) {
            int x = i + xx[k];
            int y = j + yy[k];
            if(x>=0 && y>=0 && x<rows && y <cols && heights[i][j] <= heights[x][y]) {
                dfs(heights, x, y, visit);
            }
        }
    }


    // hash code
    // equals
    static class Pair {
        int i, j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return i == pair.i && j == pair.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
}
