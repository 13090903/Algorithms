public class BinarySearch {
    static int firstMore(int[] a, int x) {
        int l = -1;
        int r = a.length;
        while (r > l + 1) {
            int mid = (l + r) / 2;
            if (a[mid] > x) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return r;
    }
}
