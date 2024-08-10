package org.example;

import java.util.*;

public class NumberClosedIsland {
    int[] xc = new int[]{1, 0, -1, 0};
    int[] xy = new int[]{0, 1, 0, -1};

    public NumberClosedIsland() {
        // constructor
    }

    public int closedIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < col; i++) {
            if (grid[0][i] == 1) {
                bfs(new NodeInsland(0, i), grid, row, col);
            }

            if (grid[row - 1][i] == 1) {
                bfs(new NodeInsland(row - 1, i), grid, row, col);
            }
        }

        for (int j = 0; j < row; j++) {
            if (grid[j][0] == 1) {
                bfs(new NodeInsland(j, 0), grid, row, col);
            }

            if (grid[j][col - 1] == 1) {
                bfs(new NodeInsland(j, col - 1), grid, row, col);
            }
        }

        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    res++;
                    bfs(new NodeInsland(i, j), grid, row, col);
                }
            }
        }

        return res;
    }

    public void bfs(NodeInsland node, int[][] grid, int row, int col) {
        LinkedList<NodeInsland> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            NodeInsland tempNode = queue.removeFirst();
            grid[tempNode.x][tempNode.y] = 0;
            for (int i = 0; i < 4; i++) {
                int xx = xc[i] + tempNode.x;
                int yy = xy[i] + tempNode.y;

                if (xx >= 0 && xx < row && yy >= 0 && yy < col && grid[xx][yy] == 1) {
                    grid[xx][yy] = 0;
                    queue.add(new NodeInsland(xx, yy));
                }
            }
        }
    }

}

class NodeInsland {
    int x;
    int y;

    public NodeInsland(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
