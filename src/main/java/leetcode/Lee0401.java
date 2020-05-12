package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 节点间通路
 */
public class Lee0401 {
    public static void main(String[] args) {
        int n = 3;
        int[][] graph = {{0,1},{0,2},{1,2},{1,2}};
        int start = 0, end = 2;
        Lee0401 lee0401 = new Lee0401();
        boolean result = lee0401.findWhetherExistsPath(n, graph, 0, 2);
        System.out.println(result);
    }
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        if (graph == null || graph.length == 0 || graph[0] == null || graph[0].length == 0) {
            return false;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int from = graph[i][0];
            int to = graph[i][1];
            if(!map.containsKey(from)) {
                map.put(from, new ArrayList());
            }
            map.get(from).add(to);
        }
        int[] visited = new int[n];
        visited[start] = 1;
        return getPath(map, start, target, visited);
    }

    private boolean getPath(Map<Integer, List<Integer>> map, int start, int target, int[] visited) {
        if(start == target) {
            return true;
        }
        List<Integer> destList = map.get(start);
        if(destList == null) {
            return false;
        }
        boolean result = false;
        for(int i = 0; i < destList.size(); i++) {
            if(visited[destList.get(i)] == 0) {
                visited[destList.get(i)] = 1;
                result = result || getPath(map, destList.get(i), target, visited);
                visited[destList.get(i)] = 0;
            }
        }
        return result;
    }
}
