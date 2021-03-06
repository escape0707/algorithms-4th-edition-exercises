/**
 * Euclid
 */
public class Euclid {
    public static int gcd(int p, int q) {
        StdOut.println(p + " " + q);
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        StdOut.println(gcd(p, q));
    }
}
