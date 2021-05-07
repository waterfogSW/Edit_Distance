public class E_DIST {
    int m, n;
    int cost[][];
    char edit[][];
    String str1, str2;

    E_DIST(String _str1,String _str2) {
        str1 = _str1;
        str2 = _str2;
        m = _str1.length();
        n = _str2.length();
        cost = new int [m+1][n+1];      // Minimum Cost
        edit = new char [m+1][n+1];     // Edit Type
    }

    private int minEdit(int ins, int chg, int del,int i, int j) {
        if(ins <= chg && ins <= del) {
            edit[i][j] = 'd';
            return ins;
        } else if(chg <= ins && chg <= del) {
            edit[i][j] = 'c';
            return chg;
        } else {
            edit[i][j] = 'i';
            return del;
        }
    }

    public int editDistDP() {
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    edit[i][j] = 'i';
                    cost[i][j] = j;
                }
                else if(j == 0) {
                    edit[i][j] = 'd';
                    cost[i][j] = i;
                }
                else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    edit[i][j] = 'c';
                    cost[i][j] = cost[i - 1][j - 1];
                }

                else
                    cost[i][j] = minEdit(cost[i-1][j] + 1,
                                    cost[i-1][j-1] + 2,
                                    cost[i][j - 1] + 1, i, j);
            }
        }
        edit[0][0] = ' ';
        return cost[m][n];
    }

    public char[] optOrder() {
        char[] temp = new char[m+n];
        int index = 0;
        int i = m;
        int j = n;

        temp[index++] = edit[i][j];
        while(i != 0 && j != 0) {
            int min = cost[i-1][j-1];
            
            if(i==0){
                temp[index++] = 'i';
                j--;
                continue;
            } else if(j==0) {
                temp[index++] = 'd';
                i--;
                continue;
            }

            if(cost[i-1][j] < min) {
                temp[index++] = edit[i-1][j];
                i--;
            } else if(cost[i][j-1] < min) {
                temp[index++] = edit[i][j-1];
                j--;
            } else {
                temp[index++] = edit[i-1][j-1];
                i--;
                j--;
            }
        }
        char[] order = new char[index];
        for (int k = 0; k < index; k++) {
            order[k] = temp[index-k];
        }
        System.out.println(index);
        return order;
    }
}