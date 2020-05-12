package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 785. 判断二分图
 * 使用深度优先搜索的方法
 */
public class Lee785 {
    Set<Integer> ASet = new HashSet<>();
    Set<Integer> BSet = new HashSet<>();
    Set<Integer> tmpSet;
    public boolean isBipartite(int[][] graph) {
        if(graph == null || graph.length == 0 || graph[0] == null || graph[0].length == 0) {
            return false;
        }
        int length = graph.length;
        int[] visit = new int[length];
        ASet.add(0);
        boolean binGraph = isBinGraph(graph, ASet, 0, visit);
        return binGraph;
    }

    private boolean isBinGraph(int[][] graph, Set<Integer> set, int start,int[] visit) {

        if (set == ASet) {
            tmpSet = BSet;
        }else if(set == BSet) {
            tmpSet = ASet;
        }
        int[] toArray = graph[start];

        for(int i = 0; i < toArray.length; i++) {
            int aim = toArray[i];
            if(visit[aim] == 0) {
                visit[aim] = 1;
                tmpSet.add(aim);
                return isBinGraph(graph, tmpSet, aim, visit);
            }else {
                if(ASet.contains(aim) && tmpSet == ASet || BSet.contains(aim) && tmpSet == BSet) {
                    return false;
                }
            }
        }
        return true;
    }
}
