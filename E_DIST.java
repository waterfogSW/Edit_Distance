public class E_DIST {
    int m, n;
    int cost[][];
    char edit[][];
    String str1, str2;

    E_DIST(String _str1,String _str2) {
        m = _str1.length();
        n = _str2.length();
        cost = new int [m+1][n+1];      // Minimum Cost
    }

    private int min(int i, int c, int d) {
        if(i <= c && i <= d)
            return i;
        if(c <= i && c <= d)
            return c;
        else
            return d;
    }

    public int editDistDP(String str1, String str2) {
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0)
                    cost[i][j] = j;
                else if(j == 0)
                    cost[i][j] = i;

                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    cost[i][j] = cost[i - 1][j - 1];

                else
                    cost[i][j] = min( cost[i-1][j] + 1, 
                                    cost[i-1][j-1] + 2,
                                    cost[i][j - 1] + 1);
            }
        }
        return cost[m][n];
    }
}