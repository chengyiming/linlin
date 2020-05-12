package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 联通网络的操作次数
 */
public class Leet1319 {
    public static void main(String[] args) {
        Leet1319 leet1319 = new Leet1319();
        int n = 6;
        int[][] connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};
        int i = leet1319.makeConnected(n, connections);
        System.out.println(i);
    }



    public int makeConnected(int n, int[][] connections) {
        Set<Integer> nodeSet = new HashSet<>();
        int[] parent = new int[n];
        //自己成为一个集合
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int[] size = new int[n];
        Arrays.fill(size, 1);//初始大小都是1
        int freeConn = 0;
        //1、使用并查集，找到多余的连接数,给每一个元素找到对应的集合
        for(int[] edge : connections) {
            int v = edge[0];//子
            int u = edge[1];//父
            int pv = find(v, parent);
            int pu = find(u, parent);
            if(pv == pu) {
                //多余的连接数增加
                freeConn++;
            }else {
                //如果不是一个集合，连接两个集合
                if(size[pv] > size[pu]) {
                    int tmp = pv;
                    pv = pu;
                    pu = tmp;
                }
                parent[pv] = pu;
                size[pu] += size[pv];
            }

        }
        //2、再次遍历，查看有多少单独的集合
        for(int i = 0; i < n ; i++) {
            int r = find(i, parent);
            nodeSet.add(r);
        }
        //2、在第一步，找到使用的元素以及没有使用的元素
        //不够用
        if(freeConn < nodeSet.size() - 1) {
            return -1;
        }
        return nodeSet.size() - 1;
    }




    private int find(int node, int[] parent) {
        while(parent[node] != node) {
            parent[node] = parent[parent[node]];
            node = parent[node];
        }
        return node;
    }
}
