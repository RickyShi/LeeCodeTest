package repo_2018.islandPerimeter_463;

public class Solution {
    public int islandPerimeter(int[][] grid) {
        int border = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    if(i == 0 || grid[i-1][j] == 0) border++; // above water
                    if(j == 0 || grid[i][j-1] == 0) border++; // left water
                    if(j+1 == grid[i].length || grid[i][j+1] == 0) border++; // right water
                    if(i+1 == grid.length || grid[i+1][j] == 0) border++; // below water
                }
            }
        }
        return border;
    }
}
