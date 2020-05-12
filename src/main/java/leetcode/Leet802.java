package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到最终的安全状态
 */
public class Leet802 {
    public static void main(String[] args) {
        Leet802 leet802 = new Leet802();
        int[][] graph = {{},{0, 2,3, 4},{3},{4},{}};
        List<Integer> list = leet802.eventualSafeNodes(graph);
        System.out.println(list);
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        if(graph == null || graph.length == 0) {
            return result;
        }
        int length = graph.length;//表示元素的个数
        int[] visited = new int[length];
        for(int i = 0; i< length; i++) {
            visited[i] = 1;
            if(dfs(graph, i, visited) == true) {
                result.add(i);
            }
            visited[i] = 0;
        }
        return result;
    }

    /*
    i位置是不是安全点
     */
    private boolean dfs(int[][] graph, int i, int[] visited) {

        int[] destList = graph[i];//会到达的目标

        for(int t = 0; t < destList.length; t++) {
            int aim = destList[t];
            if(visited[aim] == 0) {
                visited[aim] = 1;//表示已经访问了
                if(dfs(graph, aim, visited) == false) {
                    return false;
                }
                visited[aim] = 0;
            }else {
                return false;//出现了环路
            }

        }
        return true;
    }
}
