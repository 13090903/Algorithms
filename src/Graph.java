import java.util.ArrayList;
import java.util.List;

public class Graph {
    static class Node {
        int val;
        boolean visited;
        int dist;

        List<Node> neighbours = new ArrayList<>();

        public Node(int val) {
            this.val = val;
        }
    }
}
