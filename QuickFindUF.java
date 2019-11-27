/**
 * QuickFindUF
 */
public class QuickFindUF {

    private int[] fa, sz;

    public QuickFindUF(int N) {
        fa = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            fa[i] = i;
        }
    }

    private int root(int i) {
        while (i != fa[i]) {
            fa[i] = fa[fa[i]];
            i = fa[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) {
            return;
        }
        if (sz[i] < sz[j]) {
            fa[i] = j;
            sz[j] += sz[i];
        } else {
            fa[j] = i;
            sz[i] += sz[j];
        }
    }
}
