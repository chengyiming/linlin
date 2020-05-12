package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 火柴拼正方形
 */
class Lee473 {
    public static void main(String[] args) {

        int[] nums = {1,0,2,2,2};
        Lee473 lee = new Lee473();
        System.out.println(nums);
        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(collect, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        nums = collect.stream().mapToInt(Integer::valueOf).toArray();
        boolean makesquare = lee.makesquare(nums);

        System.out.println(makesquare);
    }
    public boolean makesquare(int[] nums) {
        int sum = 0;
        int length = nums.length;
        for(int i = 0; i < length; i++) {
            sum += nums[i];
        }
        if(sum  % 4 != 0) {
            return false;
        }
        int edge = sum / 4;
        return isSquare(nums, length, 0, 0, 0, 0, 0, edge);
    }

    public boolean isSquare(int[] nums, int length, int i, int a, int b, int c, int d, int edge) {
        if(i == length) {
            if(a == edge && b == edge && c == edge && d == edge) {
                return true;
            }

        }
        if(a > edge || b > edge || c > edge || d > edge) {
            return false;
        }
        return isSquare(nums, length, i+1, a + nums[i], b, c, d, edge) ||
                isSquare(nums, length, i+1, a, b + nums[i], c, d, edge) ||
                isSquare(nums, length, i+1, a, b, c + nums[i], d, edge) ||
                isSquare(nums, length, i+1, a, b, c, d + nums[i], edge);
    }
}