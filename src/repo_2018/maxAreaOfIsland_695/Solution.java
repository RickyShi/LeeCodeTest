package repo_2018.maxAreaOfIsland_695;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        Solution solution = new Solution();
        System.out.println("Method1: " + solution.new SolutionRecursive1().maxAreaOfIsland(grid));
        System.out.println("Method2: " + solution.new SolutionRecursive2().maxAreaOfIsland(grid));
        grid = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        System.out.println("Method3: " + solution.new SolutionIterative3_DFS().maxAreaOfIsland(grid));
        System.out.println("Method3: " + solution.new SolutionIterative4_BFS().maxAreaOfIsland(grid));
    }

    /**
     * Approach #1: Depth-First Search (Recursive) [Accepted]
     * Intuition and Algorithm
     * <p>
     * We want to know the area of each connected shape in the grid, then take the maximum of these.
     * <p>
     * If we are on a land square and explore every square connected to it 4-directionally (and recursively squares connected to those squares, and so on), then the total number of squares explored will be the area of that connected shape.
     * <p>
     * To ensure we don't count squares in a shape more than once, let's use seen to keep track of squares we haven't visited before. It will also prevent us from counting the same shape more than once.
     * <p>
     * Time: O(R*C) Space O(R*C)
     */
    public class SolutionRecursive1 {

        boolean[][] seen;
        int[][] grid;

        public int maxAreaOfIsland(int[][] grid) {
            int rtn = 0;
            this.seen = new boolean[grid.length][grid[0].length];
            this.grid = grid;
            for (int r = 0; r < grid.length; r++) {
                for (int c = 0; c < grid[0].length; c++) {
                    rtn = Math.max(rtn, area(r, c));
                }
            }
            return rtn;
        }

        public int area(int r, int c) {
            if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || seen[r][c] || grid[r][c] == 0) {
                return 0;
            }
            seen[r][c] = true;
            return 1 + area(r - 1, c) + area(r + 1, c) + area(r, c - 1) + area(r, c + 1);
        }
    }

    /**
     * Same Idea, just change grid value to be 0 after visited, instead of using boolean array to track. saving space complexity.
     * Space O(1)
     */
    public class SolutionRecursive2 {

        public int maxAreaOfIsland(int[][] grid) {
            int rtn = 0;
            for (int r = 0; r < grid.length; r++) {
                for (int c = 0; c < grid[0].length; c++) {
//                    int[][] tmp = grid;
                    rtn = Math.max(rtn, area(r, c, grid));
                }
            }
            return rtn;
        }

        public int area(int r, int c, int[][] grid) {
            if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
                return 0;
            }
            grid[r][c] = 0;
            return 1 + area(r - 1, c, grid) + area(r + 1, c, grid) + area(r, c - 1, grid) + area(r, c + 1, grid);
        }
    }

    /**
     * Approach #3: Depth-First Search (Iterative) [Accepted]
     * Intuition and Algorithm
     * <p>
     * We can try the same approach using a stack based, (or "iterative") depth-first search.
     * <p>
     * Here, seen will represent squares that have either been visited or are added to our list of squares to visit (stack). For every starting land square that hasn't been visited, we will explore 4-directionally around it, adding land squares that haven't been added to seen to our stack.
     * <p>
     * On the side, we'll keep a count shape of the total number of squares seen during the exploration of this shape. We'll want the running max of these counts.
     */
    public class SolutionIterative3_DFS {
        public int maxAreaOfIsland(int[][] grid) {
            boolean[][] seen = new boolean[grid.length][grid[0].length];
            //dr, dc are offset values for 4 directions
            int[] dr = new int[]{1, -1, 0, 0};
            int[] dc = new int[]{0, 0, 1, -1};
            int rtn = 0;

            for (int r = 0; r < grid.length; r++) {
                for (int c = 0; c < grid[0].length; c++) {
                    if (!seen[r][c] && grid[r][c] != 0) {
                        int size = 0;
                        Stack<int[]> stack = new Stack<>();
                        stack.push(new int[]{r, c});
                        seen[r][c] = true;
                        while (!stack.isEmpty()) {
                            int[] cur = stack.pop();
                            size++;
                            int r1 = cur[0];
                            int c1 = cur[1];
                            for (int i = 0; i < 4; i++) {
                                int r2 = r1 + dr[i];
                                int c2 = c1 + dc[i];
                                if (r2 >= 0 && r2 < grid.length && c2 >= 0 && c2 < grid[0].length && !seen[r2][c2] && grid[r2][c2] != 0) {
                                    stack.push(new int[]{r2, c2});
                                    seen[r2][c2] = true;
                                }
                            }
                        }
                        rtn = Math.max(rtn, size);
                    }
                }
            }
            return rtn;
        }
    }

    /**
     * Approach #4: Breadth-First Search (Iterative) [Accepted]
     */
    public class SolutionIterative4_BFS {
        public int maxAreaOfIsland(int[][] grid) {
            boolean[][] seen = new boolean[grid.length][grid[0].length];
            //dr, dc are offset values for 4 directions
            int[] dr = new int[]{1, -1, 0, 0};
            int[] dc = new int[]{0, 0, 1, -1};
            int rtn = 0;

            for (int r = 0; r < grid.length; r++) {
                for (int c = 0; c < grid[0].length; c++) {
                    if (!seen[r][c] && grid[r][c] != 0) {
                        int size = 0;
                        Queue<int[]> queue = new LinkedList<>();
                        queue.offer(new int[]{r, c});
                        seen[r][c] = true;
                        while (!queue.isEmpty()) {
                            int[] cur = queue.poll();
                            size++;
                            int r1 = cur[0];
                            int c1 = cur[1];
                            for (int i = 0; i < 4; i++) {
                                int r2 = r1 + dr[i];
                                int c2 = c1 + dc[i];
                                if (r2 >= 0 && r2 < grid.length && c2 >= 0 && c2 < grid[0].length && !seen[r2][c2] && grid[r2][c2] != 0) {
                                    queue.offer(new int[]{r2, c2});
                                    seen[r2][c2] = true;
                                }
                            }
                        }
                        rtn = Math.max(rtn, size);
                    }
                }
            }
            return rtn;
        }

    }


}
