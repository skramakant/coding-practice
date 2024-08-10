package blind75;

public class NumberOfIslands {

    int[] x = new int[]{0, 1, -1, 0};
    int[] y  = new int[]{1, 0, 0, -1};

    int r = 0;
    int c = 0;

    public int numIslands(char[][] grid) {
        r = grid.length;
        c = grid[0].length;

        int count = 0;

        for(int i =0 ; i<r; i++) {
            for(int j = 0; j<c; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid);
                }
            }
        }

        return count;
    }

    public void dfs(int i, int j, char[][] grid) {
        if(grid[i][j] != '1') {
            return;
        }
        if(grid[i][j] == '1') {
            grid[i][j] = '0';
            for(int k =0; k<4; k++) {
              int xx = i + x[k];
              int yy = j + y[k];
              if(xx >=0 && yy >= 0 && xx <r && yy<c && grid[xx][yy] != '0' ) {
                  dfs(xx, yy, grid);
              }
            }
        }
    }
}
