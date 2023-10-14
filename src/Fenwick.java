public class Fenwick {

    static int[] a;
    static int[] f;
    static long sum(int r) {
        long res = 0;
        for (; r >= 0; r = r & (r + 1)) {
            res += f[r];
        }
        return res;
    }

    static long sum(int l, int r) {
        if (l > 0) {
            return sum(r) - sum(l - 1);
        } else {
            return sum(r);
        }
    }

    static void increase(int idx, int val) {
        a[idx] += val;

        for (; idx >= 0; idx = idx | (idx + 1)) {
            f[idx] += val;
        }
    }
}
