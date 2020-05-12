package leetcode;

/**
 * 冗余连接
 */
public class Lee684 {
    public static void main(String[] args) {
        Lee684 lee684 = new Lee684();
        int[][] edges = {{3,4},{1,2},{2,4},{3,5},{2,5}};
        int[] result = lee684.findRedundantConnection(edges);
        for(int i : result) {
            System.out.println(result);
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int[] result = new int[2];
        if(edges == null || edges.length == 0 || edges[0] == null || edges[0].length == 0) {
            return null;
        }
        int length = edges.length;//3
        int[] visited = new int[length + 1];//0,1,2,3
        int[] vector = new int[length + 1];
        for(int i = 1; i <= length; i++) {
            vector[i] = i;//每一个是单独的集合
        }

        for(int i = 0; i < length; i++) {
            int from = edges[i][0];//小
            int to = edges[i][1];//大
            int topA = getHead(vector, from);
            int topB = getHead(vector, to);
            if(visited[from] == 1 && visited[to] == 1 && topA == topB) {
                //同一个集合中都被访问了
                result[0] = from;
                result[1] = to;
                return result;
            }else {
                visited[from] = 1;
                visited[to] = 1;
                vector[topA] = topB;//构建关系
            }
        }
        return result;
    }

    //得到并查集的顶部元素
    private int getHead(int[] vector, int num) {
        while(vector[num] != num) {
            num = vector[num];
        }
        return num;
    }
}
