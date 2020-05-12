package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 最长连续序列
 */
public class Leet128 {
    private int maxSize = 1;
   /* public static void main(String[] args) {
        Leet128 leet128 = new Leet128();
        int[] nums = {100, 4, 200, 1, 3, 2};
        int i = leet128.longestConsecutive(nums);
        System.out.println(i);
    }*/
    public int longestConsecutive(int[] nums) {

        //初始化所有的数据为单独的并查集
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        Map<Integer, Integer> root = new HashMap<>();
        Map<Integer, Integer> size = new HashMap<>();

        for(int i = 0; i < length; i++) {
            root.put(nums[i], nums[i]);
            size.put(nums[i], 1);//都初始化为1

        }
        //从头到尾进行遍历，构建每一个集合，调整maxSize的大小
        for(int i = 0; i < length ; i++) {
            int tmp = nums[i];
            union(tmp, tmp - 1, root, size);
            union(tmp, tmp + 1, root, size);



            if(root.containsKey(tmp + 1)) {
                int rr = find(root, tmp + 1);
                int rb = find(root, tmp + 1);//找到对应的根
                //不是同一个根的时候
                if(rr != rb) {
                    //交换，rr成为较小的一支
                    if(size.get(rr) > size.get(rb)) {
                        int j = rb;
                        rb = rr;
                        rr = j;
                    }
                    //合并
                    root.put(rr, rb);
                    size.put(rb, size.get(rr) + size.get(rb));
                    maxSize = Math.max(maxSize, size.get(rb));
                }
            }
        }
        return maxSize;
    }

    //子——父
    private int find(Map<Integer, Integer> root, int node) {
        while(root.get(node) != node) {
            root.put(node, root.get(root.get(node)));
            node = root.get(node);
        }
        return node;
    }
    private void union(int tmp, int num, Map<Integer, Integer> root, Map<Integer, Integer> size) {
        if (root.containsKey(num)) {
            int rr = find(root, tmp);
            int ra = find(root, num);//找到对应的根
            if(rr != ra) {
                //交换，rr成为较小的一支
                if(size.get(rr) > size.get(ra)) {
                    int j = ra;
                    ra = rr;
                    rr = j;
                }
                //进行合并
                root.put(rr, ra);
                //map.get(a) = b能不能修改map??
                size.put(ra, size.get(rr) + size.get(ra));
                maxSize = Math.max(maxSize, size.get(ra));
            }
        }
    }
}
