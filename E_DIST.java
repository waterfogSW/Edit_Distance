import java.util.Scanner;

public class E_DIST {
    static int min(int x, int y, int z) {
        if(x <= y && x <= z)
            return x;
        if(y <= x && y <= z)
            return y;
        else
            return z;
    }
    static int editDistDP(String str1, String str2, int m, int n) {
        int dp[][] = new int [m+1][n+1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) 
                    dp[i][j] = j;
                else if(j == 0)
                    dp[i][j] = i;
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];

                else
                    dp[i][j] = min( dp[i - 1][j] + 1, 
                                    dp[i-1][j-1] + 2,
                                    dp[i][j - 1] + 1);
            }
        }
        System.out.println("----------");
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------");
        return dp[m][n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("String 1  : ");
        String str1 = sc.nextLine();
        System.out.print("String 2  : ");
        String str2 = sc.nextLine();
        sc.close();

        System.out.println("Min cost : " + 
            editDistDP(str1, str2, str1.length(), str2.length()));
            
    }
}