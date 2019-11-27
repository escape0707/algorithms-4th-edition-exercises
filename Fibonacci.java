/**
 * Fibonacci
 * @@implNote N = 47 is pretty slow for the recursive version of F
 */
public class Fibonacci {
    public static long F(int N) {
        // array version is not necessary for now.
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        long a = 0, b = 1, ret = a + b;
        for (int i = 2; i < N; i++) {
            a = b;
            b = ret;
            ret = a + b;
        }
        return ret;
    }

    public static void main(String[] args) {
        for (int N = 0; N < 100; N++) {
            StdOut.println(N + " " + F(N));
        }
    }
}
