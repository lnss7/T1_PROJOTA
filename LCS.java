public class LCS {

    public static long iterations = 0;
    public static long lastTimeNs = 0;

    public static long iterationsDynamic = 0;
    public static long lastTimeNsDynamic = 0;

    public static String forcaBruta(String a, String b) {
        iterations = 0;
        long start = System.nanoTime();
        String seq = lcsRec(a, b, a.length() - 1, b.length() - 1);
        lastTimeNs = System.nanoTime() - start;
        return seq;
    }

    private static String lcsRec(String a, String b, int i, int j) {
        iterations++;
        if (i < 0 || j < 0)
            return "";

        if (a.charAt(i) == b.charAt(j)) {
            return lcsRec(a, b, i - 1, j - 1) + a.charAt(i);
        } else {
            String s1 = lcsRec(a, b, i - 1, j);
            String s2 = lcsRec(a, b, i, j - 1);
            if (s1.length() >= s2.length()) {
                return s1;
            } else {
                return s2;
            }
        }

    }

    public static String dynamic(String a, String b) {
        iterationsDynamic = 0;
        long start = System.nanoTime();
        String seq = lcsDynamic(a, b);
        lastTimeNsDynamic = System.nanoTime() - start;
        return seq;
    }

    private static String lcsDynamic(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                iterationsDynamic++; // conta operações do DP
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            iterationsDynamic++; // conta passos de reconstrucao
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                lcs.append(a.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        lcs.reverse();
        return lcs.toString();
    }
}
