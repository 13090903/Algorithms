public class DSU {
    static int[] parent;
    static int[] rank;
    static int[] size;
    static void makeSet(int v) {
        parent[v] = v;
        size[v] = 1;
    }

    static void union(int v, int u) {
        int a = find(v);
        int b = find(u);
        if (a != b) {
            if (rank[a] < rank[b]) {
                int tmp = b;
                b = a;
                a = tmp;
            }
            parent[b] = a;
            size[a] += size[b];
            if (rank[a] == rank[b]) {
                ++rank[a];
            }
        }
    }

    static int find(int v) {
        if (v == parent[v]) {
            return v;
        }
        return parent[v] = find(parent[v]);
    }

    static boolean get(int v, int u) {
        return find(v) == find(u);
    }


}
