package pdd;

import java.util.Scanner;



import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[][] arr = new int[T][3];
        for(int i = 0; i < T;i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
            arr[i][2] = scanner.nextInt();
        }
        String[] result = new String[T];
        for(int i = 0; i < T; i++) {
            result[i] = getDevide(arr[i][0], arr[i][1], arr[i][2]) == true? "YES":"NO";
        }
        for(String i : result) {
            System.out.println(i);
        }
    }

    private static boolean getDevide(int a, int b, int N) {
        if(N == 0) {
            return isValid(String.valueOf(a));
        }
        if(N == 1) {
            return isValid(String.valueOf(b));
        }
        int k = 2;
        while(k <= N) {
            int tmp = b % 3;
            b = a % 3 + tmp;
            a = tmp;//完成增加
            if(a == 0 && b == 0) {
                return true;
            }
            k++;
        }
        return b % 3 == 0;
    }

    private static boolean isValid(String str) {
        int num = 0;
        for(int i = 0; i < str.length(); i++) {
            num += str.charAt(i) - '0';
        }
        return num % 3 == 0;
    }
}


/*
3
1 1 3
1 1 4
7 11 2
 */

