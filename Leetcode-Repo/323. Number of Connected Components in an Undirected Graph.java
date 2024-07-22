class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Set<Integer> set = new HashSet<>();
        int temp;
        for (int[] edge : edges) {
            temp = parent[edge[0]];
            parent[edge[0]] = parent[edge[1]];
            for (int i = 0; i < n; i++) {
                if (parent[i] == temp) {
                    parent[i] = parent[edge[1]];
                }
            }
        }
        Arrays.stream(parent).forEach(set::add);
        return set.size();
    }
}