package pdd;

import java.util.Scanner;

public class Solution4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr  = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] =  scanner.nextInt();
        }
        System.out.println(getMax(arr, N));
    }
    private static int getMax(int[] arr, int N) {
        int[] f = new int[N];
        int a = arr[0];
        for(int i = 1; i < N; i++) {

        }

        return 1;
    }


    // 最大公约数：循环法求
    public static int MaxCom(int m, int n) {
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        while (m % n != 0) {
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;
    }


}
