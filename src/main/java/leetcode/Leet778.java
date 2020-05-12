package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *水位上升的游泳池中游泳
 * 找到一个路径，从（0，0）到（N,N）使得里面的最大值是所有路径里面的最小值。
 * 1、暴力方法，超时了
 * 2、迪杰斯特拉
 *
 *
 */
public class Leet778 {
    public static void main(String[] args) {
        Leet778 leet778 = new Leet778();
        int[][] grid = {{0,2},{1,3}};
        int i = leet778.swimInWater(grid);
        System.out.println(i);
    }
    public int swimInWater(int[][] grid) {
        List<Integer> tmp = new ArrayList<>();
        int length = grid.length;
        int[][] visited = new int[length][length];
        int[] max = new int[1];//保存当前路径的最大值
        max[0] = Integer.MAX_VALUE;
        dfs(grid, 0, 0, visited, max, length, tmp);
        return max[0];
    }

    //暴力算法， 找到所有的路径中的最大值中的最小值
    private void dfs(int[][] grid, int row, int col, int[][] visited, int[] min, int length,
                     List<Integer> tmp) {
        if(row < 0 || row >= length || col < 0 || col >= length) {
            return;
        }
        if(row == length - 1 && col == length - 1) {
            tmp.add(grid[row][col]);
            visited[row][col] = 1;
            min[0] = Math.min(min[0], Collections.max(tmp));
            tmp.remove(tmp.size() - 1);
            visited[row][col] = 0;
            return;
        }
        if(visited[row][col] == 1) return;
        if(grid[row][col] >= min[0]) return;//剪枝
        tmp.add(grid[row][col]);
        visited[row][col] = 1;
        dfs(grid, row - 1, col, visited, min, length, tmp);
        dfs(grid, row, col + 1, visited, min, length, tmp);
        dfs(grid, row + 1, col, visited, min, length, tmp);
        dfs(grid, row, col - 1, visited, min, length, tmp);
        tmp.remove(tmp.size() - 1);
        visited[row][col] = 0;
    }
}
