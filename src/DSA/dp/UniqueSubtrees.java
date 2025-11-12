package DSA.dp;
import java.util.*;

public class UniqueSubtrees {

    public int Count_subtree(int N, int[] nodeValues, int[][] edges) {
        Map<Integer, List<Integer>> tree = new HashMap<>();
        Set<String> uniqueSubtrees = new HashSet<>();

        // Build adjacency list
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            tree.computeIfAbsent(u, x -> new ArrayList<>()).add(v);
            tree.computeIfAbsent(v, x -> new ArrayList<>()).add(u);
        }

        // Run DFS from node 1 (assuming 1-indexed)
        dfs(1, 0, nodeValues, tree, uniqueSubtrees);
        return uniqueSubtrees.size();
    }

    private String dfs(int node, int parent, int[] nodeValues,
                       Map<Integer, List<Integer>> tree, Set<String> uniqueSubtrees) {

        List<String> childHashes = new ArrayList<>();

        for (int child : tree.getOrDefault(node, Collections.emptyList())) {
            if (child != parent) {
                childHashes.add(dfs(child, node, nodeValues, tree, uniqueSubtrees));
            }
        }

        // Sort child subtrees to ensure consistent structure
        Collections.sort(childHashes);
        String subtree = nodeValues[node - 1] + "(" + String.join(",", childHashes) + ")";

        uniqueSubtrees.add(subtree);
        return subtree;
    }

    // ---- Example Usage ----
    public static void main(String[] args) {
        UniqueSubtrees sol = new UniqueSubtrees();

        int N = 4;
        int[] nodeValues = {5, 5, 3, 3};
        int[][] edges = {
                {1, 2},
                {1, 3},
                {3, 4}
        };

        System.out.println(sol.Count_subtree(N, nodeValues, edges)); // Output: 4
    }
}
