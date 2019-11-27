
/**
 * BinarySearch
 */
import java.util.Arrays;

public class BinarySearch {

    public static int rank(int key, int[] a) {
        int low = 0;
        int high = a.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (key < a[mid]) {
                high = mid;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int countLessThan(int key, int[] a) {
        double k = key - 0.5;
        int low = 0;
        int high = a.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (k < a[mid]) {
                high = mid;
            } else if (k > a[mid]) {
                low = mid + 1;
            }
        }
        return high;
    }

    public static int count(int key, int[] a) {
        return countLessThan(key + 1, a) - countLessThan(key, a);
    }

    private static int[] readAllInts(String filename) {
        int[] input = new In(filename).readAllInts();
        Arrays.sort(input);
        int sz = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] != input[sz]) {
                input[++sz] = input[i];
            }
        }
        ++sz;
        int[] whitelist = new int[sz];
        for (int i = 0; i < sz; i++) {
            whitelist[i] = input[i];
        }
        return whitelist;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        //
        int[] whitelist = readAllInts(args[0]);
        //
        boolean blockMode = true;
        if (args.length > 1) {
            blockMode = args[1].equals("+");
            if (!blockMode && !args[1].equals("-")) {
                throw new IllegalArgumentException("Second argument must be '+' or '-'!");
            }
        }
        //
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            boolean found = rank(key, whitelist) >= 0;
            if (blockMode && !found || !blockMode && found) {
                StdOut.println(key);
            }
        }
        //
        long endTime = System.nanoTime();
        StdOut.println("Time difference = " +  (endTime - startTime) + "[ns]");
        // Time difference = 17458320862[ns]
    }
}
