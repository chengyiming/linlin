package leetcode;

import java.util.Arrays;

/**
 * 冗余连接II
 * 使用拓扑排序
 */
public class Leet685 {
    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{2,3}};
        Leet685 leet685 = new Leet685();
        int[] result = leet685.findRedundantDirectedConnection(edges);
        for(int i : result) {
            System.out.println(i);
        }
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] result = new int[2];
        if(edges == null || edges.length == 0 || edges[0] == null || edges[0].length == 0) {
            return result;
        }
        int length = edges.length;
        int[] parent = new int[length + 1];//为了找并查集
        int[] roots = new int[length + 1];//集合中每一个元素的根
        int[] sizes = new int[length + 1];//每一个集合的大小
        Arrays.fill(sizes, 1);
        int[] ans1 = null;
        int[] ans2 = new int[2];
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if(parent[v] > 0) {
                //已经有了一个父亲了
                ans1 = new int[]{parent[v], v};
                ans2 = Arrays.copyOf(edge, 2);
                edge[0] = -1;
                edge[1] = -1;//砍掉这个边
            }
            parent[v] = u;
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if(u == -1 && v == -1) continue;
            roots[u] = roots[u] == 0 ? u : roots[u];
            roots[v] = roots[v] == 0 ? v : roots[v];
            int pu = find(u, roots);
            int pv = find(v, roots);//找到对应的根
            if(pu == pv) {
                //发现有环
                return ans1 == null ? edge : ans1;
            }
            //pv是小的根，pu是大的根
            if(sizes[pv] > sizes[pu]) {
                int tmp = pu;
                pu = pv;
                pv = tmp;
            }
            roots[pv] = pu;
            sizes[pu] +=sizes[pv];
        }
        return ans2;
    }

    private int find(int node, int[] roots) {
        while (roots[node] != node) {
            roots[node] = roots[roots[node]];
            node = roots[node];
        }
        return node;
    }
}
