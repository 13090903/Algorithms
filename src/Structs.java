public class Structs {
    static class Pair implements Comparable<Pair> {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int compareTo(Pair p) {
            if (first != p.first)
                return Integer.compare(first, p.first);
            else if (second != p.second)
                return Integer.compare(second, p.second);
            else
                return 0;
        }

        public String toString() {
            return this.first + " " + this.second;
        }
    }

    static class Tuple implements Comparable<Tuple> {
        long first;
        long second;
        long third;

        public Tuple(long a, long b, long c) {
            first = a;
            second = b;
            third = c;
        }

        public int compareTo(Tuple t) {
            if (first != t.first)
                return Long.compare(first, t.first);
            else if (second != t.second)
                return Long.compare(second, t.second);
            else if (third != t.third)
                return Long.compare(third, t.third);
            else
                return 0;
        }
    }
}
